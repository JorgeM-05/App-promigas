package com.promigasapp.apppromigas.entity.FiguresFinancial;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "cf_fcl ")
public class FclEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_opportunity")
    @NotNull
    private OpportunitiesEntity idOpportunity;

    @Column(name = "year")
    private String year;

    @Column(name = "fcl_usd")
    private String fclUsd;
    @Column(name = "value_fcl_usd")
    private String valueFclUsd;
    @Column(name = "fcl_cop")
    private String fclCop;
    @Column(name = "value_fcl_cop")
    private String valueFclCop;
}
