package com.magure.HealthiFy.Provider.Controller;

import com.magure.HealthiFy.Provider.Data.Request.ProviderRequest;
import com.magure.HealthiFy.Provider.Data.Response.ProviderResponse;
import com.magure.HealthiFy.Provider.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider(request);
    }

    @GetMapping("/{id}")
    public ProviderResponse getProvider(@PathVariable String id) {
        return providerService.getProviderById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public ProviderResponse updateProvider(@PathVariable String id, @RequestBody ProviderRequest request) {
        return providerService.updateProvider(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public void deleteProvider(@PathVariable String id) {
        providerService.deleteProvider(id);
    }
}
