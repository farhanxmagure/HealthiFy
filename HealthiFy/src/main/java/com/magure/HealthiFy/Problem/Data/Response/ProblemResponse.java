package com.magure.HealthiFy.Problem.Data.Response;
import com.magure.HealthiFy.Problem.Data.Problem;
import com.magure.HealthiFy.Patient.Data.Patient;
import com.magure.HealthiFy.Problem.Data.ProblemStatus;
import lombok.Data;


import java.util.Date;

@Data
public class ProblemResponse {
    private String id;
    private Patient patient;
    private String name;
    private String description;
    private Date startDate;
    private ProblemStatus problemStatus;
    private String comment;
    private Date createdDate;
    private Date updatedDate;

    public ProblemResponse(Problem problem) {
        this.id = problem.getId();
        this.patient = problem.getPatient();
        this.name = problem.getName();
        this.description = problem.getDescription();
        this.startDate = problem.getStartDate();
        this.problemStatus = problem.getProblemStatus();
        this.comment = problem.getComment();
        this.createdDate = problem.getCreatedDate();
        this.updatedDate = problem.getUpdatedDate();
    }
}
