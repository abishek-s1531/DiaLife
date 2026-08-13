package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.Doctor;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Doctor doctor, Long id);

    void deleteDoctor(Long id);
}