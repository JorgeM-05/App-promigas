package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunitiesByCountryDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigasapp.apppromigas.dto.filter.ParamFilterDTO;
import com.promigasapp.apppromigas.services.FilterOpportunitiesService;
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
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("app-opportunities")
public class OpportunitiesController {
    Logger logger = LoggerFactory.getLogger(OpportunitiesController.class);
    @Autowired
    private OpportunitiesService opportunitiesService;
    @Autowired
    private OpportunitiesByCoutryService opportunitiesByCoutryService;
    @Autowired
    private ListOpportunitiesAllServices listOpportunitiesAllServices;
    @Autowired
    private FilterOpportunitiesService filterOpportunitiesService;

    //lista de las oportunidades
    @GetMapping("/list-opportunities")
    public ResponseEntity<OpportunitiesDto> listOpportunities(){
        OpportunitiesDto opportunitiesDto = opportunitiesService.getDataAllOpportunities();

        ResponseEntity<OpportunitiesDto> responseEntity
                = new ResponseEntity<OpportunitiesDto>(opportunitiesDto, HttpStatus.OK);
        return responseEntity;
    }

    // lista todas las oportunidades referentes a un pais
    @GetMapping("/list-all-opp/{country}")
    public ResponseEntity<OpportunitiesAllByCountryDto> listNameCountry(@RequestParam String countries){
        OpportunitiesAllByCountryDto opp = listOpportunitiesAllServices.getDataOpportunities(countries);
        ResponseEntity<OpportunitiesAllByCountryDto> responseEntity
                = new ResponseEntity<OpportunitiesAllByCountryDto>(opp, HttpStatus.OK);
        return responseEntity;
    }

    // lista el detalle de la oportunidad
    @GetMapping("/list/{id-opportunity}")
    public ResponseEntity<OpportunityDetailsDTO> listCountry(@RequestParam int id)throws NotFoundException{
        OpportunityDetailsDTO opportunityDetailsDTO = opportunitiesByCoutryService.getDataOpprt(id);
//        System.out.println("****"+opportunities);
        ResponseEntity<OpportunityDetailsDTO> responseEntity
                = new ResponseEntity<OpportunityDetailsDTO>(opportunityDetailsDTO, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("/filter")
    public ResponseEntity<ParamFilterDTO> filterContry(@RequestParam List<String> countries,
                                                       @RequestParam List<String> tipo_proyecto,
                                                       @RequestParam List<String> sector,
                                                       @RequestParam String options)
                                                        throws NotFoundException, ParseException, IOException {
        ParamFilterDTO paramFilter = filterOpportunitiesService.getDataFilter(countries,tipo_proyecto,sector,options);
        ResponseEntity<ParamFilterDTO> responseEntity = null;
        if(paramFilter != null){
           responseEntity  = new ResponseEntity<ParamFilterDTO>(paramFilter, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<ParamFilterDTO>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }


}
