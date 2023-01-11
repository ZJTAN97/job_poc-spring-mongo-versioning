package com.poc.mongoversion.mongoversionpoc.person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "address")
public class Address {

    @Id
    private String id;

    private String region;

    private String streetName;

    private Unit unit;

    @Version
    private Long version;

}
