package com.example.distributedtracing.msone.service;

import com.example.distributedtracing.msone.entity.Client;
import com.example.distributedtracing.msone.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        client.setId(null);
        log.info("Enter into ClientService::create with empty id -> {}", client.getId());
        client = clientRepository.save(client);
        log.info("Exit from ClientService::create with id -> {}", client.getId());
        return client;
    }

    public Client update(Client client) {
        log.info("Enter into ClientService::update with empty id -> {}", client.getId());
        client = clientRepository.save(client);
        log.info("Exit from ClientService::update with id -> {}", client.getId());
        return client;
    }

    public Collection<Client> findAll() {
        log.info("Enter into ClientService::findAll");
        Collection<Client> clients = clientRepository.findAll();
        log.info("Exit from ClientService::findAll");
        return clients;
    }

    public Client findById(final Long id) throws Exception {
        log.info("Enter into ClientService::findById with id -> {}", id);
        Client client
                = clientRepository.findById(id).orElseThrow(Exception::new);
        log.info("Exit from ClientService::findById with name -> {}", client.getName());
        return client;
    }

    public void deleteById(Long id) {
        log.info("Enter into ClientService::deleteById with id -> {}", id);
        clientRepository.deleteById(id);
        log.info("Exit from ClientService::deleteById successfully with id  -> {}", id);
    }


}
