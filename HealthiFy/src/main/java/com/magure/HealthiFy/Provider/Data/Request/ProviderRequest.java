package com.magure.HealthiFy.Provider.Data.Request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProviderRequest {
    private String firstName;
    private String lastName;
    private String title;
    private LocalDate dateOfBirth;
    private String email;
    private String mobilePhone;

}
