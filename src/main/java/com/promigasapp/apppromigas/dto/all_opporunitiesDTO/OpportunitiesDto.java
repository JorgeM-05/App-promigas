package com.promigasapp.apppromigas.dto.all_opporunitiesDTO;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesDto {
    public int numberOpportunity;
    public int greenfield;
    public int mya;
    private List<OpportunitiesAll> opportunitiesByCountries;
}
