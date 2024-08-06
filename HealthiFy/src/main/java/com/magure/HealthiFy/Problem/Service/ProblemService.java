package com.magure.HealthiFy.Problem.Service;

import com.magure.HealthiFy.Problem.Data.Problem;
import com.magure.HealthiFy.Problem.Data.ProblemStatus;
import com.magure.HealthiFy.Problem.Data.Request.ProblemRequest;
import com.magure.HealthiFy.Problem.Data.Response.ProblemResponse;
import com.magure.HealthiFy.Problem.Repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class  ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public ProblemResponse createProblem(ProblemRequest request) {
        Problem problem = Problem.builder()
                .patient(request.getPatient())
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .problemStatus(ProblemStatus.PENDING)
                .comment(request.getComment())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();

        Problem savedProblem = problemRepository.save(problem);
        return new ProblemResponse(savedProblem);
    }

    public ProblemResponse updateProblemStatus(String id, ProblemStatus status) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found with id: " + id));

        if (status == ProblemStatus.IN_PROGRESS || status == ProblemStatus.COMPLETED) {
            // Check if the current status is PENDING
            if (problem.getProblemStatus() == ProblemStatus.PENDING) {
                problem.setProblemStatus(status);
                problem.setUpdatedDate(new Date());
                Problem updatedProblem = problemRepository.save(problem);
                return new ProblemResponse(updatedProblem);
            } else {
                throw new RuntimeException("Problem status can only be set to IN_PROGRESS or COMPLETED from PENDING");
            }
        } else {
            throw new RuntimeException("Invalid status update request");
        }
    }

    public ProblemResponse getProblemById(String id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found with id: " + id));
        return new ProblemResponse(problem);
    }

    public void deleteProblem(String id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found with id: " + id));
        problemRepository.delete(problem);
    }
}
