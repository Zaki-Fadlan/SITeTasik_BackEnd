package com.sitetasik.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "datel")
public class Datel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nama_datel",nullable = false,length = 40)
    private String namaDatel;

    @JsonIgnore
    @OneToMany(mappedBy = "datel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sto> sto;

}
