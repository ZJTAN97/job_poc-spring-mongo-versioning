package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Address;
import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    public Person createPerson(Person newPerson) {
        List<Address> addressList = new ArrayList<>();
        for (Address address : newPerson.getAddress()) {
            addressRepository.insert(address);
            addressList.add(address);
        }
        newPerson.setAddress(addressList);
        return personRepository.insert(newPerson);
    }

    public Person updatePerson(Person updatedPerson, String personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Person updated = person.toBuilder()
                .name(updatedPerson.getName())
                .age(updatedPerson.getAge())
                .education(updatedPerson.getEducation())
                .address(updatedPerson.getAddress())
                .build();

        return personRepository.save(updated);
    }


}
