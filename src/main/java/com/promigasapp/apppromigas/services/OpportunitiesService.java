package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.OpportunitiesAll;
import com.promigasapp.apppromigas.dto.OpportunitiesDto;
import com.promigasapp.apppromigas.reposiroty.OpportunitiesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunitiesService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesService.class);

    public OpportunitiesDto getDataOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        logger.info("****Map"+mapToOpportunitiesDTO(getOpportunitiesEntity()));

        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(getOpportunitiesEntity()));
        System.out.println(opportunitiesDto.getOpportunitiesByCountries());
        return opportunitiesDto;
    }

    // recogiendo datos de BD -- simulacion
    public List<OpportunitiesEntity> getOpportunitiesEntity(){
        OpportunitiesEntity opportunitiesEntity = new OpportunitiesEntity();
        opportunitiesEntity.setUniqid(0);
        opportunitiesEntity.setCountry("Colombia");
        opportunitiesEntity.setOpportunity(10);
        opportunitiesEntity.setActives("active");
        opportunitiesEntity.setPotentials("oportunidades");

        OpportunitiesEntity opportunitiesEntity2 = new OpportunitiesEntity();
        opportunitiesEntity2.setUniqid(1);
        opportunitiesEntity2.setCountry("Panama");
        opportunitiesEntity2.setOpportunity(15);
        opportunitiesEntity2.setActives("active");
        opportunitiesEntity2.setPotentials("oportunidades panama" );

        OpportunitiesEntity opportunitiesEntity3 = new OpportunitiesEntity();
        opportunitiesEntity3.setUniqid(2);
        opportunitiesEntity3.setCountry("Estados Unidos");
        opportunitiesEntity3.setOpportunity(10);
        opportunitiesEntity3.setActives("active");
        opportunitiesEntity3.setPotentials("oportunidades Estados unidos");

        OpportunitiesEntity opportunitiesEntity4 = new OpportunitiesEntity();
        opportunitiesEntity4.setUniqid(3);
        opportunitiesEntity4.setCountry("Brasil");
        opportunitiesEntity4.setOpportunity(20);
        opportunitiesEntity4.setActives("active");
        opportunitiesEntity4.setPotentials("oportunidades Brasil");




        ArrayList<OpportunitiesEntity>  array = new ArrayList<>();
        array.add(opportunitiesEntity);
        array.add(opportunitiesEntity2);
        array.add(opportunitiesEntity3);
        array.add(opportunitiesEntity4);


        System.out.println(" ::[ "+array.get(0));
        System.out.println(" <<[ "+array.get(1));


        return array;
    }

    // Mapeando datos de BD a Json out ---
    public List<OpportunitiesAll> mapToOpportunitiesDTO(List<OpportunitiesEntity> opportunitiesEntityList){
        List<OpportunitiesAll> opportunitiesByCountriesList= new ArrayList<OpportunitiesAll>();

        System.out.println(opportunitiesEntityList.size());
        if(opportunitiesEntityList.size()>0){
            for(OpportunitiesEntity opportunities : opportunitiesEntityList){
                OpportunitiesAll opportunitiesByCountries = new OpportunitiesAll();

                opportunitiesByCountries.setCountry(opportunities.getCountry());
                opportunitiesByCountries.setUniqid(opportunities.getUniqid());
                opportunitiesByCountries.setOpportunity(opportunities.getOpportunity());
                opportunitiesByCountries.setActives(opportunities.getActives());
                opportunitiesByCountries.setPotentials(opportunities.getPotentials());

                opportunitiesByCountriesList.add(opportunitiesByCountries);
            }
        }
        logger.info("Map"+opportunitiesByCountriesList);
        return opportunitiesByCountriesList;
    }

}
