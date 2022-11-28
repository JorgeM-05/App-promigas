package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dto.OpportunitiesByCountry;
import com.promigasapp.apppromigas.dto.OpportunitiesCountryDto;
import com.promigasapp.apppromigas.dto.OpportunitiesDto;
import com.promigasapp.apppromigas.dto.ParamFilter;
import com.promigasapp.apppromigas.services.OpportunitiesByCoutryService;
import com.promigasapp.apppromigas.services.OpportunitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.text.ParseException;

@RestController()
@RequestMapping("opportunities")
public class OpportunitiesController {
    Logger logger = LoggerFactory.getLogger(OpportunitiesController.class);

    @Autowired
    private OpportunitiesService opportunitiesService;
    @Autowired
    private OpportunitiesByCoutryService opportunitiesByCoutryService;

    @GetMapping()
    public ResponseEntity<OpportunitiesDto> listOpportunities(){
        OpportunitiesDto opportunitiesDto = opportunitiesService.getDataOpportunities();
        logger.info(String.valueOf(opportunitiesDto));
        ResponseEntity<OpportunitiesDto> responseEntity
                = new ResponseEntity<OpportunitiesDto>(opportunitiesDto, HttpStatus.OK);
        return responseEntity;
    }



    @GetMapping("/list/{country}")
    public ResponseEntity<OpportunitiesCountryDto> listContry(@RequestParam String country){
        OpportunitiesCountryDto opportunities = opportunitiesByCoutryService.getDataOpprt(country);
        System.out.println("****"+opportunities);
        ResponseEntity<OpportunitiesCountryDto> responseEntity
                = new ResponseEntity<OpportunitiesCountryDto>(opportunities, HttpStatus.OK);
        return responseEntity;
//        return ResponseEntity.ok().body("Estamos filtro de busqueda por paises :: ");
    }

    @GetMapping("/filter/{contry}")
    public ResponseEntity<ParamFilter> filterContry(@RequestParam String contry, @RequestParam int capex)throws NotFoundException, ParseException, IOException {
        ParamFilter paramFilter = new ParamFilter();
        paramFilter.setCapex(capex);
        paramFilter.setPais(contry);
        return ResponseEntity.status(HttpStatus.FOUND).body(paramFilter);
    }
}
