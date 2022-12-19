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
//@Table(name = "fcl_shareholder ")
//public class FclShareholderEntity {
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
//    @Column(name = "shareholder_usd")
//    private String shareholderUsd;
//
//    @Column(name = "value_share_usd")
//    private String valueShareUsd;
//
//    @Column(name = "shareholder_cop")
//    private String shareholderCop;
//
//    @Column(name = "value_share_cop")
//    private String valueShareCop;
//}
