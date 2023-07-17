package com.cotiviti.distributedtracing.mstwo.repository;

import com.cotiviti.distributedtracing.mstwo.entity.Payer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerRepository extends JpaRepository<Payer, Long> {
}
