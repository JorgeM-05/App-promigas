package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.ListOportunitiesByCountry;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.FinancialFiguresDTO;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.OpportunitiesByCountryDTO;
import com.promigasapp.apppromigas.dto.filter.ParamFilterDTO;
import com.promigasapp.apppromigas.entity.CountryEntity;
import com.promigasapp.apppromigas.entity.FinancialFiguresEntity;
import com.promigasapp.apppromigas.entity.OpportunitiesEntity;
import com.promigasapp.apppromigas.entity.SectorEntity;
import com.promigasapp.apppromigas.repository.*;
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
                                                   List<String> sector, String options) {
        ParamFilterDTO paramFilterDTO = new ParamFilterDTO();
        List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();

        for (String pais : countries) {
            for (String type : type_project) {
                CountryEntity country = countryRepository.findBypaisAndTipoProyecto(pais, type);

                if (country != null) {
                    countryEntities.add(country);
                }
            }
        }
        List<SectorEntity> sectorEntities = null;
        if(countryEntities.size()>0) {
            for (CountryEntity pais : countryEntities) {
                List<OpportunitiesEntity> opportunities = opportunitiesRepository.findByIdpais(pais);
                sectorEntities = new ArrayList<SectorEntity>();
                if(opportunities.size()>0) {
                    for (OpportunitiesEntity opp : opportunities) {
//                System.out.println("numero de opor antes:: "+opportunities.size());
                        for (String sect : sector) {

                            SectorEntity sectorEntity = sectorRepository.findByopportunityAndTipoSector(opp, sect);
                            if (sectorEntity != null) {
                                sectorEntities.add(sectorEntity);
                            }
                        }
                    }
                }

            }
        }
        List<OpportunitiesEntity> newOpportunitiesEntities = new ArrayList<OpportunitiesEntity>();

        if(sectorEntities.size()>0) {
            for (SectorEntity sect : sectorEntities) {

                newOpportunitiesEntities.add(sect.getOpportunity());
            }
        }
        List<FinancialFiguresEntity> figuresEntity = new ArrayList<FinancialFiguresEntity>();
        switch (options) {
            case "optionOne":
                figuresEntity = financialFiguresRepository.findByCapexCifraBetween(0, 10);
                break;
            case "optionTwo":
                figuresEntity = financialFiguresRepository.findByCapexCifraBetween(10, 50);
                break;
            case "optionTree":
                figuresEntity = financialFiguresRepository.findByCapexCifraBetween(50, 100);
                break;
            default:
                figuresEntity = financialFiguresRepository.findByCapexCifraBetween(0, 1000);

        }

        paramFilterDTO.setOpportunities(mapToOpportunitiesfilter(figuresEntity, newOpportunitiesEntities));
        return paramFilterDTO;

    }

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
