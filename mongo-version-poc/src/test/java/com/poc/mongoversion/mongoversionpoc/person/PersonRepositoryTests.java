package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Address;
import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeAll
    void beforeAll() {
        this.person = PersonFactory.personBuilder().build();
    }

    @Test
    @Order(1)
    void create() {
        Person newPerson = personRepository.save(this.person);
        assertThat(newPerson).usingRecursiveComparison().isEqualTo(this.person);
        assertThat(newPerson.getVersion()).isEqualTo(0);
        assertThat(newPerson.getAddress().get(0).getId()).isNull();
        assertThat(newPerson.getAddress().get(0).getVersion()).isNull();
    }

    @Test
    @Order(2)
    void updateRootDocument() {
        Person selectedPerson = personRepository
                .findById(this.person.getId())
                .orElseThrow();
        Person updatedPerson = selectedPerson.toBuilder()
                .name("new name")
                .build();
        Person saved = personRepository.save(updatedPerson);
        assertThat(saved).usingRecursiveComparison().isEqualTo(updatedPerson);
        assertThat(saved.getVersion()).isEqualTo(1);
    }

    @Test
    @Order(3)
    void updateEmbeddedDocument() {
        Person selectedPerson = personRepository.findById(this.person.getId()).orElseThrow();
        Address address2 = selectedPerson.getAddress().get(1);
        Address updatedAddress2 = address2.toBuilder()
                .streetName("updated street name")
                .build();

        List<Address> addressList = selectedPerson.getAddress();
        addressList.set(1, updatedAddress2);

        Person updatedPerson = selectedPerson.toBuilder()
                .address(addressList)
                .build();
        Person saved = personRepository.save(updatedPerson);

        assertThat(saved.getAddress()).hasSize(2).contains(updatedAddress2);
        assertThat(saved.getAddress().get(1).getVersion()).isNull();
        assertThat(saved.getVersion()).isEqualTo(2);

    }

    @Test
    @Order(3)
    void delete() {
        personRepository.deleteById(this.person.getId());
        boolean exist = personRepository
                .findById(this.person.getId())
                .isPresent();
        assertThat(exist).isFalse();
    }


}
