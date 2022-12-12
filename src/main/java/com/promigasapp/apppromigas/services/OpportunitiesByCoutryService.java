package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.*;
import com.promigasapp.apppromigas.entity.*;
import com.promigasapp.apppromigas.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunitiesByCoutryService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesByCoutryService.class);
    @Autowired
    private FinancialFiguresRepository financialFiguresRepository;
    @Autowired
    private OperatingFiguresRepository operatingFiguresRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private OpportunitiesRepository allRepository;

    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {
        logger.info("estramos a consultar a la bd");
        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();

        OpportunitiesEntity opportunities = allRepository.findById(id_opportunity);



        FinancialFiguresEntity financialFiguresEntities = financialFiguresRepository.findByopportunity(opportunities);
        OperatingFiguresEntity operatingFiguresEntities = operatingFiguresRepository.findByopportunity(opportunities);
        SectorEntity sectorEntity = sectorRepository.findByopportunity(opportunities);
        //aqui esta mal toca consultar el sector y despues compararlo y buscarlo con la oportunidad



        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(
                    mapToAll(mapTodetailFinancial(financialFiguresEntities),
                            mapTodetailopertting(operatingFiguresEntities),
                            mapTodetailSector(sectorEntity),
                            mapTodetailOpportunity(opportunities)));
        return opportunitiesdetailDetailsDTO;
    }

    public FinancialFiguresDTO mapTodetailFinancial(FinancialFiguresEntity financialEtity){
        FinancialFiguresDTO financialFiguresDTO = new FinancialFiguresDTO();

//        if(financialEtity.size()>0){
//            for(FinancialFiguresEntity figuresEntity : financialEtity){
////                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();
//                logger.info("Capex unidad:::"+ figuresEntity.getCapex_unidades());
//                logger.info("Capex cifra::: "+figuresEntity.getCapex_cifra());
//                financialFiguresDTO.setUnitCapex(figuresEntity.getCapex_unidades());
//                financialFiguresDTO.setValueCapex(figuresEntity.getCapex_cifra());
//                financialFiguresDTO.setUnitEbitda(figuresEntity.getEbitda_unidades());
//                financialFiguresDTO.setValueEbitda(figuresEntity.getEbitda_cifra());
//                financialFiguresDTO.setUnitIncome(figuresEntity.getIngresos_unidades());
//                financialFiguresDTO.setValueIncome(figuresEntity.getIngresos_cifra());
//            }
//        }
        if(financialEtity != null) {
            financialFiguresDTO.setUnitCapex(financialEtity.getCapex_unidades());
            financialFiguresDTO.setValueCapex(financialEtity.getCapexCifra());
            financialFiguresDTO.setUnitEbitda(financialEtity.getEbitda_unidades());
            financialFiguresDTO.setValueEbitda(financialEtity.getEbitda_cifra());
            financialFiguresDTO.setUnitIncome(financialEtity.getIngresos_unidades());
            financialFiguresDTO.setValueIncome(financialEtity.getIngresos_cifra());
        }

        return financialFiguresDTO;
    }

    public OperatingFiguresDTO mapTodetailopertting(OperatingFiguresEntity financialEtity){
        OperatingFiguresDTO operatingFiguresDTO = new OperatingFiguresDTO();

        if(financialEtity != null){
            operatingFiguresDTO.setSol_energ_potencia_unid(financialEtity.getSol_energ_potencia_unid());
            operatingFiguresDTO.setSol_energ_potencia_cifra(financialEtity.getSol_energ_potencia_cifra());
            operatingFiguresDTO.setSol_energ_gener_unid(financialEtity.getSol_energ_gener_unid());
            operatingFiguresDTO.setSol_energ_gener_cifra(financialEtity.getSol_energ_gener_cifra());
            operatingFiguresDTO.setSol_energ_degrada_prom(financialEtity.getSol_energ_degrada_prom());
            operatingFiguresDTO.setSol_energ_hora_sol(financialEtity.getSol_energ_hora_sol());
            operatingFiguresDTO.setTrans_cap_max(financialEtity.getTrans_cap_max());
            operatingFiguresDTO.setTrans_vol_Trans(financialEtity.getTrans_vol_Trans());
            operatingFiguresDTO.setTrans_int_gasod(financialEtity.getTrans_int_gasod());
            operatingFiguresDTO.setDistr_volumen(financialEtity.getDistr_volumen());
            operatingFiguresDTO.setDistr_conex_periodo(financialEtity.getDistr_conex_periodo());
            operatingFiguresDTO.setDistr_kms_Red(financialEtity.getDistr_kms_Red());
            operatingFiguresDTO.setDistr_penetracion(financialEtity.getDistr_penetracion());

        }
        return operatingFiguresDTO;
    }

    public SectorDetailsDTO mapTodetailSector(SectorEntity sectorEntity){
        SectorDetailsDTO sectorDetailsDTO = new SectorDetailsDTO();

        if(sectorEntity != null) {
            sectorDetailsDTO.setTipo_sector(sectorEntity.getTipoSector());
        }
        return sectorDetailsDTO;
    }

    public OpportunitiesByCountryDTO mapTodetailOpportunity(OpportunitiesEntity opportunities){
        OpportunitiesByCountryDTO opportunitiesByCountryDTO = new OpportunitiesByCountryDTO();

        if(opportunities != null) {
            System.out.println("nombre ---> "+opportunities.getName_opportunities());
            opportunitiesByCountryDTO.setNameOportunity(opportunities.getName_opportunities());
            opportunitiesByCountryDTO.setCountry(opportunities.getIdpais().getPais());
            opportunitiesByCountryDTO.setLastUpdateDate(opportunities.getIdpais().getFecha_actualizacion());
            opportunitiesByCountryDTO.setDescription("descripcion....");

        }
        return opportunitiesByCountryDTO;
    }

    public OpportunitiesByCountryDTO mapToAll(FinancialFiguresDTO financialFiguresDTO,
                                              OperatingFiguresDTO operatingFiguresDTO,
                                              SectorDetailsDTO sector,
                                              OpportunitiesByCountryDTO opp
    ){
        OpportunitiesByCountryDTO opportunities = new OpportunitiesByCountryDTO();
        opportunities.setNameOportunity(opp.getNameOportunity());
        opportunities.setCountry(opp.getCountry());
        opportunities.setLastUpdateDate(opp.getLastUpdateDate());
        opportunities.setDescription(opp.getDescription());
        opportunities.setFinancialFiguresDTO(financialFiguresDTO);
        opportunities.setOperatingFiguresDTO(operatingFiguresDTO);
        opportunities.setSector(sector.getTipo_sector());

        return opportunities;
    }
}

