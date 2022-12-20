package com.promigasapp.apppromigas.repository.figures;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FiguresFinancial.TirProjectEntity;
import com.promigasapp.apppromigas.entity.FiguresFinancial.UtilityEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TirProjectRepository extends JpaRepository<TirProjectEntity, Integer> {
    public List<TirProjectEntity> findByIdOpportunity(OpportunitiesEntity opportunities);

}
