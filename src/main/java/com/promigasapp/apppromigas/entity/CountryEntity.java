package com.promigasapp.apppromigas.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="pais")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @JoinColumn(name = "pais")
    @NotNull
    private int pais;

    @JoinColumn(name = "fecha_actualizacion")
    private String Greenfield;

    @JoinColumn(name = "MYA")
    private String MYA;
}
