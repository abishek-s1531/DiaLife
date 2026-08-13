package com.diabetic.demo.entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "medications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;

    private String dosage;

    private String medicineType;

    private String instructions;

    private LocalTime time;

    private String mealRelation;

    private String frequency;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-medication")
    private User user;
}