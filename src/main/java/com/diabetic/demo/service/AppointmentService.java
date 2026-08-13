package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.dto.AppointmentRequestDTO;
import com.diabetic.demo.entity.Appointment;

public interface AppointmentService {

    Appointment saveAppointment(
            Long userId,
            Long doctorId,
            AppointmentRequestDTO dto);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    Appointment updateAppointment(
            AppointmentRequestDTO dto,
            Long id);

    void deleteAppointment(Long id);
}
