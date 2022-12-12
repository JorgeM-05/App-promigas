package com.promigasapp.apppromigas.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCountry {

    static Pattern patternCaracter = Pattern.compile("[^a-zA-ZñÑ]");

    //validamos que no contenga caracteres especiales
    //validamos que no venga vacio
    public static List<String> loweCaseCountry(List<String> countries){
        List<String> newCountries = null;
        if(countries.size()>0) {
            for (String country : countries) {
                Matcher matcher = patternCaracter.matcher(country);
                if (matcher.find() == true) {
                    newCountries.add(country.toLowerCase());
                }
            }
        }
        return newCountries;
    }
    public static List<String> loweCaseTypeProject(List<String> typeProject){
        List<String> newTypeProject = null;
        if(typeProject.size()>0) {
            for (String type : typeProject) {
                Matcher matcher = patternCaracter.matcher(type);
                if (matcher.find() == true) {
                    newTypeProject.add(type.toLowerCase());
                }
            }
        }
        return newTypeProject;
    }

}
