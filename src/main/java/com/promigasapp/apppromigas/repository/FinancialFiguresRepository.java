package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialFiguresRepository extends JpaRepository<FinancialFiguresEntity, Integer> {
}
