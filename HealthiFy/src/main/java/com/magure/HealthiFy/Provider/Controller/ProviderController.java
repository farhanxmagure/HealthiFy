package com.magure.HealthiFy.Provider.Controller;

import com.magure.HealthiFy.Provider.Data.Request.ProviderRequest;
import com.magure.HealthiFy.Provider.Data.Response.ProviderResponse;
import com.magure.HealthiFy.Provider.Service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    @Operation(summary = "Create a new provider")
    @PostMapping
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider(request);
    }

    @Operation(summary = "Get provider information")
    @GetMapping("/{id}")
    public ProviderResponse getProvider(@PathVariable String id) {
        return providerService.getProviderById(id);
    }

    @Operation(summary = "Update provider information", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public ProviderResponse updateProvider(@PathVariable String id, @RequestBody ProviderRequest request) {
        return providerService.updateProvider(id, request);
    }

    @Operation(summary = "Delete provider information", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public void deleteProvider(@PathVariable String id) {
        providerService.deleteProvider(id);
    }
}
