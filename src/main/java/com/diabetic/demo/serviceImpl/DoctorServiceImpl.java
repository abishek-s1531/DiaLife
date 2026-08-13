package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.Doctor;
import com.diabetic.demo.repository.DoctorRepository;
import com.diabetic.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

   
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

  
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    
    public Doctor getDoctorById(Long id) {

        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Doctor not found with id : " + id));
    }

  
    public Doctor updateDoctor(Doctor doctor, Long id) {

        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with id : " + id));

        existingDoctor.setName(doctor.getName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setQualification(doctor.getQualification());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setHospitalName(doctor.getHospitalName());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setConsultationType(doctor.getConsultationType());
        existingDoctor.setConsultationFee(doctor.getConsultationFee());
        existingDoctor.setAvailable(doctor.isAvailable());

        return doctorRepository.save(existingDoctor);
    }


    public void deleteDoctor(Long id) {

        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with id : " + id));
        doctorRepository.delete(existingDoctor);
    }
}