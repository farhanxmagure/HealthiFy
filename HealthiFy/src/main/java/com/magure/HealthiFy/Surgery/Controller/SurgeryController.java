package com.magure.HealthiFy.Surgery.Controller;

import com.magure.HealthiFy.Surgery.Data.Request.SurgeryRequest;
import com.magure.HealthiFy.Surgery.Data.Response.SurgeryResponse;
import com.magure.HealthiFy.Surgery.Data.SurgeryStatus;
import com.magure.HealthiFy.Surgery.Service.SurgeryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @Operation(summary = "Create a new surgery", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public SurgeryResponse createSurgery(@RequestBody SurgeryRequest request) {
        return surgeryService.createSurgery(request);
    }

    @Operation(summary = "Update surgery status", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public SurgeryResponse updateSurgeryStatus(@PathVariable String id, @RequestBody SurgeryStatus status) {
        return surgeryService.updateSurgeryStatus(id, status);
    }

    @Operation(summary = "Get surgery information")
    @GetMapping("/{id}")
    public SurgeryResponse getSurgery(@PathVariable String id) {
        return surgeryService.getSurgeryById(id);
    }

    @Operation(summary = "Delete surgery information", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteSurgery(@PathVariable String id) {
        surgeryService.deleteSurgery(id);
    }
}
