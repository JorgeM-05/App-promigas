//package com.promigasapp.apppromigas.services;
//
//import com.promigasapp.apppromigas.entity.CountryEntity;
//import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
////import com.promigasapp.apppromigas.repository.CountryRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.webjars.NotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CountryService {
//    Logger logger = LoggerFactory.getLogger(CountryService.class);
//
//    @Autowired
//    private CountryRepository countryRepository;
//
//    public CountryEntity getCountryEntity(String country)throws NotFoundException {
////        logger.info("::::" + country);
//        return countryRepository.findBypais(country);
//    }
//    public List<CountryEntity> getCountriesEntity(List<String> country)throws NotFoundException {
////        logger.info("::::" + country);
//        List<CountryEntity> countryEntities= new ArrayList<CountryEntity>();
//        for(String countries : country){
//            countryEntities.add(countryRepository.findBypais(countries));
//        }
//        return countryEntities;
//    }
//}
