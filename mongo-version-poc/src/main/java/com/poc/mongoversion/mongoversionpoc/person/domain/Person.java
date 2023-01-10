package com.poc.mongoversion.mongoversionpoc.person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@TypeAlias("person")
@Document(collection = "person")
public class Person {

    @Id
    private String id;

    private String name;

    private int age;

    private List<String> hobbies;

    private Education education;

    private List<Address> address;

    enum Education {
        BASIC,
        INTERMEDIATE,
        ADVANCED
    }

    @Version
    private Long version;

}
