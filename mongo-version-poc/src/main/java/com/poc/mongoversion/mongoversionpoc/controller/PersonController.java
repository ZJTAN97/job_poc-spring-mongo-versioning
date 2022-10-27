package com.poc.mongoversion.mongoversionpoc.controller;

import com.poc.mongoversion.mongoversionpoc.model.Person;
import com.poc.mongoversion.mongoversionpoc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> findAllPersons() {
        return personService.findAllPerson();
    }

}
