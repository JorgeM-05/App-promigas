package com.promigasapp.apppromigas.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesDto {
    private List<OpportunitiesAll> opportunitiesByCountries;
}
