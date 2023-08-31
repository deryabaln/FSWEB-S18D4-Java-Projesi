package com.workintech.Banking.Rest.Api.service;

import com.workintech.Banking.Rest.Api.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> find();
    Account findById(int id);
    Account save(Account account);
    void delete(Account account);
}
