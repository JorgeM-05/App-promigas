package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunitiesRepository extends JpaRepository<OpportunitiesEntity, Integer> {
    public List<OpportunitiesEntity> findByIdpais(CountryEntity country);

    public OpportunitiesEntity findById(int Id);



}