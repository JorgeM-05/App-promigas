package com.promigasapp.apppromigas.repository.figures;

import com.promigasapp.apppromigas.entity.FiguresFinancial.IncomeEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
    public List<IncomeEntity> findByIdOpportunity(OpportunitiesEntity opportunities);

}
