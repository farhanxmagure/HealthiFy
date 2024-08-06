package com.magure.HealthiFy.Provider.Data.Response;

import com.magure.HealthiFy.Provider.Data.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private LocalDate dateOfBirth;
    private String email;
    private String mobilePhone;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public ProviderResponse(Provider provider) {
        this.id = provider.getId();
        this.firstName = provider.getFirstName();
        this.lastName = provider.getLastName();
        this.title = provider.getTitle();
        this.dateOfBirth = provider.getDateOfBirth();
        this.email = provider.getEmail();
        this.mobilePhone = provider.getMobilePhone();
        this.createdDate = provider.getCreatedDate();
        this.updatedDate = provider.getUpdatedDate();
    }
}
