package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.Medication;

public interface MedicationService {

    Medication saveMedication(Long userId, Medication medication);

    List<Medication> getAllMedications();

    Medication getMedicationById(Long id);

    Medication updateMedication(Medication medication, Long id);

    void deleteMedication(Long id);
}