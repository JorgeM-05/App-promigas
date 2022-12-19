package com.promigasapp.apppromigas.entity.operatingFinancial;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "co_energy_solutions")
public class EnergySolutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @ManyToOne
    @JoinColumn(name = "id_opportunity")
    @NotNull
    private OpportunitiesEntity idoportunity;

    @Column(name = "solenerg_power_unit ")
    private String solenergunit;

    @Column(name = "solenerg_power_figure")
    private String solenergfigure;

    @Column(name = "solenerg_gener_figure ")
    private String solgenerfigure;

    @Column(name = "solenerg_gener_unit ")
    private String solgenerunit;

    @Column(name = "solenerg_degradation_average")
    private String soldegradation;

    @Column(name = "solenerg_hour_sun")
    private String solenerghoursun;
}
