package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.opporunitiesDTO.OpportunitiesAll;
import com.promigasapp.apppromigas.dto.opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.repository.CountryRepository;
import com.promigasapp.apppromigas.repository.OpportunitiesRepository;
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
    private OpportunitiesRepository opportunitiesAllRepository;
    @Autowired
    private CountryRepository countryRepository;



    public OpportunitiesDto getDataAllOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();

        opportunitiesEntity = getOpportunitiesEntity();
        countryEntities = getCountryEntity();
        opportunitiesDto.setNumberOpportunities(opportunitiesEntity.size());
        opportunitiesDto.setGreenfield(countGreen(opportunitiesEntity));
        opportunitiesDto.setMya(countMYA(opportunitiesEntity));

        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(opportunitiesEntity,countryEntities));
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
        List<OpportunitiesAll> opportunitiesAlls= new ArrayList<OpportunitiesAll>();
        int NumOpportunities,ctn=0;
        for(CountryEntity country : countryEntities){
            for(OpportunitiesEntity oppor : opportunitiesEntityList) {
                OpportunitiesAll opportunitiesAll = new OpportunitiesAll();
                if(country.getUnique_id() == oppor.getIdpais().getUnique_id()){
                    ctn++;
                    NumOpportunities = countOportunities(opportunitiesEntityList,country.getUnique_id());

                    opportunitiesAll.setNumberOpportunity(NumOpportunities);
                    opportunitiesAll.setCountry(oppor.getIdpais().getPais());
                    opportunitiesAll.setCoordinates(oppor.getCoordinates());
                    opportunitiesAll.setUniqid(oppor.getIdpais().getUnique_id());
                    if(NumOpportunities == ctn){
                        opportunitiesAlls.add(opportunitiesAll);
                    }
                }
                else {
                    NumOpportunities =0;
                    ctn =0;
                }
            }
        }
        for(OpportunitiesAll opp: opportunitiesAlls){
            logger.info("---> "+opp.getCountry());
        }
        return opportunitiesAlls;
    }

    public int countOportunities(List<OpportunitiesEntity> oppor,int id){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if (op.getIdpais().getUnique_id() == id) {
                count++;
            }
        }
        return count;
    }

    public int countGreen(List<OpportunitiesEntity> oppor){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if(op.getGreenfield()!= null) {
                count++;
            }
        }
        System.out.println("greenn...."+count);
        return count;
    }
    public int countMYA(List<OpportunitiesEntity> oppor){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if(op.getMYA()!= null) {
                count++;
            }
        }
        System.out.println("MYA...."+count);
        return count;
    }

}
