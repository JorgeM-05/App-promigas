package com.promigasapp.apppromigas.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "opportunities")
public class OpportunitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_country")
    @NotNull
    private CountryEntity idCountry;

    @OneToOne
    @JoinColumn(name = "id_sector")
    @NotNull
    private SectorEntity idSector;

    @OneToOne
    @JoinColumn(name = "type_contract")
    @NotNull
    private TypeContractEntity idContract;

    @JoinColumn(name = "greenfield")
    private String greenfield;

    @JoinColumn(name = "MYA")
    private String MYA;

    @Column(name = "project_title")
    private String projecTitle;

    @Column(name = "date_update")
    private String date;

    @Column(name = "coordinates ")
    private String coordinates;

    @Column(name = "opportunity_descrip ")
    private String descrip;

    @Column(name = "assumptions_section")
    private String section;

    @Column(name = "horizon_operation")
    private String horizonope;

    @Column(name = "pre_operation_horizon")
    private String horizonpre;

    @Column(name = "POC")
    private String poc;

    @Column(name = "TRM_base_capex")
    private String trmBase;

    @Column(name = "TRM_fin_capex")
    private String trmFin;

    @Column(name = "prop_capex_usd")
    private String propCapexUsd;

    @Column(name = "prop_capex_cop")
    private String propCapexCop;

    @Column(name = "financial_asset")
    private String financilAsset;

}
