package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.entity.Doctor;
import com.diabetic.demo.service.DoctorService;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

   
    @PostMapping("/add")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

   
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {

        return doctorService.getAllDoctors();
    }

  
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {

        return doctorService.getDoctorById(id);
    }

  
    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {

        return doctorService.updateDoctor(doctor, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {

            doctorService.deleteDoctor(id);
             return "Doctor deleted successfully";
    }
}