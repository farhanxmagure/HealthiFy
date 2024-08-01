package com.magure.HealthiFy.Surgery.Data.Response;



import com.magure.HealthiFy.Patient.Data.Patient;

import com.magure.HealthiFy.Surgery.Data.Surgery;
import com.magure.HealthiFy.Surgery.Data.SurgeryStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SurgeryResponse {
    private String id;
    private Patient patient;
    private String name;
    private String description;
    private Date surgeryDate;
    private SurgeryStatus surgeryStatus;
    private Date createdDate;
    private Date updatedDate;

    public SurgeryResponse(Surgery surgery) {
        this.id = surgery.getId();
        this.patient = surgery.getPatient();
        this.name = surgery.getName();
        this.description = surgery.getDescription();
        this.surgeryDate = surgery.getSurgeryDate();
        this.surgeryStatus = surgery.getSurgeryStatus();
        this.createdDate = surgery.getCreatedDate();
        this.updatedDate = surgery.getUpdatedDate();
    }
}
