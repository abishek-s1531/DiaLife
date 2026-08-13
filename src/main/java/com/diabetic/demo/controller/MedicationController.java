package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.entity.Medication;
import com.diabetic.demo.service.MedicationService;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;


    @PostMapping("/add/{userId}")
    public Medication saveMedication(@PathVariable Long userId,@RequestBody Medication medication) {

        return medicationService.saveMedication(userId, medication);
    }

    @GetMapping("/all")
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

  
    @GetMapping("/{id}")
    public Medication getMedicationById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

  
    @PutMapping("/update/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody Medication medication) {

        return medicationService.updateMedication(medication, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedication(@PathVariable Long id) {

        medicationService.deleteMedication(id);
        return "Medication deleted successfully";
    }
}
