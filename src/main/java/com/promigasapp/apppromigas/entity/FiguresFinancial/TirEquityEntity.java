package com.promigasapp.apppromigas.entity.FiguresFinancial;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "cf_tir_equity")
public class TirEquityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_opportunity")
    @NotNull
    private OpportunitiesEntity idOpportunity;

    @Column(name = "year")
    private Date year;

    @Column(name = "tir_equity_figure")
    private String tirEqFig;

    @Column(name = "tir_equity_unit ")
    private String tirEqUnit;

    @Column(name = "tir_equity_capital_structure")
    private String tirEqCapital;

    @Column(name = "tir_equity_debt_cost")
    private String tirEqCost;

    @Column(name = "tir_equity_amortization")
    private String tirEqAmortizacion;
}
