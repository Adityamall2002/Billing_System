package com.billing.billingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.billingsystem.entity.Customer;
import com.billing.billingsystem.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {

        return customerService.getAllCustomers();
    }
}