//package com.promigasapp.apppromigas.entity.FiguresFinancial;
//
//import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Entity
//@Table(name = "cf_capex ")
//public class CapexEntity {
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
//    @Column(name = "capex_usd")
//    private String capexUsd;
//
//    @Column(name = "value_capex_usd")
//    private String valueCapexUsd;
//
//    @Column(name = "capex_cop")
//    private String capexCop;
//
//    @Column(name = "value_capex_cop")
//    private String valueCapexCop;
//}
