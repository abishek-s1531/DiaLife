package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.entity.Prescription;
import com.diabetic.demo.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/add/{userId}/{doctorId}/{appointmentId}")
    public Prescription savePrescription(@PathVariable Long userId,@PathVariable Long doctorId,@PathVariable Long appointmentId,@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(userId,doctorId,appointmentId,prescription);
    }

    @GetMapping("/all")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

   
    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }

    
    @PutMapping("/update/{id}")
    public Prescription updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {

        return prescriptionService.updatePrescription(prescription, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePrescription(@PathVariable Long id) {

        prescriptionService.deletePrescription(id);
        return "Prescription deleted successfully";
    }
}
