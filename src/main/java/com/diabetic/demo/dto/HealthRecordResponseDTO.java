package com.diabetic.demo.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecordResponseDTO {

    private Long id;

    private Double weight;
    private Double height;
    private String bloodGroup;
    private String medicalHistory;
    private String allergies;

    private Double fastingSugar;
    private String fastingStatus;

    private Double postMealLevel;
    private LocalTime postMealCheckTime;
    private String postMealStatus;

    private Double bedTimeLevel;
    private String nightStatus;

    private Double todayAverage;

    private LocalDateTime dateTime;
}
