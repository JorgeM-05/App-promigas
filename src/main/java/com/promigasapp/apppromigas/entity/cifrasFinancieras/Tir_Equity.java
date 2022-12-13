package com.promigasapp.apppromigas.entity.cifrasFinancieras;

import com.promigasapp.apppromigas.entity.CountryEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Tir_Equity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @ManyToOne
    @JoinColumn(name = "id_CiFinanc")
    @NotNull
    private CountryEntity idCifFinc;

    @Column(name = " nombre de la columna de la tabla tal cual como esta en bd")
    private String nombreAproximado;
}
