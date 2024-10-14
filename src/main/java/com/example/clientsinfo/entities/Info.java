package com.example.clientsinfo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 24, nullable = false, unique = true)
    private String phone;

    @Column(length = 24, nullable = false, unique = true)
    private String email;

}
