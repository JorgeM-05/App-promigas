package com.promigasapp.apppromigas.dto.detailOpportunitiesDTO;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.FinancialFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OperatingFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.SectorDetailsDTO;
import lombok.Data;

@Data
public class DetailOpportunitiesbyCountry {
//    private List<ListOportunitiesByCountry> oportunities;
    private String nameOportunity;
    private String country;
    private String lastUpdateDate;
    private String description;
    private String sector;

    private FinancialFiguresDTO financialFiguresDTO;
    private OperatingFiguresDTO operatingFiguresDTO;

}
