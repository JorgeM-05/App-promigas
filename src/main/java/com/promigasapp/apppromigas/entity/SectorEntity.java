package com.promigasapp.apppromigas.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "sector")
public class SectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @OneToOne
    @JoinColumn(name = "id_oportunidad")
    @NotNull
    private OpportunitiesEntity opportunity;

    @Column(name = "tipo_sector")
    private String tipoSector;

}
