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


    public ParamFilterDTO getDataFilter(List<String> countries, List<String> type_project,
                                                   List<String> sector, int options) {
        ParamFilterDTO paramFilterDTO = new ParamFilterDTO();
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<OpportunitiesEntity>();
        List<FinancialFiguresEntity> figuresEntity = new ArrayList<FinancialFiguresEntity>();


        //1 BUSCAMOS POR PAIS Y/O PROYECTO
        logger.info("consultando informacion tabla pais"+ countries);
        if( countries != null){
            if (type_project!= null) {
                countryEntities = getCountries(countries,type_project);
            }
            else {
                countryEntities = getByCountry(countries);
            }
        } else if (type_project != null) {
            countryEntities = getCountriesByTypeProject(type_project);
        }else {
            countryEntities = getCountriesAll();
        }
        logger.info("data encontrada :: "+countryEntities);


        logger.info("\n \n consultando informacion tabla oportunidades ::: "+sector );
        opportunitiesEntities = getOpportunities(countryEntities,sector);


        logger.info("consultando informacion tabla financiera");
        if(opportunitiesEntities.size()>0) {
            logger.info("entrando a consultar por capex  :: "+options+"---"+opportunitiesEntities);
            figuresEntity = searchOpportunitiesByFinancial(options, opportunitiesEntities);
        }
        logger.info("figure Entity :::"+figuresEntity);
        if(opportunitiesEntities.size()>0) {
            paramFilterDTO.setOpportunities(mapToOpportunitiesfilter(figuresEntity, opportunitiesEntities));
        }
        logger.info("tamaño :::: "+paramFilterDTO.getOpportunities().size());
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
        List<OpportunitiesEntity> opportunitiesEntities = searchOpportunitiesByCountry(countriesEntities);
        List<OpportunitiesEntity> newOpportunitiesEntities = new ArrayList<OpportunitiesEntity>();
        logger.info("validando si tiene datos ...."+opportunitiesEntities);

        if(opportunitiesEntities.size()>0) {

            if (sector.equals(null)) { // si la data de sector llega vacia, menor a cero, no hace el filtro por sector y salta
                newOpportunitiesEntities = searchOpportunitiesBySector(sector, opportunitiesEntities);
            }else {
                newOpportunitiesEntities = opportunitiesEntities;
            } // por tanto asigna las oportunidades encontradas
        }
        return newOpportunitiesEntities;
    }
    //busqueda de oportunidades por pais
    public List<OpportunitiesEntity> searchOpportunitiesByCountry(List<CountryEntity> countriesEntities){
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<OpportunitiesEntity>();

        if(countriesEntities.size()>0) {
            for (CountryEntity pais : countriesEntities) { //recorremos toda la lista de paises encontrados
                List<OpportunitiesEntity> oppor;
                oppor = opportunitiesRepository.findByIdpais(pais);
                if(oppor.size()>0){
                    for(OpportunitiesEntity listOport : oppor) {
                        opportunitiesEntities.add(listOport);
                    }
                }
            }
        }
        logger.info("**** >>> data paises"+opportunitiesEntities);
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
                        logger.info("buscannn..... Sector:: "+sectorEntity);
                        logger.info("buscannn..... opp:: "+opportunities);

                        OpportunitiesEntity opp =
//                                opportunitiesRepository.findByIdAndidSector(
//                                                                            1,
//                                                                            sectorEntity);
                        opportunitiesRepository.search(opportunities.getUnique_id(),sectorEntity);
                        logger.info("se encontro oportun por sector "+ opp);

                        if(opp!= null) {
                            opportunitiesEntityList.add(opp);
                        }
                    }
                }
            }
        }
        logger.info("Todas oport encontradas *** "+opportunitiesEntities.size()+"_______"+opportunitiesEntities);
        return opportunitiesEntityList;
    }


    //buscando informacion por capex
    public List<FinancialFiguresEntity> searchOpportunitiesByFinancial(int options,
                                                                       List<OpportunitiesEntity> opportunitiesEntities){
        List<FinancialFiguresEntity> figuresEntity = new ArrayList<>();
        logger.info("Estamos en search financial \n");
        FinancialFiguresEntity fg = new FinancialFiguresEntity();
//      validamos que la opciones esten dentro de los numero, sino le asignamos 0 para que consulte sin filtro
        if(options<0 || options>5){
            System.out.println("Invalido");
            options = 0;
        }
        switch (options) {
            case 1:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    fg = financialFiguresRepository.findByCapexCifraBetweenAndOpportunity(0, 10, opportunities);
                    if (fg != null){figuresEntity.add(fg);}
                    logger.info("financial :  \n"+figuresEntity);
                }
                break;
            case 2:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    fg = financialFiguresRepository.findByCapexCifraBetweenAndOpportunity(10, 50, opportunities);
                    if (fg != null){figuresEntity.add(fg);}
                    logger.info("financial :  \n"+figuresEntity);

                }
                break;
            case 3:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    fg = financialFiguresRepository.findByCapexCifraBetweenAndOpportunity(50, 100,opportunities);
                    if (fg != null){figuresEntity.add(fg);}
                    logger.info("financial :  \n"+figuresEntity);
                }
                break;
            case 4:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    fg = financialFiguresRepository.findByCapexCifraGreaterThanAndOpportunity(100,opportunities);
                    if (fg != null){figuresEntity.add(fg);}
                    logger.info("financial :  \n"+figuresEntity);
                }
                break;
            case 0:
                for (OpportunitiesEntity opportunities: opportunitiesEntities) {
                    System.out.println("case *"+opportunities);
                    logger.info("---->"+financialFiguresRepository.findByopportunity(opportunities));
                    if(fg!=null ){
                        figuresEntity.add(fg);
                    }
                    logger.info("financial :  \n"+figuresEntity);
                }
                break;

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
        for (OpportunitiesByCountryDTO fil: lisOppFilter) {
            logger.info("DTO ::: " + fil.getNameOportunity());
        }
        return lisOppFilter;
    }
}
