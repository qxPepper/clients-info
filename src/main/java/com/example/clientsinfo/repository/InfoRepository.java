package com.example.clientsinfo.repository;

import com.example.clientsinfo.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Integer> {

}
