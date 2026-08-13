package com.diabetic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diabetic.demo.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Long>  {

}
