package com.magure.HealthiFy.Patient.Controller;

import com.magure.HealthiFy.Patient.Data.Request.PatientRequest;
import com.magure.HealthiFy.Patient.Data.Response.PatientResponse;
import com.magure.HealthiFy.Patient.Service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(summary = "Create a new patient")
    @PostMapping
    public PatientResponse createPatient(@RequestBody PatientRequest request) {
        return patientService.createPatient(request);
    }

    @Operation(summary = "Get patient information", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public PatientResponse getPatient(@PathVariable String id) {
        return patientService.getPatientById(id);
    }

    @Operation(summary = "Update patient information", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public PatientResponse updatePatient(@PathVariable String id, @RequestBody PatientRequest request) {
        return patientService.updatePatient(id, request);
    }

    @Operation(summary = "Delete patient information", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }
}
