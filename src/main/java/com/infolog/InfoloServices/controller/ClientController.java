package com.infolog.InfologServices.controller;

import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/client")
    public Iterable<Client> getAllClient(){
        return service.getAllClient();
    }

    @GetMapping("/client/{id}")
    public Client getOneClient(@PathVariable int id){
        Optional<Client> client = service.getOneClient((Integer) id);
        return (client.isPresent() ? client.get() : null);
    }

    @DeleteMapping("/client")
    public ResponseEntity<Client> deleteClient(@PathVariable Client client){
        Optional<Client> client1 = service.getOneClient(client.getId());
        if(client1.isPresent()){
            service.deleteClient(client);
        }else {
            return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Client>(client1.get(), HttpStatus.OK);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable int id){
        Optional<Client> client1 = service.getOneClient(id);
        if(client1.isPresent()){
            service.deleteClientById(id);
        }else {
            return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Client>(client1.get(), HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> saveClient(@Validated @RequestBody Client client){
        Client client1 = service.saveClient(client);
        if (Objects.isNull(client1))
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable int id,
            @Validated @RequestBody Client client
    ){
        Optional<Client> client1 = service.getOneClient(id);
        if (client1.isPresent()){
            Client client2 = client1.get();
            client2.setName(client.getName());
            client2.setAccounts(client.getAccounts());

            return new ResponseEntity<Client>(service.saveClient(client2), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
