package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.ListOportunitiesByCountry;
import com.promigasapp.apppromigas.dto.OpportunitiesAllByCountryDto;
import com.promigasapp.apppromigas.entity.ListOpportunitiesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOpportunitiesAllServices {
    public OpportunitiesAllByCountryDto getDataAllOpportunities(String country){
        OpportunitiesAllByCountryDto opp = new OpportunitiesAllByCountryDto();
        opp.setListOportunitiesByCountries(mapToOpportunitiesAllDto(getAllOpportunities(country)));

        return opp;
    }

    public List<String> getAllOpportunities(String country){
        ListOpportunitiesEntity listOpportunitiesEntity = new ListOpportunitiesEntity();
        ArrayList<String> array2 = new ArrayList<>();

        for(int i=0; i<=10; i++){
            String aux = "Oportunidad "+i;
            listOpportunitiesEntity.setNameOportunity(aux);
            array2.add(aux);
            System.out.println(array2);
        }

            System.out.println(array2.get(0));

        return array2;
    }

    public List<ListOportunitiesByCountry> mapToOpportunitiesAllDto(List<String> opportunitiesEntities){

        List<ListOportunitiesByCountry> listOportunitiesByCountries =  new ArrayList<ListOportunitiesByCountry>();

        if(opportunitiesEntities.size()>0){
            for(String list : opportunitiesEntities){
                ListOportunitiesByCountry listOpp = new ListOportunitiesByCountry();
//                System.out.println(list);

                listOpp.setNameOportunity(list);
                listOportunitiesByCountries.add(listOpp);
            }
        }
        return listOportunitiesByCountries;
    }
}
