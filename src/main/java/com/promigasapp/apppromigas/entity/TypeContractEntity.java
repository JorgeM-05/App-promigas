package com.promigasapp.apppromigas.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_contract")
public class TypeContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unique_id;

    @Column(name = "type_contract")
    private String typeContract;

}