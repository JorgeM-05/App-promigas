package com.promigasapp.apppromigas.entity.FiguresFinancial;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tir_equity")
public class TirProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_opportunity")
    @NotNull
    private OpportunitiesEntity idOpportunity;

    @Column(name = "year")
    private String year;

    @Column(name = "tir_project_figure ")
    private String tirprojfigure;

    @Column(name = "tir_project_unit")
    private String tirprojectunit;
}
