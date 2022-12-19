package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunitiesRepository extends JpaRepository<OpportunitiesEntity, Integer> {
    //    public List<OpportunitiesEntity> findByIdpais(CountryEntity country);
    public List<OpportunitiesEntity> findByIdCountry(CountryEntity country);
    public OpportunitiesEntity findById(int Id);
}
//    @Query(value = "SELECT op FROM OpportunitiesEntity op WHERE op.unique_id=?1 AND op.idSector=?2")//
//    @Query(value = "SELECT o FROM CountryEntity c, OpportunitiesEntity o WHERE c.pais = ?1 AND c.tipoProyecto = ?2 AND o.idpais= ")
//    OpportunitiesEntity search(int id, SectorEntity idSector);
//
//    public OpportunitiesEntity findByIdAndidSector(int id,SectorEntity  idSector);

