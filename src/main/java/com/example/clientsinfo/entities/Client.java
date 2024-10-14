package com.example.clientsinfo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "clients")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 24, nullable = false, unique = true)
    private String name;
}
