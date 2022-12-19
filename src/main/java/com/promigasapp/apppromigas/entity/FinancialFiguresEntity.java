//package com.promigasapp.apppromigas.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Entity
//@Table(name = "cifras_financieras")
//public class FinancialFiguresEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int unique_id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_oportunidad")
//    @NotNull
//    private OpportunitiesEntity opportunity;
//
//    @Column(name = "capex_unidades")
//    private String capex_unidades;
//
//    @Column(name = "capex_cifra")
//    private float capexCifra;
//
//    @Column(name = "ingresos_unidades")
//    private String ingresos_unidades;
//
//    @Column(name = "ingresos_cifra")
//    private float ingresos_cifra;
//
//    @Column(name = "ebitda_unidades")
//    private String ebitda_unidades;
//
//    @Column(name = "ebitda_cifra")
//    private float ebitda_cifra;
//
//    @Column(name = "tir_proyecto")
//    private float tir_proyecto;
//
//    @Column(name = "tarifa_unidades")
//    private String tarifa_unidades;
//
//    @Column(name = "tarifa_cifra")
//    private float tarifa_cifra;
//
//    @Column(name = "tarifa_tipo_index")
//    private String tarifa_tipo_index;
//
//    @Column(name = "opex_unidades")
//    private String opex_unidades;
//
//    @Column(name = "opex_cifra")
//    private float opex_cifra;
//
//    @Column(name = "utilidad_neta_unidades")
//    private String utilidad_neta_unidades;
//
//    @Column(name = "utilidad_neta_cifra")
//    private float utilidad_neta_cifra;
//}
