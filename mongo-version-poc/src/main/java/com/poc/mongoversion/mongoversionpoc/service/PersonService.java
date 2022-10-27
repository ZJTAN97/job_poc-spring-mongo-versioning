package com.poc.mongoversion.mongoversionpoc.service;

import com.poc.mongoversion.mongoversionpoc.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPerson();

    Person createPerson(Person newPerson);

}
