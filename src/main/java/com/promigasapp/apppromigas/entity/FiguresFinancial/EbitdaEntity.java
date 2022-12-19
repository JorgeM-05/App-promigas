//package com.promigasapp.apppromigas.entity.FiguresFinancial;
//
//
//import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Entity
//@Table(name = "cf_ebitda")
//public class EbitdaEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int unique_id;
//
//    @OneToOne
//    @JoinColumn(name = "id_opportunity")
//    @NotNull
//    private OpportunitiesEntity idOpportunity;
//
//    @Column(name = "year")
//    private String year;
//
//    @Column(name = "ebitda_usd")
//    private String ebitdaUsd;
//
//    @Column(name = "value_ebitda_usd")
//    private String valueEbitdaUsd;
//
//    @Column(name = "ebitda_cop")
//    private String ebitdaCop;
//
//    @Column(name = "value_ebitda_cop")
//    private String valueEbitdaCop;
//}
