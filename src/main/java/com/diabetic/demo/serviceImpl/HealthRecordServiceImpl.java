package com.diabetic.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.dto.HealthRecordRequestDTO;
import com.diabetic.demo.dto.HealthRecordResponseDTO;
import com.diabetic.demo.entity.HealthRecord;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.HealthRecordRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.HealthRecordService;

@Service
public class HealthRecordServiceImpl implements HealthRecordService{

    @Autowired
    private HealthRecordRepository healthRecordRepository;
    
    @Autowired
    private UserRepository userRepository;

   
    public HealthRecordResponseDTO saveHealthRecord(HealthRecordRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id : " + dto.getUserId()));

        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setUser(user);

        healthRecord.setWeight(dto.getWeight());
        healthRecord.setHeight(dto.getHeight());
        healthRecord.setBloodGroup(dto.getBloodGroup());
        healthRecord.setMedicalHistory(dto.getMedicalHistory());
        healthRecord.setAllergies(dto.getAllergies());
        healthRecord.setFastingSugar(dto.getFastingSugar());
        healthRecord.setPostMealLevel(dto.getPostMealLevel());
        healthRecord.setPostMealCheckTime(dto.getPostMealCheckTime());
        healthRecord.setBedTimeLevel(dto.getBedTimeLevel());
        healthRecord.setDateTime(dto.getDateTime());

        calculateSugarStatus(healthRecord);

        HealthRecord savedRecord = healthRecordRepository.save(healthRecord);
        return convertToResponseDTO(savedRecord);
    }

 
    public List<HealthRecordResponseDTO> getAllHealthRecords() {
        return healthRecordRepository.findAll().stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }


   
    public HealthRecordResponseDTO getHealthRecordById(Long id) {

        HealthRecord healthRecord = healthRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Health record not found with id : " + id));

        return convertToResponseDTO(healthRecord);
    }


   
    public HealthRecordResponseDTO updateHealthRecord(
            HealthRecordRequestDTO dto, Long id) {

        HealthRecord existingRecord = healthRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Health record not found with id : " + id));

        existingRecord.setWeight(dto.getWeight());
        existingRecord.setHeight(dto.getHeight());
        existingRecord.setBloodGroup(dto.getBloodGroup());
        existingRecord.setMedicalHistory(dto.getMedicalHistory());
        existingRecord.setAllergies(dto.getAllergies());

        existingRecord.setFastingSugar(dto.getFastingSugar());
        existingRecord.setPostMealLevel(dto.getPostMealLevel());
        existingRecord.setPostMealCheckTime(dto.getPostMealCheckTime());
        existingRecord.setBedTimeLevel(dto.getBedTimeLevel());
        existingRecord.setDateTime(dto.getDateTime());
        
        calculateSugarStatus(existingRecord);

        HealthRecord updatedRecord = healthRecordRepository.save(existingRecord);
        return convertToResponseDTO(updatedRecord);
    }


  
    public void deleteHealthRecord(Long id) {

        HealthRecord existingRecord = healthRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Health record not found with id : " + id));
        healthRecordRepository.delete(existingRecord);
    }


 
    private void calculateSugarStatus(HealthRecord healthRecord) {

       
        if (healthRecord.getFastingSugar() != null) {

            if (healthRecord.getFastingSugar() < 70) {
                healthRecord.setFastingStatus("LOW");

            } 
            else if (healthRecord.getFastingSugar() <= 130) {
                healthRecord.setFastingStatus("TARGET");

            } 
            else {
                healthRecord.setFastingStatus("ABOVE_TARGET");
            }
        }


        if (healthRecord.getPostMealLevel()!= null) {

            if (healthRecord.getPostMealLevel() < 70) {
                healthRecord.setPostMealStatus("LOW");

            } 
            else if (healthRecord.getPostMealLevel() < 180) {
                healthRecord.setPostMealStatus("TARGET");

            } 
            else {
                healthRecord.setPostMealStatus("HIGH");
            }
        }


        if (healthRecord.getBedTimeLevel() != null) {

            if (healthRecord.getBedTimeLevel() < 70) {
                healthRecord.setNightStatus("LOW");

            }
            else if (healthRecord.getBedTimeLevel() < 180) {
                healthRecord.setNightStatus("TARGET");

            } 
            else {
                healthRecord.setNightStatus("HIGH");
            }
        }
    }

    private Double calculateAverage(HealthRecord healthRecord) {
        double total = 0;
        int count = 0;

        if (healthRecord.getFastingSugar() != null) {
            total += healthRecord.getFastingSugar();
            count++;
        }

        if (healthRecord.getPostMealLevel() != null) {
            total += healthRecord.getPostMealLevel();
            count++;
        }

        if (healthRecord.getBedTimeLevel() != null) {
            total += healthRecord.getBedTimeLevel();
            count++;
        }

        if (count == 0) {
            return 0.0;
        }

        return total / count;
    }

    private HealthRecordResponseDTO convertToResponseDTO(
            HealthRecord healthRecord) {

        HealthRecordResponseDTO response = new HealthRecordResponseDTO();
        response.setId(healthRecord.getId());

        response.setWeight(healthRecord.getWeight());
        response.setHeight(healthRecord.getHeight());
        response.setBloodGroup(healthRecord.getBloodGroup());
        response.setMedicalHistory(healthRecord.getMedicalHistory());
        response.setAllergies(healthRecord.getAllergies());

        response.setFastingSugar(healthRecord.getFastingSugar());
        response.setFastingStatus(healthRecord.getFastingStatus());

        response.setPostMealLevel(healthRecord.getPostMealLevel());
        response.setPostMealCheckTime(healthRecord.getPostMealCheckTime());
        response.setPostMealStatus(healthRecord.getPostMealStatus());

        response.setBedTimeLevel(healthRecord.getBedTimeLevel());
        response.setNightStatus(healthRecord.getNightStatus());

        response.setTodayAverage(calculateAverage(healthRecord));
        response.setDateTime(healthRecord.getDateTime());
        return response;
    }
}