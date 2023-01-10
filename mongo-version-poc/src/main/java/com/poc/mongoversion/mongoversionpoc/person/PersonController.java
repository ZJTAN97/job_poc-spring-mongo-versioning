package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String personId) {
        return personService.updatePerson(person, personId);
    }


}
