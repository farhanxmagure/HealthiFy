package com.magure.HealthiFy.Problem.Data;

import com.magure.HealthiFy.Patient.Data.Patient;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "problems")
@Data
public class Problem {

    @Id
    private String id;
    @DBRef
    private Patient patient;
    private String name;
    private String description;
    private Date startDate;
    private ProblemStatus problemStatus;
    private String comment;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;

}