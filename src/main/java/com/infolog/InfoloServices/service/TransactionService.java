package com.infolog.InfologServices.service;

import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.model.Transaction;
import com.infolog.InfologServices.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Iterable<Transaction> getAllTransaction(){
        return repository.findAll();
    }

    public Optional<Transaction> getOneTransaction(@PathVariable int id){
        return repository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction){
        return repository.save(transaction);
    }

    public void deleteTransaction(Transaction transaction){
        repository.delete(transaction);
    }
}
