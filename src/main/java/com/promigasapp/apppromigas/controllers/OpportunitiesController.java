package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.dto.all_opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
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
@RequestMapping("app-opportunities")
public class OpportunitiesController {
    Logger logger = LoggerFactory.getLogger(OpportunitiesController.class);
    @Autowired
    private OpportunitiesService opportunitiesService;
    @Autowired
    private OpportunitiesByCoutryService opportunitiesByCoutryService;

    @Autowired
    private ListOpportunitiesAllServices listOpportunitiesAllServices;
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
    public ResponseEntity<OpportunitiesAllByCountryDto> listNameCountry(@RequestParam String country){
        OpportunitiesAllByCountryDto opp = listOpportunitiesAllServices.getDataOpportunities(country);
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

    @GetMapping("/filter/{contry}")
    public ResponseEntity<ParamFilter> filterContry(@RequestParam String contry, @RequestParam int capex)
                                                        throws NotFoundException, ParseException, IOException {
        ParamFilter paramFilter = new ParamFilter();
        paramFilter.setCapex(capex);
        paramFilter.setPais(contry);
        return ResponseEntity.status(HttpStatus.FOUND).body(paramFilter);
    }

}
