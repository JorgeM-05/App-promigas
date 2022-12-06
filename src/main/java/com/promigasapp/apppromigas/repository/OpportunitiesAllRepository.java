package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunitiesAllRepository extends JpaRepository<OpportunitiesEntity, Integer> {
    public List<OpportunitiesEntity> findByIdpais(CountryEntity country);

    @Query("select count(*) from oportunidades where oportunidades.id_pais= ?1 ")
    public int findById_pais(int id_pais);


}