package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.ListOportunitiesByCountry;
import com.promigasapp.apppromigas.dto.OpportunitiesAllByCountryDto;
//import com.promigasapp.apppromigas.entity.CountryEntity;
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

    public OpportunitiesAllByCountryDto getDataAllOpportunities(String country)throws NotFoundException {
        OpportunitiesAllByCountryDto opp = new OpportunitiesAllByCountryDto();
        CountryEntity countryEntity = countryService.getCountryEntity(country);
        List<OpportunitiesEntity> opportunitiesEntity = opportunitiesAllRepository.findByIdpais(countryEntity);
        opp.setListOportunitiesByCountries(mapToOpportunitiesAllDto(opportunitiesEntity));
        return null;
    }


    public OpportunitiesAllByCountryDto mapToOpportunitiesAllDto(List<OpportunitiesEntity> oppotunities){
        OpportunitiesAllByCountryDto opportunitiesAllByCountryDto = new OpportunitiesAllByCountryDto();

        if(oppotunities.size()>0){
            for(OpportunitiesEntity listOpp : oppotunities){
                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();List<ListOportunitiesByCountry> listOportunitiesByCountries =  new ArrayList<ListOportunitiesByCountry>();
                listOppDto.getOpportunities().add(listOpp.getName_opportunities());

                opportunitiesAllByCountryDto.setIdpais(listOpp.getIdpais().getUnique_id());
                opportunitiesAllByCountryDto.setCountry(listOpp.getIdpais().getPais());
                //
            }

        }
        return opportunitiesAllByCountryDto;
    }
}
