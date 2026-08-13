package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.dto.HealthRecordRequestDTO;
import com.diabetic.demo.dto.HealthRecordResponseDTO;

public interface HealthRecordService {

    HealthRecordResponseDTO saveHealthRecord(HealthRecordRequestDTO dto);

    List<HealthRecordResponseDTO> getAllHealthRecords();

    HealthRecordResponseDTO getHealthRecordById(Long id);

    HealthRecordResponseDTO updateHealthRecord(HealthRecordRequestDTO dto, Long id);

    void deleteHealthRecord(Long id);
}
