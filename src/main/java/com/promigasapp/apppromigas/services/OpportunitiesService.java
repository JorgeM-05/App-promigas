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

    public OpportunitiesDto getDataAllOpportunities(){
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();

        opportunitiesEntity = getOpportunitiesEntity();// traer de bd oportunidades

        opportunitiesDto.setNumberOpportunities(opportunitiesEntity.size());
        opportunitiesDto.setNumberGreenfield(countGreen(opportunitiesEntity));
        opportunitiesDto.setNumberMYA(countMYA(opportunitiesEntity));

        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(opportunitiesEntity));
        return opportunitiesDto;
    }

    // consultando en Base datos
    public List<OpportunitiesEntity> getOpportunitiesEntity(){
        return opportunitiesAllRepository.findAll();
    }


    // Mapeando datos de BD a Json out ---
    public List<OpportunitiesAll> mapToOpportunitiesDTO(
                                List<OpportunitiesEntity> opportunitiesEntityList)
    {
        List<OpportunitiesAll> opportunitiesAlls= new ArrayList<OpportunitiesAll>();
        List<Integer> id = new ArrayList<>();
        int NumOpportunities = 0;
        for(OpportunitiesEntity oppor : opportunitiesEntityList) {
            if(oppor != null){
                OpportunitiesAll opportunitiesAll = new OpportunitiesAll();
                if(id.indexOf(oppor.getIdCountry().getUnique_id()) < 0){
                    NumOpportunities = countOportunities(opportunitiesEntityList,oppor.getIdCountry().getUnique_id());

                    opportunitiesAll.setNumberOpportunity(NumOpportunities);
                    opportunitiesAll.setCountry(oppor.getIdCountry().getNameContry());
                    opportunitiesAll.setCoordinates(oppor.getCoordinates());

                    opportunitiesAlls.add(opportunitiesAll);
                    id.add(oppor.getIdCountry().getUnique_id());
                }
            }
        }
        return opportunitiesAlls;
    }

    public int countOportunities(List<OpportunitiesEntity> oppor,int id){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if (op.getIdCountry().getUnique_id() == id) {
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
        return count;
    }
    public int countMYA(List<OpportunitiesEntity> oppor){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if(op.getMYA()!= null) {
                count++;
            }
        }
        return count;
    }

}
