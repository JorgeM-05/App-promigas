package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.ListOportunitiesByCountry;
import com.promigasapp.apppromigas.dto.OpportunitiesAllByCountryDto;
//import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesAll;
import com.promigasapp.apppromigas.entity.CountryEntity;
//import com.promigasapp.apppromigas.repository.CountryRepository;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.repository.OpportunitiesAllRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOpportunitiesAllServices {
    Logger logger = LoggerFactory.getLogger(ListOpportunitiesAllServices.class);

    @Autowired
    private OpportunitiesAllRepository opportunitiesAllRepository;
    @Autowired
    private CountryService countryService;

    public OpportunitiesAllByCountryDto getDataOpportunities(String country)throws NotFoundException {
        OpportunitiesAllByCountryDto opp = new OpportunitiesAllByCountryDto();
        CountryEntity countryEntity = countryService.getCountryEntity(country);
        List<OpportunitiesEntity> opportunitiesEntity = opportunitiesAllRepository.findByIdpais(countryEntity);
//        mapToOpportunitiesAllDto(opportunitiesEntity);
        opp.setIdpais(countryEntity.getUnique_id());
        opp.setCountry(countryEntity.getPais());
        opp.setListOportunitiesByCountries(mapToOpportunitiesAllDto(opportunitiesEntity));
        return opp;
    }


    public List<ListOportunitiesByCountry> mapToOpportunitiesAllDto(List<OpportunitiesEntity> oppotunities){
        List<ListOportunitiesByCountry> listOp = new ArrayList<ListOportunitiesByCountry>();

        if(oppotunities.size()>0){
            for(OpportunitiesEntity listOpp : oppotunities){
                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();

                listOppDto.setId_opportunities(listOpp.getUnique_id());
                listOppDto.setOpportunities(listOpp.getName_opportunities());

                listOp.add(listOppDto);
            }
        }
        return listOp;
    }
}
