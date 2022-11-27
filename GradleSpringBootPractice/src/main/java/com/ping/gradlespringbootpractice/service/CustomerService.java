package com.ping.gradlespringbootpractice.service;

import com.ping.gradlespringbootpractice.entiry.Customer;
import com.ping.gradlespringbootpractice.exception.CustomerNotFoundException;
import com.ping.gradlespringbootpractice.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
//    @Cacheable(value = "allCustomers")
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }
//    @CacheEvict(value = "allCustomers", allEntries = true)
    public Customer getCustomerByUserId(Integer id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepo.findCustomerByUserId(id);
        if(!customerOptional.isPresent()){
            throw new CustomerNotFoundException("Customer Infos not found by ID: " + id );
        }
        return customerOptional.get();
    }
}
