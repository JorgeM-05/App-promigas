package com.promigasapp.apppromigas.entity.FiguresFinancial;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "cf_utility_net ")
public class UtilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_opportunity")
    @NotNull
    private OpportunitiesEntity idOpportunity;

    @Column(name = "year")
    private String year;

    @Column(name = "utility_usd")
    private String utilityUsd;

    @Column(name = "value_utility_usd")
    private String valueUtilityUsd;

    @Column(name = "utility_cop")
    private String utilityCop;

    @Column(name = "value_utility_cop")
    private String valueUtilityCop;
}
