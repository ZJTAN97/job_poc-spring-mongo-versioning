package com.poc.mongoversion.mongoversionpoc.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String region;

    private String streetName;

    private Unit unit;

}
