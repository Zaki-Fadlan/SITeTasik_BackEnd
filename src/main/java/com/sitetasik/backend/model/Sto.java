package com.sitetasik.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "sto")
public class Sto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nama_sto",nullable = false,length = 40)
    private String namaSto;

    @ManyToOne(targetEntity = Datel.class)
    private Datel datel;
}
