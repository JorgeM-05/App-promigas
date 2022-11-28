package com.promigasapp.apppromigas.reposiroty;

import lombok.Data;

@Data
//@Entity
//@Table(name = "nombre tabla")
public class OpportunitiesEntity {

    private int uniqid;
    public String country;
    public int opportunity;
    public String actives;
    public String potentials;

}
