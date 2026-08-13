package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.Prescription;

public interface PrescriptionService {

    Prescription savePrescription(Long userId,Long doctorId,Long appointmentId,Prescription prescription);

    List<Prescription> getAllPrescriptions();

    Prescription getPrescriptionById(Long id);

    Prescription updatePrescription(Prescription prescription,Long id);

    void deletePrescription(Long id);
}
