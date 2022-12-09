package com.promigasapp.apppromigas.dto.filter;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunitiesByCountryDTO;
import lombok.Data;

import java.util.List;

@Data
public class ParamFilterDTO {
    public List<OpportunitiesByCountryDTO> opportunities;
//    public String pais;
    
}
