package com.ping.springdemo.service;

import java.util.List;

import com.ping.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
