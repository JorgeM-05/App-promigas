package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.FinancialFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunitiesByCountryDTO;
import com.promigasapp.apppromigas.dto.filterDTO.ParamFilterDTO;
import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.entity.SectorEntity;
import com.promigasapp.apppromigas.repository.*;
import com.promigasapp.apppromigas.utils.ValidateCountry;
import jdk.nashorn.internal.objects.annotations.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterOpportunitiesService {
    Logger logger = LoggerFactory.getLogger(FilterOpportunitiesService.class);

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private SectorRepository sectorRepository;
    @Autowired
    private OpportunitiesRepository opportunitiesRepository;
    @Autowired
    private FinancialFiguresRepository financialFiguresRepository;

    @Autowired
    private ExampleQuery exampleQuery;

    public ParamFilterDTO getDataFilter(List<String> countries, List<String> type_project,
                                                   List<String> sector, String options) {
        ParamFilterDTO paramFilterDTO = null;
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<OpportunitiesEntity>();
        List<FinancialFiguresEntity> figuresEntity = new ArrayList<FinancialFiguresEntity>();


        List<String> newCountries = ValidateCountry.loweCaseCountry(countries);
        List<String> newTypeProject = ValidateCountry.loweCaseTypeProject(type_project);

        logger.info("consultando informacion tabla pais");
        if( newCountries != null){
            if (newTypeProject!= null) {
                countryEntities = getCountries(newCountries,newTypeProject);
            }
            else {
                countryEntities = getByCountry(newCountries);
            }
        } else if (newTypeProject != null) {
                countryEntities = getCountriesByTypeProject(newTypeProject);
        }else {
                countryEntities = getCountriesAll();
        }

        logger.info("consultando informacion tabla oportunidades");

        opportunitiesEntities = getOpportunities(countryEntities,sector);
        logger.info("consultando informacion tabla financiera");

        if(opportunitiesEntities.size()>0) {
            figuresEntity = searchOpportunitiesByFinancial(options, opportunitiesEntities);
        }
        if(opportunitiesEntities.size()>0) {
            paramFilterDTO.setOpportunities(mapToOpportunitiesfilter(figuresEntity, opportunitiesEntities));
        }
        return paramFilterDTO;
    }

    public List<CountryEntity> getCountries(List<String> countries,List<String> typeProject){
        logger.info("consultando en BD por pais y tipo projecto");
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
        for (String pais : countries) {
            for (String type : typeProject) {
                CountryEntity country = countryRepository.findBypaisAndTipoProyecto(pais, type);
                if (country != null) {
                    countryEntities.add(country);
                }
            }
        }
        return countryEntities;
    }
    public List<CountryEntity> getCountriesByTypeProject(List<String> typeProject){
        logger.info("consultando en BD por tipo projecto");
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
        for (String type : typeProject) {
            CountryEntity country = countryRepository.findByTipoProyecto(type);
            if (country != null) countryEntities.add(country);
        }
        return countryEntities;
    }
    public List<CountryEntity> getByCountry(List<String> countries){
        logger.info("consultando en BD por pais");
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
        for (String pais : countries) {
            CountryEntity country = countryRepository.findBypais(pais);
            if (country != null) countryEntities.add(country);
        }
        return countryEntities;
    }
    public List<CountryEntity> getCountriesAll(){
        logger.info("consultando en BD ");
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();

        return countryRepository.findAll();
    }


    public List<OpportunitiesEntity> getOpportunities(List<CountryEntity> countriesEntities,List<String> sector){
        logger.info("buscando oportunidades por pais");
        List<OpportunitiesEntity> opportunitiesEntities = searchOpportunitiesByCountry(countriesEntities);

        List<OpportunitiesEntity> newOpportunitiesEntities = new ArrayList<OpportunitiesEntity>();

        if(opportunitiesEntities.size()>0) {
            if (sector.size()>0) { // si la data de sector llega vacia menos a cero, no hace el filtro por sector y salta
                logger.info("buscando oportunidaddes por sector");
                newOpportunitiesEntities = searchOpportunitiesBySector(sector, opportunitiesEntities);
            }else { newOpportunitiesEntities = opportunitiesEntities;} // por tanto asigna las oportunidades encontradas
        }
        return newOpportunitiesEntities;
    }
    //busqueda de oportunidades por pais
    public List<OpportunitiesEntity> searchOpportunitiesByCountry(List<CountryEntity> countriesEntities){
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<OpportunitiesEntity>();

        if(countriesEntities.size()>0) {
            for (CountryEntity pais : countriesEntities) { //recorremos toda la lista de paises encontrados
                opportunitiesEntities = opportunitiesRepository.findByIdpais(pais);
            }
        }
        return opportunitiesEntities;
    }
    //busqueda de oportunidades por sector
    public List<OpportunitiesEntity> searchOpportunitiesBySector(List<String> sectorEntities,
                                                                 List<OpportunitiesEntity> opportunitiesEntities){

        List<OpportunitiesEntity> opportunitiesEntityList = new ArrayList<OpportunitiesEntity>();

        if(opportunitiesEntities.size()>0) {
            for (OpportunitiesEntity opportunities : opportunitiesEntities) {
                for (String sector : sectorEntities) {
                    SectorEntity sectorEntity = sectorRepository.findByTipoSector(sector);
                    if (sectorEntity!=null){
//                        OpportunitiesEntity opp = opportunitiesRepository.findByIdAndIdSector(opportunities.getUnique_id(),sectorEntity);
                        OpportunitiesEntity opp = opportunitiesRepository.findById(1);

                        if(opp!= null) {
                            opportunitiesEntityList.add(opp);
                        }
                    }
                }
            }
        }
        return opportunitiesEntityList;
    }


    //buscando informacion por capex
    public List<FinancialFiguresEntity> searchOpportunitiesByFinancial(String options,
                                                                       List<OpportunitiesEntity> opportunitiesEntities){
        List<FinancialFiguresEntity> figuresEntity = new ArrayList<FinancialFiguresEntity>();

        switch (options) {
            case "optionOne":
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
//                    figuresEntity = financialFiguresRepository.findByCapexCifraBetweenAndopportunity(0, 10, opportunities);
                }
                break;
            case "optionTwo":
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
//                    figuresEntity = financialFiguresRepository.findByCapexCifraBetweenAndopportunity(10, 50, opportunities);
                }
                break;
            case "optionTree":
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
//                    figuresEntity = financialFiguresRepository.findByCapexCifraBetweenAndopportunity(50, 100,opportunities);
                }
                break;
            default:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    figuresEntity.add(financialFiguresRepository.findByopportunity(opportunities));
                }
        }
        return figuresEntity;
    }


    // Mapeando datos de la entidad a DTO
    public List<OpportunitiesByCountryDTO> mapToOpportunitiesfilter(List<FinancialFiguresEntity> financial,
                                                                    List<OpportunitiesEntity> opportunities) {
        List<OpportunitiesByCountryDTO> lisOppFilter = new ArrayList<OpportunitiesByCountryDTO>();

        if (financial.size() > 0 && opportunities.size() > 0) {
            for (FinancialFiguresEntity financials : financial) {
                for (OpportunitiesEntity opp : opportunities) {
                    OpportunitiesByCountryDTO opportunity = new OpportunitiesByCountryDTO();
                    FinancialFiguresDTO financialFiguresDTO = new FinancialFiguresDTO();

                    opportunity.setNameOportunity(opp.getName_opportunities());
                    opportunity.setCountry(opp.getIdpais().getPais());

                    financialFiguresDTO.setUnitCapex(financials.getCapex_unidades());
                    financialFiguresDTO.setValueCapex(financials.getCapexCifra());
                    financialFiguresDTO.setUnitEbitda(financials.getEbitda_unidades());
                    financialFiguresDTO.setValueEbitda(financials.getEbitda_cifra());
                    opportunity.setFinancialFiguresDTO(financialFiguresDTO);

                    lisOppFilter.add(opportunity);
                }
            }
        }

        return lisOppFilter;
    }
}
