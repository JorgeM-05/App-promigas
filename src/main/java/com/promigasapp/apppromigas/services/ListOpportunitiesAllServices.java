package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.ListOportunitiesByCountry;
import com.promigasapp.apppromigas.dto.OpportunitiesAllByCountryDto;
//import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.ListOpportunitiesEntity;
//import com.promigasapp.apppromigas.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOpportunitiesAllServices {
    Logger logger = LoggerFactory.getLogger(ListOpportunitiesAllServices.class);

//    @Autowired
//    private CountryRepository countryRepository;

    public OpportunitiesAllByCountryDto getDataAllOpportunities(String country){
        OpportunitiesAllByCountryDto opp = new OpportunitiesAllByCountryDto();
//        opp.setListOportunitiesByCountries(mapToOpportunitiesAllDto(getAllOpportunities(country)));
//        mapToOpportunitiesAllDto(getAllOpportunities(country));
        return opp;
    }

    public List<String> getAllOpportunities(String country){

//        logger.info("countries :::: --> "+countryRepository.findAll());

        return null;
    }

//    public List<ListOportunitiesByCountry> mapToOpportunitiesAllDto(List<CountryEntity> opportunitiesEntities){
//
//        List<ListOportunitiesByCountry> listOportunitiesByCountries =  new ArrayList<ListOportunitiesByCountry>();
//
//        if(opportunitiesEntities.size()>0){
//            for(CountryEntity listOpp : opportunitiesEntities){
//                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();
//                  listOppDto.setUnique_id(listOpp.getUnique_id());
//                  listOppDto.setIdpais(listOpp.getIdpais());
//                  listOppDto.setGreenfield(listOpp.getGreenfield());
//                  listOppDto.setMYA(listOpp.getMYA());
//
//                listOportunitiesByCountries.add(listOppDto);
//            }
//        }
//        return listOportunitiesByCountries;
//    }
}
