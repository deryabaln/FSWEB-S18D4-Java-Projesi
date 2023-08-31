package com.workintech.Banking.Rest.Api.service;

import com.workintech.Banking.Rest.Api.entity.Address;
import com.workintech.Banking.Rest.Api.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> find();
    Customer findById(int id);
    Customer save(Customer customer);
    void delete(Customer customer);
}
