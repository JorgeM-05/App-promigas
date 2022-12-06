package com.promigasapp.apppromigas.dto;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class  ListOportunitiesByCountry {
    private int id_opportunities;
    private String opportunities;

}
