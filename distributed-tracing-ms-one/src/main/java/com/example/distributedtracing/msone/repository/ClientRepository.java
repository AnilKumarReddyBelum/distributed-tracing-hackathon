package com.example.distributedtracing.msone.repository;

import com.example.distributedtracing.msone.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
