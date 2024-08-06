package com.magure.HealthiFy.Provider.Repository;

import com.magure.HealthiFy.Provider.Data.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends MongoRepository<Provider, String> {
}
