package com.ensa.mscustomer.repositories;

import com.ensa.mscustomer.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    public Customer findByFirstName(String firstName);
}
