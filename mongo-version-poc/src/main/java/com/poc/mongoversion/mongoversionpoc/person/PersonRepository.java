package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
