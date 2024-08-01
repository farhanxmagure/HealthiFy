package com.magure.HealthiFy.Security.Repository;

import com.magure.HealthiFy.Security.Data.ERole;
import com.magure.HealthiFy.Security.Data.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}