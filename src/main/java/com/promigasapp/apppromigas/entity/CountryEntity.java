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
    private String fecha_actualizacion;

    @JoinColumn(name = "tipo_proyecto")
    private String tipo_proyecto;

    @JoinColumn(name = "ubicaion_geografica")
    private String ubicaion_geografica;

    @JoinColumn(name = "descripcion_oportunidad")
    private String descripcion_oportunidad;

    @JoinColumn(name = "seccion_supuestos")
    private String seccion_supuestos;

    @JoinColumn(name = "horizonte")
    private String horizonte;

    @JoinColumn(name = "POC")
    private String POC;

    @JoinColumn(name = "TRM")
    private String TRM;

    @JoinColumn(name = "activo_financiero")
    private String activo_financiero;

    @JoinColumn(name = "prioridad")
    private String prioridad;
}
