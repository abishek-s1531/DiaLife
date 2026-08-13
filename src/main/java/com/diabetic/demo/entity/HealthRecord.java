package com.diabetic.demo.entity;


import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_records")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Weight must be greater than 0")
    private Double weight;

    @Positive(message = "Height must be greater than 0")
    private Double height;
    @NotNull(message = "Blood group is required")
    private String bloodGroup;

    private String medicalHistory;

    private String allergies;

    @Positive
    private Double fastingSugar;
    @Positive
    private Double postMealLevel;
 
    private LocalTime postMealCheckTime;
   
    private Double bedTimeLevel;

    private String fastingStatus;

    private String postMealStatus;

    private String nightStatus;
    @NotNull(message = "Date and time are Compulsory")
    private LocalDateTime dateTime;

   
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-health")
    private User user;
}