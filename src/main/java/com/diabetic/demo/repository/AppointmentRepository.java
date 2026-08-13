package com.diabetic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diabetic.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
}
