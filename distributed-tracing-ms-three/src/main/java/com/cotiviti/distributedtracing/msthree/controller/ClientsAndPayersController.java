package com.cotiviti.distributedtracing.msthree.controller;

import com.cotiviti.distributedtracing.msthree.domain.Client;
import com.cotiviti.distributedtracing.msthree.domain.ClientsAndPayers;
import com.cotiviti.distributedtracing.msthree.domain.Payer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("clientsAndPayers")
@Slf4j
public class ClientsAndPayersController {

    @Value("${externalService.dt-ms-one-clients.api}")
    private String clientsAPI;

    @Value("${externalService.dt-ms-two-payers.api}")
    private String payersAPI;

    private final RestTemplate restTemplate;

    public ClientsAndPayersController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public ResponseEntity<ClientsAndPayers> fetchClientsAndPayers() {
        log.info("enter into fetchClientsAndPayers");
        List<Client> clients = restTemplate.getForObject(clientsAPI, List.class);
        List<Payer> payers = restTemplate.getForObject(payersAPI, List.class);
        log.info("ClientsAndPayersController::fetchClientsAndPayers clients size -> {}", clients != null ? clients.size() : 0);
        log.info("ClientsAndPayersController::fetchClientsAndPayers payers size -> {}", payers != null ? payers.size() : 0);
        log.info("exit from fetchClientsAndPayers");
        return ResponseEntity.ok(new ClientsAndPayers(clients, payers));
    }


}
