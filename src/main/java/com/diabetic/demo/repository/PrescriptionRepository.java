package com.diabetic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diabetic.demo.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
