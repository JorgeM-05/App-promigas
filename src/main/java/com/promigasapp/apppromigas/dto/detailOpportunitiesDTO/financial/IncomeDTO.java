package com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;

@Data
public class IncomeDTO {
    public int unique_id;
    public List<String> valueCapexUsd;
    public List<String> valueCapexCop;
}
