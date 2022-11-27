package com.ping.gradlespringbootpractice.repository;


import com.ping.gradlespringbootpractice.entiry.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String> {
    Optional<Customer> findCustomerByUserId(Integer id);
}
