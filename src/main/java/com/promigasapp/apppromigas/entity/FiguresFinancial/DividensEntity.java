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
//@Table(name = "cf_dividends")
//public class DividensEntity {
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
//    @Column(name = "dividens_usd")
//    private String dividensusd;
//
//    @Column(name = "value_dividends_usd ")
//    private String valuedividensusd;
//
//    @Column(name = "dividens_cop")
//    private String dividenscop;
//
//    @Column(name = "value_dividends_cop")
//    private String valuedividenscop;
//
//}
