package com.magure.HealthiFy.Problem.Data.Request;


import com.magure.HealthiFy.Patient.Data.Patient;
import lombok.Data;

import java.util.Date;
@Data
public class ProblemRequest {
    private Patient patient;
    private String name;
    private String description;
    private Date startDate;
    private String comment;

    // Getters and Setters
}
