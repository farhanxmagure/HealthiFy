package com.magure.HealthiFy.Surgery.Data;

import com.magure.HealthiFy.Patient.Data.Patient;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@Document(collection = "surgeries")
public class Surgery {
    @Id
    private String id;
    @DBRef
    private Patient patient;
    private String name;
    private String description;
    private Date surgeryDate;
    private SurgeryStatus surgeryStatus;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
}
