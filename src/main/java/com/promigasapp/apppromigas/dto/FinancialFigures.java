package com.promigasapp.apppromigas.dto;

import lombok.Data;

@Data
public class FinancialFigures {
    private String unitCapex;
    private double valueCapex;

    private String unitIncome;
    private double valueIncome;

    private String unitEbitda;
    private double valueEbitda;

    private double valueTirProject;

    private String unitTirEquity;
    private double capitalStructure;
    private double debtCost;
    private String amortizationForm;
}
