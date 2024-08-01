package com.magure.HealthiFy.Surgery.Controller;

import com.magure.HealthiFy.Surgery.Data.Request.SurgeryRequest;
import com.magure.HealthiFy.Surgery.Data.Response.SurgeryResponse;
import com.magure.HealthiFy.Surgery.Data.SurgeryStatus;
import com.magure.HealthiFy.Surgery.Service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public SurgeryResponse createSurgery(@RequestBody SurgeryRequest request) {
        return surgeryService.createSurgery(request);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_PROVIDER')") // Assuming only Providers can update status
    public SurgeryResponse updateSurgeryStatus(@PathVariable String id, @RequestBody SurgeryStatus status) {
        // Validate status if necessary
        return surgeryService.updateSurgeryStatus(id, status);
    }

    @GetMapping("/{id}")
    public SurgeryResponse getSurgery(@PathVariable String id) {
        return surgeryService.getSurgeryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSurgery(@PathVariable String id) {
        surgeryService.deleteSurgery(id);
    }
}
