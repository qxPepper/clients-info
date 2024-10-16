package com.example.clientsinfo.repository;

import com.example.clientsinfo.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {

    List<Info> findByClientId(Long clientId);

    List<Info> findByClientIdAndType(Long id, String type);
}
