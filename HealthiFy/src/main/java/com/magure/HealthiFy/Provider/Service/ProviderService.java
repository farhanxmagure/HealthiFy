package com.magure.HealthiFy.Provider.Service;


import com.magure.HealthiFy.Provider.Data.Provider;
import com.magure.HealthiFy.Provider.Data.Request.ProviderRequest;
import com.magure.HealthiFy.Provider.Data.Response.ProviderResponse;
import com.magure.HealthiFy.Provider.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public ProviderResponse createProvider(ProviderRequest request){
        Provider provider = new Provider();
        provider.setFirstName(request.getFirstName());
        provider.setLastName(request.getLastName());
        provider.setTitle(request.getTitle());
        provider.setDateOfBirth(request.getDateOfBirth());
        provider.setEmail(request.getEmail());
        provider.setMobilePhone(request.getMobilePhone());
        provider.setCreatedDate(LocalDateTime.now());
        provider.setUpdatedDate(LocalDateTime.now());
        Provider saveProvider = providerRepository.save(provider);
        return new ProviderResponse(saveProvider);
    }
    public ProviderResponse getProviderById(String id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        return new ProviderResponse(provider);
    }

    public ProviderResponse updateProvider(String id, ProviderRequest request) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));

        provider.setFirstName(request.getFirstName());
        provider.setLastName(request.getLastName());
        provider.setDateOfBirth(request.getDateOfBirth());
        provider.setEmail(request.getEmail());
        provider.setMobilePhone(request.getMobilePhone());
        provider.setUpdatedDate(LocalDateTime.now());

        Provider updatedProvider = providerRepository.save(provider);
        return new ProviderResponse(updatedProvider);
    }
    public void deleteProvider(String id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        providerRepository.delete(provider);
    }
}
