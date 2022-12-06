package com.promigasapp.apppromigas.dto.all_opporunitiesDTO;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesDto {
    public int numberOpportunity;
    public String greenfield;
    public String MYA;
    private List<OpportunitiesAll> opportunitiesByCountries;
}
