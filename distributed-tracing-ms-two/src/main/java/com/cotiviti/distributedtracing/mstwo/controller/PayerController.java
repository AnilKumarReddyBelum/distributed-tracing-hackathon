package com.cotiviti.distributedtracing.mstwo.controller;

import com.cotiviti.distributedtracing.mstwo.entity.Payer;
import com.cotiviti.distributedtracing.mstwo.service.PayerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("payers")
public class PayerController {

    private final PayerService payerService;

    public PayerController(PayerService payerService) {
        this.payerService = payerService;
    }

    @PostMapping
    public Payer create(@RequestBody Payer payer) throws Exception {
        return payerService.create(payer);
    }


    @PutMapping
    public Payer update(@RequestBody Payer payer) throws Exception {
        return payerService.update(payer);
    }

    @GetMapping
    public Collection<Payer> findAll() {
        return payerService.findAll();
    }

    @GetMapping("{id}")
    public Payer findById(@PathVariable final Long id) throws Exception {
        return payerService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable final Long id) {
        payerService.deleteById(id);
    }
}
