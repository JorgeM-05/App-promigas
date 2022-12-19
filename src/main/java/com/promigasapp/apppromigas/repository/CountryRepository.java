package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    public CountryEntity findByNameContry(String country);


//    public CountryEntity findBypaisAndTipoProyecto(String countries,String tipoProyecto);
//
//    public CountryEntity findByTipoProyecto(String tipoProyecto);

}
