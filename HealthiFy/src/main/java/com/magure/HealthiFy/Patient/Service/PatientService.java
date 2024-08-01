package com.magure.HealthiFy.Patient.Service;

import com.magure.HealthiFy.Patient.Data.Patient;
import com.magure.HealthiFy.Patient.Data.Request.PatientRequest;
import com.magure.HealthiFy.Patient.Data.Response.PatientResponse;
import java.time.LocalDateTime;

import com.magure.HealthiFy.Patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientResponse createPatient(PatientRequest request) {
        Patient patient = new Patient();
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setEmail(request.getEmail());
        patient.setMobilePhone(request.getMobilePhone());
        patient.setCreatedDate(LocalDateTime.now());
        patient.setUpdatedDate(LocalDateTime.now());

        Patient savedPatient = patientRepository.save(patient);
        return new PatientResponse(savedPatient);
    }

    public PatientResponse getPatientById(String id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return new PatientResponse(patient);
    }

    public PatientResponse updatePatient(String id, PatientRequest request) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setEmail(request.getEmail());
        patient.setMobilePhone(request.getMobilePhone());
        patient.setUpdatedDate(LocalDateTime.now());

        Patient updatedPatient = patientRepository.save(patient);
        return new PatientResponse(updatedPatient);
    }

    public void deletePatient(String id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.delete(patient);
    }
}
