package com.diabetic.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diabetic.demo.entity.HealthRecord;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {

    Optional<HealthRecord> findTopByUserIdOrderByDateTimeDesc(Long userId);

}