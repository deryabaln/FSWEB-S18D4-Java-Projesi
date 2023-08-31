package com.workintech.Banking.Rest.Api.service;

import com.workintech.Banking.Rest.Api.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> find();
    Address findById(int id);
    Address save(Address address);
    void delete(Address address);
}
