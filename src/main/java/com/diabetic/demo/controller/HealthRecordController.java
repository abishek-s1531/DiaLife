package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.dto.HealthRecordRequestDTO;
import com.diabetic.demo.dto.HealthRecordResponseDTO;
import com.diabetic.demo.service.HealthRecordService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/healthRecords")
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;


   
    @PostMapping("/add")
    public HealthRecordResponseDTO saveHealthRecord(@RequestBody @Valid HealthRecordRequestDTO dto) {

        return healthRecordService.saveHealthRecord(dto);
    }


   
    @GetMapping("/all")
    public List<HealthRecordResponseDTO> getAllHealthRecords() {
        return healthRecordService.getAllHealthRecords();
    }


    
    @GetMapping("/{id}")
    public HealthRecordResponseDTO getHealthRecordById(@Valid @PathVariable Long id) {
        return healthRecordService.getHealthRecordById(id);
    }


   
    @PutMapping("/{id}")
    public HealthRecordResponseDTO updateHealthRecord(@Valid @PathVariable Long id,@RequestBody HealthRecordRequestDTO dto) {
        return healthRecordService.updateHealthRecord(dto, id);
    }


   
    @DeleteMapping("/{id}")
    public String deleteHealthRecord(@Valid @PathVariable Long id) {

        healthRecordService.deleteHealthRecord(id);
        return "Health record deleted successfully";
    }
}
