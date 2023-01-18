package com.ensa.mscustomer.controllers;

import com.ensa.mscustomer.entities.Customer;
import com.ensa.mscustomer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> listCustomers() {
        return new ResponseEntity<>(customerService.listCustomers(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customerResponseDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("name/{firstName}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String firstName) {
        Customer customerResponseDto = customerService.getCustomerByName(firstName);
        return ResponseEntity.ok(customerService.getCustomerByName(firstName));
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerResponseDto = customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody() Customer customer) {
        ResponseEntity.ok(customerService.updateCustomer(customer));
        return ResponseEntity.accepted().body(customer);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }



}
