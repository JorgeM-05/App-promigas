package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesAll;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.repository.CountryRepository;
import com.promigasapp.apppromigas.repository.OpportunitiesAllRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunitiesService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesService.class);
    @Autowired
    private OpportunitiesAllRepository opportunitiesAllRepository;
    @Autowired
    private CountryRepository countryRepository;



    public OpportunitiesDto getDataOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(getOpportunitiesEntity(),getCountryEntity()));
        return opportunitiesDto;
    }

    // consultando en Base datos
    public List<OpportunitiesEntity> getOpportunitiesEntity(){
        return opportunitiesAllRepository.findAll();
    }
    public List<CountryEntity> getCountryEntity(){
        return countryRepository.findAll();
    }

    // Mapeando datos de BD a Json out ---
    public List<OpportunitiesAll> mapToOpportunitiesDTO(
                        List<OpportunitiesEntity> opportunitiesEntityList,
                        List<CountryEntity> countryEntities)
    {
        List<OpportunitiesAll> opportunitiesByCountriesList= new ArrayList<OpportunitiesAll>();

        if(countryEntities.size()>0 && opportunitiesEntityList.size()>0){

            for(CountryEntity country : countryEntities){
                System.out.println(country.getUnique_id());
                for(OpportunitiesEntity oppor : opportunitiesEntityList){
                    if(country.getUnique_id() == oppor.getId_pais()){
                        OpportunitiesAll opportunitiesAll = new OpportunitiesAll();

                        opportunitiesAll.setCountry(country.getPais());
                        opportunitiesAll.setNumberOpportunity(opportunitiesEntityList.size());
                        opportunitiesAll.setGreenfield(oppor.getGreenfield());
                        opportunitiesAll.setMYA(oppor.getMYA());
                        opportunitiesAll.setUniqid(country.getUnique_id());

                        opportunitiesByCountriesList.add(opportunitiesAll);
                    }
                }
            }
        }
        return opportunitiesByCountriesList;
    }

}
