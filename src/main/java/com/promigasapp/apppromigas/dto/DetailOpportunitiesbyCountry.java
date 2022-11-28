package com.promigasapp.apppromigas.dto;

import lombok.Data;

@Data
public class DetailOpportunitiesbyCountry {
    private String country;
    private String lastUpdateDate;
    private String description;
    private Transport transport;

    private FinancialFigures financialFigures;

}
