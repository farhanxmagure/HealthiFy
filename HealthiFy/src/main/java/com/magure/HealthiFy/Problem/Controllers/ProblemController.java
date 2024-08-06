package com.magure.HealthiFy.Problem.Controllers;

import com.magure.HealthiFy.Problem.Data.ProblemStatus;
import com.magure.HealthiFy.Problem.Data.Request.ProblemRequest;
import com.magure.HealthiFy.Problem.Data.Response.ProblemResponse;
import com.magure.HealthiFy.Problem.Service.ProblemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Operation(summary = "Create a new problem", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ProblemResponse createProblem(@RequestBody ProblemRequest request) {
        return problemService.createProblem(request);
    }

    @Operation(summary = "Update problem status", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public ProblemResponse updateProblemStatus(@PathVariable String id, @RequestBody ProblemStatus status) {
        return problemService.updateProblemStatus(id, status);
    }

    @Operation(summary = "Get problem information")
    @GetMapping("/{id}")
    public ProblemResponse getProblem(@PathVariable String id) {
        return problemService.getProblemById(id);
    }

    @Operation(summary = "Delete problem information", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable String id) {
        problemService.deleteProblem(id);
    }
}
