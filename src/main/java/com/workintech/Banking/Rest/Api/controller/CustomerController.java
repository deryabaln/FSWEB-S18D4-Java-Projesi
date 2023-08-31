package com.workintech.Banking.Rest.Api.controller;

import com.workintech.Banking.Rest.Api.entity.Customer;
import com.workintech.Banking.Rest.Api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> find() {
        return customerService.find();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id) {
        return customerService.findById(id);
    }

    @PostMapping("/")
    public Customer save(@RequestBody Customer customer) {
        System.out.println(customer.getAccountList());
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id) {
        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customer.setId(id);
            return customerService.save(customer);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
        return customer;
    }
}
