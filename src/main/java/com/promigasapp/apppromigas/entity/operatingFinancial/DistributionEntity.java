//package com.promigasapp.apppromigas.entity.operatingFinancial;
//
//import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Entity
//@Table(name = "co_distribution")
//public class DistributionEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int unique_id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_oportunitiy")
//    @NotNull
//    private OpportunitiesEntity idOportunity;
//
//    @Column(name = "volume_distribution")
//    private String volumeDistribution;
//
//    @Column(name = "distr_connec_period")
//    private String distriPeriod;
//
//    @Column(name = "distr_kms_red ")
//    private String distributionKms;
//
//    @Column(name = "distr_user_accumulated")
//    private String distributionUsers;
//
//    @Column(name = "distr_penetration")
//    private String distributionPenetration;
//
//}
