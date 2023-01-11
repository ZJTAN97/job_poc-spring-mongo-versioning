package com.poc.mongoversion.mongoversionpoc.person.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Unit {

    private int level;

    private int doorNumber;

}
