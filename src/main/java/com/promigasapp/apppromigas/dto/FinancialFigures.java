package com.promigasapp.apppromigas.dto;

import lombok.Data;

@Data
public class FinancialFigures {
    private String unitCapex;
    private float valueCapex;

    private String unitIncome;
    private float valueIncome;

    private String unitEbitda;
    private float valueEbitda;

    private float valueTirProject;

    private String unitTirEquity;
    private float capitalStructure;
    private float debtCost;
    private String amortizationForm;
}
