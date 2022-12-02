package com.promigasapp.apppromigas.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesAllByCountryDto {
    private int idpais;
    private String country;
    private List<ListOportunitiesByCountry> listOportunitiesByCountries;
}
