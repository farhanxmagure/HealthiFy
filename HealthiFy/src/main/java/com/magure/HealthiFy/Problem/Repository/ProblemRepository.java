package com.magure.HealthiFy.Problem.Repository;


import com.magure.HealthiFy.Problem.Data.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends MongoRepository<Problem, String> {
}