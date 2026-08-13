package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.dto.AppointmentRequestDTO;
import com.diabetic.demo.entity.Appointment;
import com.diabetic.demo.entity.Doctor;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.AppointmentRepository;
import com.diabetic.demo.repository.DoctorRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

 
    public Appointment saveAppointment(Long userId,Long doctorId,AppointmentRequestDTO dto) {

    
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id : " + userId));

   
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with id : " + doctorId));

        if (!doctor.isAvailable()) {
        	throw new RuntimeException("Doctor is currently not available");
        }

    
        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(dto.getAppointmentDate());

        appointment.setAppointmentTime(dto.getAppointmentTime());

        appointment.setAppointmentType(dto.getAppointmentType());

        appointment.setReason(dto.getReason());

        appointment.setNotes(dto.getNotes());

        appointment.setStatus("PENDING");
        appointment.setUser(user);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {

        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found with id : " + id));
    }

   
    public Appointment updateAppointment(AppointmentRequestDTO dto,Long id) {
    	
        Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found with id : " + id));

        existingAppointment.setAppointmentDate(dto.getAppointmentDate());
        existingAppointment.setAppointmentTime(dto.getAppointmentTime());
        existingAppointment.setAppointmentType(dto.getAppointmentType());
        existingAppointment.setReason(dto.getReason());
        existingAppointment.setNotes(dto.getNotes());

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id) {

        Appointment existingAppointment =appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found with id : " + id));
        appointmentRepository.delete(existingAppointment);
    }
}