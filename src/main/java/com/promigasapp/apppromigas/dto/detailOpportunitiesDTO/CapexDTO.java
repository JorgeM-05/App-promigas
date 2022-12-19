package com.promigasapp.apppromigas.dto.detailOpportunitiesDTO;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class CapexDTO {
//    public OpportunitiesEntity idOpportunity;
//    public String year;
//    public String capexUsd;
//    public String capexCop;
    public List<String> valueCapexUsd;
    public List<String> valueCapexCop;
}
