package com.promigasapp.apppromigas.dto;

import lombok.Data;

import java.util.List;

@Data
public class DetailOpportunitiesbyCountry {
//    private List<ListOportunitiesByCountry> oportunities;
    private String country;
    private String lastUpdateDate;
    private String description;
    private Transport transport;

    private FinancialFigures financialFigures;

}
