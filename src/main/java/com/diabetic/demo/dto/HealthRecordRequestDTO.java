package com.diabetic.demo.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecordRequestDTO {
	
	private Long userId;
	@Positive(message="weight must positive ")
	 private Double weight;
	    @Positive(message="Height must positive ")
	    private Double height;
	    
	    private String bloodGroup;
	    private String medicalHistory;
	    private String allergies;
        @Positive
	    private Double fastingSugar;
        @Positive
	    private Double postMealLevel;
	    private LocalTime postMealCheckTime;
	    private Double bedTimeLevel;

	    private LocalDateTime dateTime;
}
