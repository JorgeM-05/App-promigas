package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.FinancialFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OperatingFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OperatingFiguresEntity;
import com.promigasapp.apppromigas.repository.FinancialFiguresRepository;
import com.promigasapp.apppromigas.repository.OperatingFiguresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunitiesByCoutryService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesByCoutryService.class);
    @Autowired
    private FinancialFiguresRepository financialFiguresRepository;
    @Autowired
    private OperatingFiguresRepository operatingFiguresRepository;

    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {
        logger.info("estramos a consultar a la bd");
        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();
        List<FinancialFiguresEntity> financialFiguresEntities = financialFiguresRepository.findAll();
        List<OperatingFiguresEntity> operatingFiguresEntities = operatingFiguresRepository.findAll();
        logger.info("mapeamos al dto");

        logger.info("map to financial :: "+mapTodetailFinancial(financialFiguresEntities));
        logger.info("map to financial :: "+mapTodetailopertting(operatingFiguresEntities));

        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(
                mapToAll(mapTodetailFinancial(financialFiguresEntities),
                        mapTodetailopertting(operatingFiguresEntities)));
        return opportunitiesdetailDetailsDTO;
    }

    public FinancialFiguresDTO mapTodetailFinancial(List<FinancialFiguresEntity> financialEtity){
        FinancialFiguresDTO financialFiguresDTO = new FinancialFiguresDTO();

        if(financialEtity.size()>0){
            for(FinancialFiguresEntity figuresEntity : financialEtity){
//                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();
                logger.info("Capex unidad:::"+ figuresEntity.getCapex_unidades());
                logger.info("Capex cifra::: "+figuresEntity.getCapex_cifra());
                financialFiguresDTO.setUnitCapex(figuresEntity.getCapex_unidades());
                financialFiguresDTO.setValueCapex(figuresEntity.getCapex_cifra());
                financialFiguresDTO.setUnitEbitda(figuresEntity.getEbitda_unidades());
                financialFiguresDTO.setValueEbitda(figuresEntity.getEbitda_cifra());
                financialFiguresDTO.setUnitIncome(figuresEntity.getIngresos_unidades());
                financialFiguresDTO.setValueIncome(figuresEntity.getIngresos_cifra());
            }
        }
        return financialFiguresDTO;
    }

    public OperatingFiguresDTO mapTodetailopertting(List<OperatingFiguresEntity> financialEtity){
        OperatingFiguresDTO operatingFiguresDTO = new OperatingFiguresDTO();

        if(financialEtity.size()>0){
            for(OperatingFiguresEntity operatingEntity : financialEtity){
//                operatingFiguresDTO.set
            }
        }
        return operatingFiguresDTO;
    }

    public OpportunitiesByCountry mapToAll(FinancialFiguresDTO financialFiguresDTO, OperatingFiguresDTO operatingFiguresDTO){
        OpportunitiesByCountry opportunities = new OpportunitiesByCountry();
        opportunities.setFinancialFiguresDTO(financialFiguresDTO);
        opportunities.setOperatingFiguresDTO(operatingFiguresDTO);

        return opportunities;
    }
}

