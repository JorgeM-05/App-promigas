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



    public OpportunitiesDto getDataAllOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();

        opportunitiesEntity = getOpportunitiesEntity();
        countryEntities = getCountryEntity();
        opportunitiesDto.setNumberOpportunity(opportunitiesEntity.size());
//        opportunitiesDto.setGreenfield(opportunitiesEntity.);

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



        if(countryEntities.size()>0 && opportunitiesEntityList.size()>0){
            OpportunitiesAll opportunitiesAll = new OpportunitiesAll();
            for(CountryEntity country : countryEntities){
                System.out.println(opportunitiesAllRepository.findById_pais(country.getUnique_id()));
//                System.out.println(country.getUnique_id());
                int band=0;
                int NumOpportunities = 0;
                band = country.getUnique_id();

//                for(OpportunitiesEntity oppor : opportunitiesEntityList){
//                    if(country.getUnique_id() == oppor.getIdpais().getUnique_id()){
//                        System.out.println(":::: "+country.getUnique_id() +"=="+ oppor.getIdpais().getUnique_id());
//                        System.out.println("****** "+oppor);
//                        NumOpportunities += countOportunities(oppor,country.getUnique_id());
//                        opportunitiesAll.setNumberOpportunity(NumOpportunities);
//                        opportunitiesAll.setCountry(country.getPais());
//
//                        opportunitiesAlls.add(opportunitiesAll);
//                    }
//
//                }
            }
        }

        return opportunitiesAlls;
    }

    public int countOportunities(OpportunitiesEntity oppor,int id){
//        System.out.println("--_>"+oppor);
        int count=0;
        if(oppor.getIdpais().getUnique_id() == id){
            count++;
        }
//        System.out.println(count);
        return count;
    }

}
