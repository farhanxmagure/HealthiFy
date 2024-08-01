package com.magure.HealthiFy.Provider.Data.Response;

import com.magure.HealthiFy.Provider.Data.Provider;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ProviderResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private LocalDate dateOfBirth;
    private String email;
    private String mobilePhone;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    public ProviderResponse(Provider provider){
        this.id = provider.getId();
        this.firstName = provider.getFirstName();
        this.lastName = provider.getLastName();
        this.title = provider.getTitle();
        this.dateOfBirth = provider.getDateOfBirth();
        this.email = provider.getEmail();;
        this.mobilePhone = provider.getMobilePhone();
        this.createdDate = provider.getCreatedDate();
        this.updatedDate = provider.getUpdatedDate();

    }

}
