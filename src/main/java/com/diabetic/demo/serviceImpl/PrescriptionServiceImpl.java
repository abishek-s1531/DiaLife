package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.Appointment;
import com.diabetic.demo.entity.Doctor;
import com.diabetic.demo.entity.Prescription;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.AppointmentRepository;
import com.diabetic.demo.repository.DoctorRepository;
import com.diabetic.demo.repository.PrescriptionRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

  
    public Prescription savePrescription( Long userId,Long doctorId,Long appointmentId,Prescription prescription) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id : " + userId));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException( "Doctor not found with id : " + doctorId));
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found with id : " + appointmentId));

        prescription.setUser(user);
        prescription.setDoctor(doctor);
        prescription.setAppointment(appointment);

        return prescriptionRepository.save(prescription);
    }

   
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

  
    public Prescription getPrescriptionById(Long id) {

        return prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found with id : " + id));
    }

   
    public Prescription updatePrescription(Prescription prescription,Long id) {

        Prescription existingPrescription =prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found with id : " + id));

        existingPrescription.setMedicineName(prescription.getMedicineName());
        existingPrescription.setDosage( prescription.getDosage());
        existingPrescription.setFrequency(prescription.getFrequency());
        existingPrescription.setDuration(prescription.getDuration());
        existingPrescription.setInstructions(prescription.getInstructions());
        existingPrescription.setPrescribedDate(prescription.getPrescribedDate());

        return prescriptionRepository.save(existingPrescription);
    }

    public void deletePrescription(Long id) {

        Prescription existingPrescription =prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found with id : " + id));
        prescriptionRepository.delete(existingPrescription);
    }
}
