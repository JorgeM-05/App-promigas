package com.promigasapp.apppromigas.dto.opporunitiesDTO;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesDto {
    public int numberOpportunities;
    public int numberGreenfield;
    public int numberMYA;
    public List<OpportunitiesAll> opportunitiesByCountries;
}
