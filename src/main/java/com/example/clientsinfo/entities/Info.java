package com.example.clientsinfo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "informations")
@NoArgsConstructor
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String contact;

    @Getter
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Info(String contact, String type, Client client) {
        this.contact = contact;
        this.type = type;
        this.client = client;
    }
}
