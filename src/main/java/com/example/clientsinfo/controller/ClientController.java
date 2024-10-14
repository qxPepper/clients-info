package com.example.clientsinfo.controller;

import com.example.clientsinfo.entities.Client;
import com.example.clientsinfo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "all")
    List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping(value = "add")
    Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

}
