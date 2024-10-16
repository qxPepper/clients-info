package com.example.clientsinfo.controller;

import com.example.clientsinfo.entities.Client;
import com.example.clientsinfo.entities.Info;
import com.example.clientsinfo.repository.ClientRepository;
import com.example.clientsinfo.repository.InfoRepository;
import com.example.clientsinfo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InfoRepository infoRepository;

    // 1) Добавление нового клиента
    @PostMapping(value = "create")
    Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // 2) Добавление нового контакта клиента (телефон или email)
    @PostMapping(value = "{id}/create")
    Info addByClientId(@RequestBody Info info, @PathVariable long id) {
        Client client = clientRepository.findById(id).get();
        String type = clientService.defineType(info.getContact());
        return infoRepository.save(new Info(info.getContact(), type, client));
    }

    // 3) Получение списка клиентов
    @GetMapping(value = "all")
    List<Client> findAll() {
        return clientRepository.findAll();
    }

    // 4) Получение информации по заданному клиенту (по id)
    @GetMapping(value = "{id}")
    Optional<Client> findById(@PathVariable long id) {
        return clientRepository.findById(id);
    }

    // 5) Получение списка контактов заданного клиента
    @GetMapping(value = "{id}/info")
    List<Info> findByClientId(@PathVariable long id) {
        return infoRepository.findByClientId(id);
    }

    // 6) Получение списка контактов заданного типа заданного клиента
    @GetMapping(value = "{id}/info/{type}")
    List<Info> findByClientIdAndType(@PathVariable long id, @PathVariable String type) {
        return infoRepository.findByClientIdAndType(id, type);
    }
}
