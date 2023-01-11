package com.poc.mongoversion.mongoversionpoc.person;

import com.poc.mongoversion.mongoversionpoc.person.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
