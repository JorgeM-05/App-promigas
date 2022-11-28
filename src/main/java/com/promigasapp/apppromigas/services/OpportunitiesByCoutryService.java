package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.reposiroty.OpportunitiesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunitiesByCoutryService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesByCoutryService.class);

    public OpportunitiesCountryDto getDataOpprt(String country) {
        OpportunitiesCountryDto opportunities = new OpportunitiesCountryDto();
        opportunities.setOpportunitiesByCountry(mapToOpportunitiesDTO(getOpportEntity(country)));
//        getOpportEntity("colombia");
        return opportunities;
    }

    public DetailOpportunitiesbyCountry getOpportEntity(String country) {
        DetailOpportunitiesbyCountry detailOpp = new DetailOpportunitiesbyCountry();
        Transport transport = new Transport();
        FinancialFigures financialFigures = new FinancialFigures();


        detailOpp.setCountry(country);
        detailOpp.setLastUpdateDate("23 Noviembre");
        detailOpp.setDescription("Descripcion de la oportunidad");
        logger.info("get data Ent --- 0");

        transport.setTransportedVolume(22.2);
        transport.setPipelineLength(22.4);
        transport.setVolume(1500.1);
        transport.setAccumulatedUsers(2);

        detailOpp.setTransport(transport);

        financialFigures.setUnitCapex("US$");
        financialFigures.setValueCapex(450);
        financialFigures.setUnitIncome("US$");
        financialFigures.setValueIncome(470);
        financialFigures.setUnitEbitda("US$");
        financialFigures.setValueEbitda(435);
        financialFigures.setValueTirProject(465);
        financialFigures.setUnitTirEquity("US$");
        financialFigures.setCapitalStructure(40000);
        financialFigures.setDebtCost(2000);
        financialFigures.setAmortizationForm("amortizacion");

        detailOpp.setFinancialFigures(financialFigures);


        return detailOpp;
    }

    public OpportunitiesByCountry mapToOpportunitiesDTO(DetailOpportunitiesbyCountry detailOpportunitiesbyCountry) {
        OpportunitiesByCountry opportunities = new OpportunitiesByCountry();
        opportunities.setUniqid(1);
        opportunities.setCountry(detailOpportunitiesbyCountry.getCountry());
        opportunities.setDescription(detailOpportunitiesbyCountry.getDescription());
        opportunities.setLastUpdateDate(detailOpportunitiesbyCountry.getLastUpdateDate());
        opportunities.setFinancialFigures(detailOpportunitiesbyCountry.getFinancialFigures());
        return opportunities;
    }
}
