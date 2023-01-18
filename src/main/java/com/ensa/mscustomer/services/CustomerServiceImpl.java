package com.ensa.mscustomer.services;

import com.ensa.mscustomer.entities.Customer;
import com.ensa.mscustomer.exceptions.EntityAlreadyExistsException;
import com.ensa.mscustomer.exceptions.EntityNotFoundException;
import com.ensa.mscustomer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        if(customerRepository.findById(id)==null) {
            throw new EntityNotFoundException("The customer doesn't exists !");
        }
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public Customer getCustomerByName(String firstName) {

        if(customerRepository.findByFirstName(firstName) == null) {
            throw new EntityNotFoundException("The customer doesn't exists !");
        }
        Customer customer=customerRepository.findByFirstName(firstName);
        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {

        if(customerRepository.findByFirstName(customer.getFirstName())!=null) {
            throw new EntityAlreadyExistsException("The customer has already this name");
        }
        return	customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customerRepository.findByFirstName(customer.getFirstName())==null) {
            throw new EntityNotFoundException("The customer doesn't exists");
        }
        Customer editCustomer=customerRepository.findById(customer.getId()).get();
        editCustomer.setFirstName(customer.getFirstName());
        editCustomer.setLastName(customer.getLastName());
        editCustomer.setAddress(customer.getAddress());
        editCustomer.setEmail(customer.getEmail());
        editCustomer.setCity(customer.getCity());
        return	customerRepository.save(editCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if(customerRepository.findById(id)==null) {
            throw new EntityNotFoundException("The customer doesn't exists");
        }
        customerRepository.deleteById(id);
    }
}
