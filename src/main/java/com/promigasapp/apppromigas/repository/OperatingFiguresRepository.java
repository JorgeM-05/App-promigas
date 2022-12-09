package com.promigasapp.apppromigas.repository;

import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OperatingFiguresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatingFiguresRepository extends JpaRepository<OperatingFiguresEntity, Integer> {
}
