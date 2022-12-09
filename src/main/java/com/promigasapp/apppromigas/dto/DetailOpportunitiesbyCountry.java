package com.promigasapp.apppromigas.dto;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.FinancialFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OperatingFiguresDTO;
import lombok.Data;

@Data
public class DetailOpportunitiesbyCountry {
//    private List<ListOportunitiesByCountry> oportunities;
    private String country;
    private String lastUpdateDate;
    private String description;
    private Transport transport;

    private FinancialFiguresDTO financialFiguresDTO;
    private OperatingFiguresDTO operatingFiguresDTO;

}
