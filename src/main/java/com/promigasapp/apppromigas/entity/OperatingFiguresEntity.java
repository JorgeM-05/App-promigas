package com.promigasapp.apppromigas.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "cifras_operativas")
public class OperatingFiguresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @ManyToOne
    @JoinColumn(name = "id_oportunidad")
    @NotNull
    private OpportunitiesEntity opportunity;

    @Column(name = "solEnerg_potencia_unid")
    private String sol_energ_potencia_unid;

    @Column(name = "solEnerg_potencia_cifra")
    private float sol_energ_potencia_cifra;

    @Column(name = "solEnerg_gener_unid")
    private String sol_energ_gener_unid;

    @Column(name = "solEnerg_gener_cifra")
    private float sol_energ_gener_cifra;

    @Column(name = "solEnerg_degrada_prom")
    private float sol_energ_degrada_prom;

    @Column(name = "solEnerg_hora_sol")
    private float sol_energ_hora_sol;

    @Column(name = "trans_cap_max")
    private float trans_cap_max;

    @Column(name = "trans_vol_Trans")
    private float trans_vol_Trans;

    @Column(name = "trans_int_gasod")
    private float trans_int_gasod;

    @Column(name = "distr_volumen")
    private float distr_volumen;

    @Column(name = "distr_conex_periodo")
    private float distr_conex_periodo;

    @Column(name = "distr_kms_Red")
    private float distr_kms_Red;

    @Column(name = "distr_penetracion")
    private float distr_penetracion;
}
