package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialFiguresRepository extends JpaRepository<FinancialFiguresEntity, Integer> {
//    public FinancialFiguresEntity findById(int userId);

    public FinancialFiguresEntity findByopportunity(OpportunitiesEntity opportunities);

//    public List<FinancialFiguresEntity> findByCapexCifraBetweenAndopportunity(float capexin, float capexEnd,OpportunitiesEntity opportunities);

}
