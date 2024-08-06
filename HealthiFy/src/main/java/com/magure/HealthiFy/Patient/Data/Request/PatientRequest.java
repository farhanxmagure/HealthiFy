package com.magure.HealthiFy.Patient.Data.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String email;
        private String mobilePhone;
    }

