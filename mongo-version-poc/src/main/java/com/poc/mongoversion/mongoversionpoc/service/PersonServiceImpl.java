package com.poc.mongoversion.mongoversionpoc.service;

import com.poc.mongoversion.mongoversionpoc.model.Person;
import com.poc.mongoversion.mongoversionpoc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }
}
