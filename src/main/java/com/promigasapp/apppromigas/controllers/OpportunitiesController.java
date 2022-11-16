package com.promigasapp.apppromigas.controllers;

import com.promigasapp.apppromigas.dtos.ParamFilter;
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
//    @Autowired
//    private ParamFilter paramFilter;

    @GetMapping
    public ResponseEntity<String> listOpportunities(){
        String out = "estamos en rest lis oportunidades";
        return ResponseEntity.ok().body(out);
    }

    @GetMapping("/list/{contry}")
    public ResponseEntity<?> listContry(@RequestParam String contry){

        return ResponseEntity.ok().body("Estamos filtro de busqueda por paises :: "+contry);
    }

    @GetMapping("/filter/{contry}")
    public ResponseEntity<ParamFilter> filterContry(@RequestParam String contry, @RequestParam int capex)throws NotFoundException, ParseException, IOException {
        ParamFilter paramFilter = new ParamFilter();
        paramFilter.setCapex(capex);
        paramFilter.setPais(contry);
        return ResponseEntity.status(HttpStatus.FOUND).body(paramFilter);
    }
}
