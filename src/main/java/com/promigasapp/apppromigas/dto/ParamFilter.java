package com.promigasapp.apppromigas.dto;

import lombok.Data;

@Data
public class ParamFilter {
    public int capex;
    public String pais;
	public int getCapex() {
		return capex;
	}
	public void setCapex(int capex) {
		this.capex = capex;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
    
    
}
