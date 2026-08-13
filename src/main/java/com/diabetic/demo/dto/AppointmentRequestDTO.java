package com.diabetic.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.diabetic.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String appointmentType;

    private String reason;

    private String notes;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
