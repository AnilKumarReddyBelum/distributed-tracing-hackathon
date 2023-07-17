package com.example.distributedtracing.msone.controller;

import com.example.distributedtracing.msone.entity.Client;
import com.example.distributedtracing.msone.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("clients")
@Slf4j
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @GetMapping
    public Collection<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable final Long id) throws Exception {
        return clientService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

}
