package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.services.ListOpportunitiesAllServices;
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
@RequestMapping("App-opportunities")
public class OpportunitiesController {
    Logger logger = LoggerFactory.getLogger(OpportunitiesController.class);

    @Autowired
    private OpportunitiesService opportunitiesService;
    @Autowired
    private OpportunitiesByCoutryService opportunitiesByCoutryService;

    @Autowired
    private ListOpportunitiesAllServices listOpportunitiesAllServices;

    @GetMapping("/listOpportunities")
    public ResponseEntity<OpportunitiesDto> listOpportunities(){
        OpportunitiesDto opportunitiesDto = opportunitiesService.getDataOpportunities();

        ResponseEntity<OpportunitiesDto> responseEntity
                = new ResponseEntity<OpportunitiesDto>(opportunitiesDto, HttpStatus.OK);
        return responseEntity;
    }

    // lista todas las oportunidades referentes a un pais
    @GetMapping("/listAllOpp/{country}")
    public ResponseEntity<OpportunitiesAllByCountryDto> listNameCountry(@RequestParam String country){
        OpportunitiesAllByCountryDto opp = listOpportunitiesAllServices.getDataAllOpportunities(country);
        ResponseEntity<OpportunitiesAllByCountryDto> responseEntity
                = new ResponseEntity<OpportunitiesAllByCountryDto>(opp, HttpStatus.OK);
        return responseEntity;
    }

    // lista el detalle de la oportunidad
    @GetMapping("/list/{country}")
    public ResponseEntity<OpportunitiesCountryDto> listCountry(@RequestParam String country){
        OpportunitiesCountryDto opportunities = opportunitiesByCoutryService.getDataOpprt(country);
        System.out.println("****"+opportunities);
        ResponseEntity<OpportunitiesCountryDto> responseEntity
                = new ResponseEntity<OpportunitiesCountryDto>(opportunities, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("/filter/{contry}")
    public ResponseEntity<ParamFilter> filterContry(@RequestParam String contry, @RequestParam int capex)throws NotFoundException, ParseException, IOException {
        ParamFilter paramFilter = new ParamFilter();
        paramFilter.setCapex(capex);
        paramFilter.setPais(contry);
        return ResponseEntity.status(HttpStatus.FOUND).body(paramFilter);
    }
}
