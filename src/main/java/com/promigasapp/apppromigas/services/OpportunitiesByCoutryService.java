package com.promigasapp.apppromigas.services;

import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.*;
import com.promigasapp.apppromigas.dto.detailOpportunitiesDTO.financial.*;
import com.promigasapp.apppromigas.entity.*;
import com.promigasapp.apppromigas.entity.FiguresFinancial.*;
import com.promigasapp.apppromigas.repository.*;
import com.promigasapp.apppromigas.repository.figures.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunitiesByCoutryService {
    Logger logger = LoggerFactory.getLogger(OpportunitiesByCoutryService.class);

//    @Autowired
//    private SectorRepository sectorRepository;

    @Autowired
    private OpportunitiesRepository allRepository;
    @Autowired
    private CapexRepository capexRepository;
    @Autowired
    private EbitdaRepository ebitdaRepository;
    @Autowired
    private DividensRepository dividensRepository;
    @Autowired
    private FclRepository fclRepository;
    @Autowired
    private FclShareholderRepository fclSh;
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private TarifRepository tarifRepository;
    @Autowired
    private TirEquityRepository tirEquityRepository;
    @Autowired
    private TirProjectRepository tirProjectRepository;
    @Autowired
    private UtilityRepository utilityRepository;



    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {
        logger.info("estramos a consultar a la bd");
        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();

        OpportunitiesEntity opportunities = allRepository.findById(id_opportunity);
        logger.info("list oportunities:: \n"+opportunities);

        List<CapexEntity> capexEntity = capexRepository.findByIdOpportunity(opportunities);
        List<DividensEntity> dividensRepositories = dividensRepository.findByIdOpportunity(opportunities);
        List<EbitdaEntity> ebitdaEntity = ebitdaRepository.findByIdOpportunity(opportunities);
        List<FclEntity> fclEntities = fclRepository.findByIdOpportunity(opportunities);
        List<FclShareholderEntity> fclShareholder = fclSh.findByIdOpportunity(opportunities);
        List<IncomeEntity> incomeEntities = incomeRepository.findByIdOpportunity(opportunities);
        List<TarifEntity> tarifEntities = tarifRepository.findByIdOpportunity(opportunities);
        List<TirEquityEntity> tirEquityEntities = tirEquityRepository.findByIdOpportunity(opportunities);
        List<TirProjectEntity> tirProjectEntities = tirProjectRepository.findByIdOpportunity(opportunities);
        List<UtilityEntity> utilityEntities = utilityRepository.findByIdOpportunity(opportunities);
        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(mapToAll(capexEntity,dividensRepositories,ebitdaEntity,fclEntities,fclShareholder,incomeEntities,
                tarifEntities,tirEquityEntities,tirProjectEntities,utilityEntities));

//        FinancialFiguresEntity financialFiguresEntities = financialFiguresRepository.findByopportunity(opportunities);
//        OperatingFiguresEntity operatingFiguresEntities = operatingFiguresRepository.findByopportunity(opportunities);

//        SectorEntity sectorEntity = sectorRepository.findById(opportunities.getIdSector().getUnique_id());
//
//        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(
//                    mapToAll(mapTodetailFinancial(financialFiguresEntities),
//                            mapTodetailopertting(operatingFiguresEntities),
//                            mapTodetailSector(sectorEntity),
//                            mapTodetailOpportunity(opportunities)));
        return opportunitiesdetailDetailsDTO;
    }
/*
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
    }*/

    public OpportunitiesByCountryDTO mapToAll(List<CapexEntity> capexEntity,List<DividensEntity> dividensEntities,
                                              List<EbitdaEntity> ebitdaEntity,List<FclEntity> fclEntities,
                                              List<FclShareholderEntity> fclShareholderEntities,
                                              List<IncomeEntity> incomeEntities, List<TarifEntity> tarifEntities,
                                              List<TirEquityEntity> tirEquityEntities, List<TirProjectEntity> tirProjectEntities,
                                              List<UtilityEntity> utilityEntities){

        OpportunitiesByCountryDTO opportunities = new OpportunitiesByCountryDTO();
        List<String> usd = new ArrayList<>();
        List<String> cop = new ArrayList<>();

        boolean var =true;

        CapexDTO capexDTO = new CapexDTO();
        DividensDTO dividensDTO = new DividensDTO();
        EbitdaDTO ebitdaDTO = new EbitdaDTO();
        FclDTO fclDTO = new FclDTO();
        FclShareHolderDTO fclShareDTO = new FclShareHolderDTO();
        IncomeDTO incomeDTO = new IncomeDTO();
        TarifDTO tarifDTO = new TarifDTO();
        TirEquityDTO tirEquityDTO = new TirEquityDTO();


        for(CapexEntity capex: capexEntity){
//            if(var == true) {
//                capexDTO.setYear(capex.getYear());
//                capexDTO.setCapexUsd(capex.getCapexUsd());
//                capexDTO.setCapexCop(capex.getCapexCop());
//                var = false;
//            }
            usd.add(capex.getValueCapexUsd());
            cop.add(capex.getValueCapexCop());
            capexDTO.setValueCapexUsd(usd);
            capexDTO.setValueCapexCop(cop);
        }
        opportunities.setCapexDTO(capexDTO);

        for(EbitdaEntity ebitda: ebitdaEntity){
            usd.add(ebitda.getValueEbitdaUsd());
            cop.add(ebitda.getValueEbitdaCop());
            ebitdaDTO.setValueEbitdaUsd(usd);
            ebitdaDTO.setValueEbitdaCop(cop);
        }
        opportunities.setEbitdaDTO(ebitdaDTO);

        for(DividensEntity div: dividensEntities){
            usd.add(div.getValuedividensUsd());
            cop.add(div.getDividensCop());
            dividensDTO.setValuedividensUsd(usd);
            dividensDTO.setValueDividensCop(cop);
        }
        opportunities.setDividensDTO(dividensDTO);

        for(FclEntity fcl: fclEntities){
            usd.add(fcl.getFclUsd());
            cop.add(fcl.getFclCop());
            fclDTO.setValueFclUsd(usd);
            fclDTO.setValueFclCop(cop);
        }
        opportunities.setFclDTO(fclDTO);

        for(FclShareholderEntity fclShare: fclShareholderEntities){
            usd.add(fclShare.getShareholderUsd());
            cop.add(fclShare.getShareholderCop());
            fclShareDTO.setValueShareUsd(usd);
            fclShareDTO.setValueShareCop(cop);
        }
        opportunities.setFclShareHolderDTO(fclShareDTO);

        for(IncomeEntity incomeEntity: incomeEntities){
            usd.add(incomeEntity.getIncomeUsd());
            cop.add(incomeEntity.getIncomeCop());
            incomeDTO.setValueCapexUsd(usd);
            incomeDTO.setValueCapexCop(cop);
        }
        opportunities.setIncomeDTO(incomeDTO);

        for(TarifEntity tarif: tarifEntities){
            usd.add(tarif.getValueTarifUsd());
            cop.add(tarif.getValueTarifCop());
            incomeDTO.setValueCapexUsd(usd);
            incomeDTO.setValueCapexCop(cop);
        }
//        opportunities.setT(incomeDTO);

        return opportunities;
    }
}

