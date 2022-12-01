package com.promigasapp.apppromigas.dto;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Data
public class ListOportunitiesByCountry {
    private int unique_id;
    private int idpais;
    private String Greenfield;
    private String MYA;

}
