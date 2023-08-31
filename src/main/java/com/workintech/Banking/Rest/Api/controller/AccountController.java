package com.workintech.Banking.Rest.Api.controller;

import com.workintech.Banking.Rest.Api.entity.Account;
import com.workintech.Banking.Rest.Api.entity.Customer;
import com.workintech.Banking.Rest.Api.service.AccountService;
import com.workintech.Banking.Rest.Api.service.CustomerService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;
@Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }
    @GetMapping("/")
    public List<Account> get(){
        return accountService.find();
    }

    @GetMapping("/{id}")
    public Account getById(@Positive @PathVariable int id){
        Account account = accountService.findById(id);
        return account;
    }
    @PostMapping("/{customerId}")
    public Account save(@RequestBody Account account, @PathVariable int customerId){
        Customer customer = customerService.findById(customerId);
        customer.add(account);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @PutMapping("/{customerId}")
    public Account upDate(@RequestBody Account account, @PathVariable int customerId){
        Customer customer = customerService.findById(customerId);
        Account foundAccount = customer.getAccountList().stream()
                        .filter(account1 -> account1.getId()== account.getId())
                        .collect(Collectors.toList()).get(0);
        if (foundAccount == null){
            System.out.println("account is not exist");
        }
        int index = customer.getAccountList().indexOf(foundAccount);
        customer.getAccountList().set(index, account);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        Account account = accountService.findById(id);
        accountService.delete(account);
        return  account;
    }
}
