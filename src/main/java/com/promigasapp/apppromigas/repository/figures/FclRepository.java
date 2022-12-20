package com.promigasapp.apppromigas.repository.figures;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FiguresFinancial.CapexEntity;
import com.promigasapp.apppromigas.entity.FiguresFinancial.FclEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FclRepository extends JpaRepository<FclEntity, Integer> {
    public List<FclEntity> findByIdOpportunity(OpportunitiesEntity opportunities);

}
