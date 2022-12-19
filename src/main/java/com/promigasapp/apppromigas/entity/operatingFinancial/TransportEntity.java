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
//@Table(name="co_transport")
//public class TransportEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int unique_id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_oportunitiy")
//    @NotNull
//    private OpportunitiesEntity idoportunity;
//
//    @Column(name = "transp_capacity_max")
//    private String transporteCapacityMax;
//
//    @Column(name = "trans_capacity_hired")
//    private String TransportCapacityHired;
//
//    @Column(name = "trans_vol_trans")
//    private String TransporteVolumen;
//
//    @Column(name = "trans_length_gasod")
//    private String TransporteLength;
//
//}
