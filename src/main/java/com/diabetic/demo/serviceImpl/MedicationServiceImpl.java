package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.Medication;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.MedicationRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private UserRepository userRepository;

   
    public Medication saveMedication(Long userId, Medication medication) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id : " +userId));

        medication.setUser(user);
        return medicationRepository.save(medication);
    }

 
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    
    public Medication getMedicationById(Long id) {

        return medicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Medication not found with id : " + id));
    }

  
    public Medication updateMedication(
            Medication medication, Long id) {

        Medication existingMedication = medicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Medication not found with id : " + id));

        existingMedication.setMedicineName(medication.getMedicineName());
        existingMedication.setDosage(medication.getDosage());
        existingMedication.setMedicineType(medication.getMedicineType());
        existingMedication.setInstructions( medication.getInstructions());
        existingMedication.setTime(medication.getTime());
        existingMedication.setMealRelation(medication.getMealRelation());
        existingMedication.setFrequency(medication.getFrequency());
        existingMedication.setActive(medication.isActive());
        return medicationRepository.save(existingMedication);
    }

    public void deleteMedication(Long id) {

        Medication existingMedication = medicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Medication not found with id : " + id));
        medicationRepository.delete(existingMedication);
    }
}