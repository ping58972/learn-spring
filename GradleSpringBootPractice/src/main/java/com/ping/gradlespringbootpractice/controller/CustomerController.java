package com.ping.gradlespringbootpractice.controller;

import com.ping.gradlespringbootpractice.entiry.Customer;
import com.ping.gradlespringbootpractice.exception.CustomerNotFoundException;
import com.ping.gradlespringbootpractice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('DELETE')")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('DELETE')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws CustomerNotFoundException {
        Customer  customer = customerService.getCustomerByUserId(id);
        if (customer == null) return ResponseEntity.ok(Customer.builder().firstName("Bad request").build());
        return ResponseEntity.ok(customerService.getCustomerByUserId(id));
    }
}
