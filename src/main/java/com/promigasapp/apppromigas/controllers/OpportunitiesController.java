package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dto.*;
import com.promigasapp.apppromigas.dto.opporunitiesDTO.OpportunitiesDto;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigasapp.apppromigas.dto.filterDTO.ParamFilterDTO;
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
        logger.info("Get para listar oportunidades ");
        ResponseEntity<OpportunitiesDto> responseEntity = null;
        try {
            OpportunitiesDto opportunitiesDto = opportunitiesService.getDataAllOpportunities();
            if(opportunitiesDto != null){
                logger.info("get list successfully :: " + opportunitiesDto );
                responseEntity = new ResponseEntity<OpportunitiesDto>(opportunitiesDto, HttpStatus.OK);
            }
            else {
                logger.info("get list Null ");
                return responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            logger.error("Error internal service consulting opportunities");
            return responseEntity = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }




    // lista todas las oportunidades referentes a un pais
    @GetMapping("/list-all-opp/{country}")
    public ResponseEntity<OpportunitiesAllByCountryDto> listNameCountry(@RequestParam String countries){
        logger.info("Get para listar oportunidades por pais");
        ResponseEntity<OpportunitiesAllByCountryDto> responseEntity = null;
        try {
            OpportunitiesAllByCountryDto opportunities = listOpportunitiesAllServices.getDataOpportunities(countries);
            if(opportunities != null){
                responseEntity = new ResponseEntity<OpportunitiesAllByCountryDto>(opportunities, HttpStatus.OK);
            }else {
                logger.info("get list Null ");
                return responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            logger.error("Error internal service consulting opportunities");
            return responseEntity = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }




    // lista el detalle de la oportunidad
    @GetMapping("/details-opportunities/{id-opportunity}")
    public ResponseEntity<OpportunityDetailsDTO> listCountry(@RequestParam int id)throws NotFoundException{
        logger.info("Get para listar detalles de una oportunidad");
        ResponseEntity<OpportunityDetailsDTO> responseEntity = null;
        try {
            OpportunityDetailsDTO opportunityDetailsDTO = opportunitiesByCoutryService.getDataOpprt(id);
            if (opportunityDetailsDTO != null){
                responseEntity = new ResponseEntity<OpportunityDetailsDTO>(opportunityDetailsDTO, HttpStatus.OK);
            }else {
                logger.info("get list Null ");
                return responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            logger.error("Error internal service consulting opportunities");
            return responseEntity = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/filter")
    public ResponseEntity<ParamFilterDTO> filterContry(@RequestParam(required = false) List<String> countries,
                                                       @RequestParam(required = false) List<String> tipo_proyecto,
                                                       @RequestParam(required = false, defaultValue = "null") List<String> sector,
                                                       @RequestParam int options)
                                                        throws NotFoundException{
        logger.info("Get para filtrar informacion");
        ResponseEntity<ParamFilterDTO> responseEntity = null;
        try {
            ParamFilterDTO paramFilter = filterOpportunitiesService.getDataFilter(countries,tipo_proyecto,sector,options);
            if (paramFilter!= null){
                responseEntity  = new ResponseEntity<ParamFilterDTO>(paramFilter, HttpStatus.OK);

            }else {
                logger.info("get list Null ");
                return responseEntity = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            logger.error("Error internal service consulting filter opportunities");
            return responseEntity = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
