package com.promigasapp.apppromigas.dto.detailOpportunitiesDTO;

import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class EbitdaDTO {

    public List<String> valueEbitdaUsd;
    public List<String> valueEbitdaCop;
}
