package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Address;
import com.poc.mongoversion.mongoversionpoc.person.domain.Person;
import com.poc.mongoversion.mongoversionpoc.person.domain.Unit;

import java.util.Arrays;
import java.util.List;

public class PersonFactory {

    public static Person.PersonBuilder personBuilder() {

        Address address1 = Address.builder()
                .unit(Unit.builder().doorNumber(10).level(10).build())
                .streetName("street")
                .build();

        Address address2 = Address.builder()
                .unit(Unit.builder().doorNumber(10).level(10).build())
                .streetName("street")
                .build();

        List<Address> addressList = Arrays.asList(address1, address2);

        return Person.builder()
                .name("docker")
                .age(10)
                .education(Person.Education.ADVANCED)
                .address(addressList);
    }

}
