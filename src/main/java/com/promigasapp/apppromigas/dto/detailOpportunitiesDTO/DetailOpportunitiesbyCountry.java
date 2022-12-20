package com.promigasapp.apppromigas.dto.detailOpportunitiesDTO;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.financial.*;
import lombok.Data;

@Data
public class DetailOpportunitiesbyCountry {
//    private List<ListOportunitiesByCountry> oportunities;
    public String nameOportunity;
    public String country;
    public String lastUpdateDate;
    public String description;
    public String sector;
    public CapexDTO capexDTO;
    public EbitdaDTO ebitdaDTO;
    public DividensDTO dividensDTO;
    public FclDTO fclDTO;
    public FclShareHolderDTO fclShareHolderDTO;
    public IncomeDTO incomeDTO;


}
