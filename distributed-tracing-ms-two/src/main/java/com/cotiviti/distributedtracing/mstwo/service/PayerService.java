package com.cotiviti.distributedtracing.mstwo.service;

import com.cotiviti.distributedtracing.mstwo.domain.Client;
import com.cotiviti.distributedtracing.mstwo.entity.Payer;
import com.cotiviti.distributedtracing.mstwo.externalserviceutils.ExternalServiceUtils;
import com.cotiviti.distributedtracing.mstwo.repository.PayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@Slf4j
public class PayerService {

    private final PayerRepository payerRepository;
    private final ExternalServiceUtils externalServiceUtils;

    public PayerService(PayerRepository payerRepository, ExternalServiceUtils externalServiceUtils) {
        this.payerRepository = payerRepository;
        this.externalServiceUtils = externalServiceUtils;
    }

    public Payer create(Payer payer) throws Exception {
        log.info("enter into PayerService:: create");
        if (payer == null || payer.getClientId() == null) {
            throw new Exception("Invalid Payload, please check your payer payload to persist");
        }
        Client client = externalServiceUtils.isValidClient(payer.getClientId());
        log.info("client info loading completed -> {}", client.getFullName());
        log.info("exit from PayerService:: create");
        return payerRepository.save(payer);
    }

    public Payer update(Payer payer) throws Exception {
        log.info("enter into PayerService:: update");
        if (payer == null || payer.getClientId() == null) {
            throw new Exception("Invalid Payload, please check your payer payload to update");
        }
        Client client = externalServiceUtils.isValidClient(payer.getClientId());
        log.info("client info loading completed -> {}", client.getFullName());
        log.info("exit from PayerService:: update");
        return payerRepository.save(payer);
    }

    public Collection<Payer> findAll() {
        log.info("enter into PayerService:: findAll");
        Collection<Payer> payers = payerRepository.findAll();
        log.info("exit from PayerService:: findAll");
        return payers;
    }

    public Payer findById(final Long id) throws Exception {
        log.info("enter into PayerService:: findById -> {}", id);
        if (id == null) {
            throw new Exception("Invalid id, please check your request");
        }
        Payer payer = payerRepository.findById(id).orElseThrow(Exception::new);
        log.info("exit from PayerService:: findById -> {}", id);
        return payer;
    }

    public void deleteById(Long id) {
        log.info("enter into PayerService:: deleteById -> {}", id);
        payerRepository.deleteById(id);
        log.info("exit from PayerService:: deleteById -> {}", id);
    }
}
