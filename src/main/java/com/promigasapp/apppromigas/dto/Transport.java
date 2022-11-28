package com.promigasapp.apppromigas.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class Transport {
    private double transportedVolume;
    private double pipelineLength;
    private double volume;
    private int accumulatedUsers;

}
