package com.magure.HealthiFy.Surgery.Data.Request;


import com.magure.HealthiFy.Patient.Data.Patient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
@Data
public class SurgeryRequest {
    private Patient patient;
    private String name;
    private String description;
    private Date surgeryDate;

}
