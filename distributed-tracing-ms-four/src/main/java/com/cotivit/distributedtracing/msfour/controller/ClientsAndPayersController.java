package com.cotivit.distributedtracing.msfour.controller;

import com.cotivit.distributedtracing.msfour.domain.ClientsAndPayers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("clientsAndPayers")
@Slf4j
public class ClientsAndPayersController {

    @Value("${externalService.dt-ms-three-clientsAndPayers.api}")
    private String clientsAndPayersAPI;


    private final RestTemplate restTemplate;

    public ClientsAndPayersController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public ResponseEntity<ClientsAndPayers> fetchClientsAndPayers() {
        log.info("enter into fetchClientsAndPayers from ms-3 micro service");
        ClientsAndPayers clientsAndPayers = restTemplate.getForObject(clientsAndPayersAPI, ClientsAndPayers.class);
        log.info("exit from fetchClientsAndPayers  from ms-3 micro service clientsAndPayers data is -> {}", clientsAndPayers);
        return ResponseEntity.ok(clientsAndPayers);
    }


}
