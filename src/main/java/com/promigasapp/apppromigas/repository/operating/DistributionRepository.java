package com.promigasapp.apppromigas.repository.Operating;

import com.promigasapp.apppromigas.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DistributionRepository extends JpaRepository<CountryEntity, Integer> {
}
