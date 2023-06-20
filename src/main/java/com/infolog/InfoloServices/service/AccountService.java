package com.infolog.InfologServices.service;

import com.infolog.InfologServices.model.Account;
import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Iterable<Account> getAllAccount(){
        return repository.findAll();
    }

    public Optional<Account> getOneAccount(@PathVariable int id){
        return repository.findById(id);
    }

    public Account saveAccount(Account account){
        return repository.save(account);
    }

    public void deleteAccount(Account account){
        repository.delete(account);
    }
}
