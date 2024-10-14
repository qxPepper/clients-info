package com.example.clientsinfo.repository;

import com.example.clientsinfo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
