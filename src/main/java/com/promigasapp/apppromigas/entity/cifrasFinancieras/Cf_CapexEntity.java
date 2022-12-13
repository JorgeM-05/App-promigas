package com.promigasapp.apppromigas.entity.cifrasFinancieras;

import com.promigasapp.apppromigas.entity.CountryEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "nombretabla???") //nombre de la tabla en la bd
public class Cf_CapexEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @ManyToOne
    @JoinColumn(name = "id_CiFinanc")
    @NotNull
    private CountryEntity idCifFinc;

    @Column(name = "value_capex_USD")
    private String valueCapexUSD;

    @Column(name = "value_capex_COP")
    private String valueCapexCOP;

    @Column(name = "anio")
    private Date anio;
}
