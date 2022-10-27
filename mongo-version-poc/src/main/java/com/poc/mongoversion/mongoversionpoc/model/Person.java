package com.poc.mongoversion.mongoversionpoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    enum Education {
        BASIC,
        INTERMEDIATE,
        ADVANCED
    }

    private String _id;

    private String name;

    private Integer age;

    private List<String> hobbies;

    private Education education;

}
