package com.magure.HealthiFy.Problem.Controllers;

import com.magure.HealthiFy.Problem.Data.Problem;
import com.magure.HealthiFy.Problem.Data.ProblemStatus;
import com.magure.HealthiFy.Problem.Data.Request.ProblemRequest;
import com.magure.HealthiFy.Problem.Data.Response.ProblemResponse;
import com.magure.HealthiFy.Problem.Service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PATIENT')") // Assuming Patients can create problems
    public ProblemResponse createProblem(@RequestBody ProblemRequest request) {
        return problemService.createProblem(request);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_PROVIDER')") // Assuming only Providers can update status
    public ProblemResponse updateProblemStatus(@PathVariable String id, @RequestBody ProblemStatus status) {
        // Validate status if necessary
        return problemService.updateProblemStatus(id, status);
    }

    @GetMapping("/{id}")
    public ProblemResponse getProblem(@PathVariable String id) {
        return problemService.getProblemById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable String id) {
        problemService.deleteProblem(id);
    }
}
