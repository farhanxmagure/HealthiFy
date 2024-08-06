package com.magure.HealthiFy.Provider.Data.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProviderRequest {
    @NotBlank(message = "First name is mandatory")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 1, max = 20, message = "Title must be between 1 and 20 characters")
    private String title;

    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Mobile phone is mandatory")
    @Size(min = 10, max = 15, message = "Mobile phone must be between 10 and 15 characters")
    private String mobilePhone;
}
