package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    public Person createPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }

    public Person updatePerson(Person updatedPerson, String personId) {
        Person person = personRepository.findById(personId).orElseThrow();
//        person.setName(updatedPerson.getName());
//        person.setAddress(updatedPerson.getAddress());
        return personRepository.save(person);

    }


}
