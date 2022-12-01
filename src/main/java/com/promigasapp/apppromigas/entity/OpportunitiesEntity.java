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

    @JoinColumn(name = "id_pais")
    @NotNull
    private int id_pais;

    @JoinColumn(name = "greenfield")
    private String greenfield;

    @JoinColumn(name = "MYA")
    private String MYA;

}
