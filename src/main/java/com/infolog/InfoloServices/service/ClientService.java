package com.infolog.InfologServices.service;

import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Iterable<Client> getAllClient(){
        return repository.findAll();
    }

    public Optional<Client> getOneClient(Integer id){
        return repository.findById(id);
    }

    public Client saveClient(Client client){
        return repository.save(client);
    }

    public void deleteClient(Client client){
        repository.delete(client);
    }

    public void deleteClientById(int id){
        repository.deleteById(id);
    }
}
