package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesAll;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
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

    public OpportunitiesDto getDataOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        getOpportunitiesEntity();
//        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(getOpportunitiesEntity()));
        return opportunitiesDto;
    }

    // consultando en Base datos
    public List<OpportunitiesEntity> getOpportunitiesEntity(){

        logger.info("countries :::: --> "+opportunitiesAllRepository.findAll());
        System.out.println(opportunitiesAllRepository.findAll().size());
        return opportunitiesAllRepository.findAll();
    }

    // Mapeando datos de BD a Json out ---
    public List<OpportunitiesAll> mapToOpportunitiesDTO(List<OpportunitiesEntity> opportunitiesEntityList){
        List<OpportunitiesAll> opportunitiesByCountriesList= new ArrayList<OpportunitiesAll>();

        if(opportunitiesEntityList.size()>0){
            for(OpportunitiesEntity opportunities : opportunitiesEntityList){
                OpportunitiesAll opportunitiesByCountries = new OpportunitiesAll();

                opportunitiesByCountriesList.add(opportunitiesByCountries);
            }
        }
        logger.info("Map"+opportunitiesByCountriesList);
        return opportunitiesByCountriesList;
    }

}
