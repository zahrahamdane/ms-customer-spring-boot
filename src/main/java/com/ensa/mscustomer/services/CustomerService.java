package com.ensa.mscustomer.services;

import com.ensa.mscustomer.entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> listCustomers();
    public Customer getCustomerById(Long id);
    public Customer getCustomerByName(String firstName);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
}
