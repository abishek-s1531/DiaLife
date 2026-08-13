package com.diabetic.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prescriptions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;

    private String dosage;

    private String frequency;

    private String duration;

    private String instructions;

    private LocalDate prescribedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-prescription")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Appointment appointment;
}
