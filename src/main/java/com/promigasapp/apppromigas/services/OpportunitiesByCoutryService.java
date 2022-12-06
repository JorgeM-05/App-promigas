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

    public OpportunitiesCountryDto getDataOpprt(int id_opportunity) {
        OpportunitiesCountryDto opportunities = new OpportunitiesCountryDto();
        opportunities.setOpportunitiesByCountry(mapToOpportunitiesDTO(getOpportEntity(id_opportunity)));

        return opportunities;
    }

    public List<DetailOpportunitiesbyCountry> getOpportEntity(String country) {


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
