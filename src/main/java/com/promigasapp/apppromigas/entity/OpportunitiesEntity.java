package com.promigasapp.apppromigas.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "oportunidades")
public class OpportunitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    @NotNull
    private CountryEntity idpais;

    @JoinColumn(name = "nombre_oportunidad")
    @Column(name = "nombre_oportunidad")
    private String name_opportunities;

    @Column(name = "coordenadas")
    private String coordinates;

    @JoinColumn(name = "greenfield")
    private String greenfield;

    @JoinColumn(name = "MYA")
    private String MYA;

}
