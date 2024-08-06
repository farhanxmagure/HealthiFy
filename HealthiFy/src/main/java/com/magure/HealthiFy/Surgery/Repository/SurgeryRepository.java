package com.magure.HealthiFy.Surgery.Repository;

import com.magure.HealthiFy.Surgery.Data.Surgery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends MongoRepository<Surgery, String> {

}