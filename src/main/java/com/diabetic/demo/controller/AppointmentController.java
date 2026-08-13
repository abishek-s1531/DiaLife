package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.dto.AppointmentRequestDTO;
import com.diabetic.demo.entity.Appointment;
import com.diabetic.demo.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add/{userId}/{doctorId}")
    public Appointment saveAppointment(@PathVariable Long userId,@PathVariable Long doctorId,@RequestBody AppointmentRequestDTO dto) {

        return appointmentService.saveAppointment(userId, doctorId, dto);
    }

  
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

 
    @GetMapping("/{id}")
    public Appointment getAppointmentById(
            @PathVariable Long id) {

        return appointmentService.getAppointmentById(id);
        
        
    }

    @PutMapping("/update/{id}")
    public Appointment updateAppointment( @PathVariable Long id,@RequestBody AppointmentRequestDTO dto) {
        return appointmentService.updateAppointment(dto, id);
    }

 
    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
}