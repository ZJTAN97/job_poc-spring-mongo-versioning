package com.poc.mongoversion.mongoversionpoc.repository;

import com.poc.mongoversion.mongoversionpoc.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
