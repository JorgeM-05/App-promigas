package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<SectorEntity, Integer> {
    public SectorEntity findByopportunity(OpportunitiesEntity opportunities);
    //aqui esta mal toca consultar el sector y despues compararlo y buscarlo con la oportunidad

//    public SectorEntity findByopportunityAndTipoSector(OpportunitiesEntity opportunities, String sector);

    public SectorEntity findByTipoSector(String sector);

}
