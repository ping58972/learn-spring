package com.ping.springdemo.dao;

import java.util.List;

import com.ping.springdemo.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
