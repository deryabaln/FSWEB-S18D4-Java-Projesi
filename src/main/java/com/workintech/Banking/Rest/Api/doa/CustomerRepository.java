package com.workintech.Banking.Rest.Api.doa;

import com.workintech.Banking.Rest.Api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {

}
