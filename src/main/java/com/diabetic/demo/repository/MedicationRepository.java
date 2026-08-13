package com.diabetic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diabetic.demo.entity.Medication;

public interface MedicationRepository extends JpaRepository<Medication,Long>{

}
