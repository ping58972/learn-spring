package com.ping.gradlespringbootpractice.service;


import com.ping.gradlespringbootpractice.entiry.Customer;
import com.ping.gradlespringbootpractice.exception.CustomerNotFoundException;
import com.ping.gradlespringbootpractice.repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepo customerRepo;
    @InjectMocks
    CustomerService customerService;
    @Spy
    List<Customer> customerSpy = new ArrayList<>();

    @Test
    void getAllCustomers() throws CustomerNotFoundException {
        Customer customerExpect = Customer.builder().userId(-1).build();
        customerSpy.add(customerExpect);
        Mockito.when(customerSpy.size()).thenReturn(2);
        Mockito.when(customerRepo.findAll()).thenReturn(customerSpy);
        assertEquals(customerSpy, customerService.getAllCustomers());
        assertEquals(2, customerSpy.size());
        Mockito.verify(customerRepo, Mockito.times(1)).findAll();
    }
    @Test
    void getCustomerById() throws CustomerNotFoundException{
        Customer customerExpect = Customer.builder().userId(-1).build();
        Optional<Customer> customerOptional = Optional.of(customerExpect);
        Mockito.when(customerRepo.findCustomerByUserId(-1)).thenReturn(customerOptional);
        assertEquals(customerExpect, customerService.getCustomerByUserId(-1));
        Mockito.verify(customerRepo, Mockito.times(1)).findCustomerByUserId(-1);
    }
}
