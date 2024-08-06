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
        Provider provider = Provider.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .title(request.getTitle())
                .dateOfBirth(request.getDateOfBirth())
                .email(request.getEmail())
                .mobilePhone(request.getMobilePhone())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Provider savedProvider = providerRepository.save(provider);
        return new ProviderResponse(savedProvider);
    }

    public ProviderResponse getProviderById(String id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        return new ProviderResponse(provider);
    }

    public ProviderResponse updateProvider(String id, ProviderRequest request) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));

        Provider updatedProvider = provider.toBuilder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .title(request.getTitle())
                .dateOfBirth(request.getDateOfBirth())
                .email(request.getEmail())
                .mobilePhone(request.getMobilePhone())
                .updatedDate(LocalDateTime.now())
                .build();

        updatedProvider = providerRepository.save(updatedProvider);
        return new ProviderResponse(updatedProvider);
    }

    public void deleteProvider(String id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        providerRepository.delete(provider);
    }
}
