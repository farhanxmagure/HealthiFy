package com.magure.HealthiFy.Provider.Data;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Provider {
    @Id
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

}
