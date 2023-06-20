package com.infolog.InfologServices.service;

import com.infolog.InfologServices.model.ATM;
import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class AtmService {

    @Autowired
    private AtmRepository repository;

    public Iterable<ATM> getAllAtm(){
        return repository.findAll();
    }

    public Optional<ATM> getOneAtm(@PathVariable int id){
        return repository.findById(id);
    }

    public ATM saveAtm(ATM atm){
        return repository.save(atm);
    }

    public void deleteAtm(ATM atm){
        repository.delete(atm);
    }
}
