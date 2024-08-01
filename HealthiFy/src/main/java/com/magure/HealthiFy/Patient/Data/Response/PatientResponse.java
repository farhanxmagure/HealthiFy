package com.magure.HealthiFy.Patient.Data.Response;

import com.magure.HealthiFy.Patient.Data.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PatientResponse {
        private String id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String email;
        private String mobilePhone;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

        public PatientResponse(Patient patient) {
            this.id = patient.getId();
            this.firstName = patient.getFirstName();
            this.lastName = patient.getLastName();
            this.dateOfBirth = patient.getDateOfBirth();
            this.email = patient.getEmail();
            this.mobilePhone = patient.getMobilePhone();
            this.createdDate = patient.getCreatedDate();
            this.updatedDate = patient.getUpdatedDate();
        }
    }


