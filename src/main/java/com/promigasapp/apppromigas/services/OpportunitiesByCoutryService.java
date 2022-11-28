package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunitiesByCoutryService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesByCoutryService.class);

    public OpportunitiesCountryDto getDataOpprt(String country) {
        OpportunitiesCountryDto opportunities = new OpportunitiesCountryDto();
        opportunities.setOpportunitiesByCountry(mapToOpportunitiesDTO(getOpportEntity(country)));

        return opportunities;
    }

    public List<DetailOpportunitiesbyCountry> getOpportEntity(String country) {
        DetailOpportunitiesbyCountry detailOpp = new DetailOpportunitiesbyCountry();
        Transport transport = new Transport();
        FinancialFigures financialFigures = new FinancialFigures();
        ListOportunitiesByCountry listOportunitiesByCountry = new ListOportunitiesByCountry();


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


        ArrayList<DetailOpportunitiesbyCountry>  array = new ArrayList<>();
        array.add(detailOpp);

        return array;
    }

    public List<OpportunitiesByCountry> mapToOpportunitiesDTO(List<DetailOpportunitiesbyCountry> detailOpportunitiesbyCountry) {
        List<OpportunitiesByCountry> opportunitiesList = new ArrayList<OpportunitiesByCountry>();
        if(detailOpportunitiesbyCountry.size()>0){
            for(DetailOpportunitiesbyCountry detail : detailOpportunitiesbyCountry){
                OpportunitiesByCountry opportunities = new OpportunitiesByCountry();
                opportunities.setUniqid(1);
                opportunities.setCountry(detail.getCountry());
                opportunities.setDescription(detail.getDescription());
                opportunities.setLastUpdateDate(detail.getLastUpdateDate());
                opportunities.setFinancialFigures(detail.getFinancialFigures());
                opportunities.setTransport(detail.getTransport());
//                opportunities.setOportunities(detail.getOportunities());
//                System.out.println("list array 2 :: "+detail.getOportunities());
                opportunitiesList.add(opportunities);
            }
        }


        return opportunitiesList;
    }
}
