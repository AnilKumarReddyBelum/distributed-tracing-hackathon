package com.cotiviti.distributedtracing.mstwo.externalserviceutils;

import com.cotiviti.distributedtracing.mstwo.domain.Client;
import com.cotiviti.distributedtracing.mstwo.exception.ClientNotFoundException;
import com.cotiviti.distributedtracing.mstwo.exception.ClientServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExternalServiceUtils {

    private final RestTemplate restTemplate;

    @Value("${externalService.dt-ms-one-clients.url}")
    private String clientsApiUrl;

    public ExternalServiceUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Client isValidClient(final Long clientId) throws RuntimeException {
        log.info("enter into ExternalServiceUtils::isValidClient with id {}", clientId);
        Client client;
        try {
            client = restTemplate.getForObject(clientsApiUrl + clientId, Client.class);
            if (client == null) {
                throw new ClientNotFoundException("Not able to find the client for the give client Id " + clientId);
            }
            log.info("client info loading completed and full name of the client is {}", client.getFullName());
        } catch (Exception exception) {
            throw new ClientServiceException("Unknown exception, reason is " + exception.getMessage());
        }
        log.info("exit from ExternalServiceUtils::isValidClient with id {}", clientId);
        return client;
    }

}
