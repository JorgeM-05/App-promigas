
Drop table dbo.cifras_financieras;
Drop table dbo.cifras_operativas;
Drop table dbo.benef_tributarios;
Drop table dbo.indicadores;
Drop table dbo.oportunidades;
Drop table dbo.pais;
Drop table dbo.sector;
Drop table dbo.tipo_contrato;
Drop table dbo.tir_equity;


/* pais */
create table [dbo].[pais](
	[unique_id] int primary key identity(1,1) Not null,
	[pais] [nvarchar](30)Not null,
	[fecha_actualizacion] [nvarchar] (20) Not null,
	[tipo_proyecto] [nvarchar](20)Not null,
	[ubicacion_geografica] [nvarchar](20),
	[descripcion_oportunidad] [nvarchar] (20),
	[seccion_supuestos] [nvarchar](20),
	[horizonte] [nvarchar](20),
	[POC] [nvarchar] (20),
	[TRM] [nvarchar](20),
	[activo_financiero] [nvarchar](20),
	[prioridad] [nvarchar](20),	
)



/* oportunidades */
create table [dbo].[oportunidades](
	[unique_id] int primary key identity(1,1) Not null,
	[id_pais] [int] Not Null,
	[id_sector] [int] not null,
	[nombre_oportunidad] [nvarchar] (20),
	[coordenadas] [nvarchar] (40),
	[greenfield] [nvarchar](20),
	[MYA] [nvarchar] (20),
)

alter table oportunidades add constraint FK_Sector_Opor 
	FOREIGN KEY (id_sector)
	REFERENCES sector(unique_id)

alter table oportunidades add constraint FK_pais_opor 
	FOREIGN KEY (id_pais)
	REFERENCES pais(unique_id)


/* sector */
create table [dbo].[sector](
	[unique_id] int primary key identity(1,1) Not null,
	[tipo_sector] [nvarchar] (40) not null,
)

/* Cifra financieras */
create table [dbo].[cifras_financieras](
	[unique_id] int primary key identity(1,1) Not null,
	[id_oportunidad] [int] Not Null,
	[capex_unidades] [nvarchar] (20) ,
	[capex_cifra] [float] (20),
	[ingresos_unidades] [nvarchar] (20),
	[ingresos_cifra] [float] (20),
	[ebitda_unidades] [nvarchar] (20),
	[ebitda_cifra] [float] (20),
	[tir_proyecto] [float] (20) ,
	[tarifa_unidades] [nvarchar] (20) ,
	[tarifa_cifra] [float] (20),
	[tarifa_tipo_index] [nvarchar] (20),
	[opex_unidades] [nvarchar] (20),
	[opex_cifra] [float] (20),
	[utilidad_neta_unidades] [nvarchar] (20) ,
	[utilidad_neta_cifra] float (20),
)

alter table cifras_financieras add constraint FK_CF_OP
	FOREIGN KEY (id_oportunidad)
	REFERENCES oportunidades(unique_id)

/* Cifras Operativas */
create table [dbo].[cifras_operativas] (
	[unique_id] int primary key identity(1,1) Not null,
	[id_oportunidad] [int] Not Null,
	[sol_energ_potencia_unid] [nvarchar] (20),
	[sol_energ_potencia_cifra] [float] (20),
	[sol_energ_gener_unid] [nvarchar] (20),
	[sol_energ_gener_cifra] [float] (20),
	[sol_energ_degrada_prom] [float] (20),
	[sol_energ_hora_sol] [float] (20),
	[trans_cap_max] [float] (20),
	[trans_vol_Trans] [float] (20),
	[trans_int_gasod] [float] (20),
	[distr_volumen] [float] (20),
	[distr_conex_periodo] [int],
	[distr_kms_Red] [float] (20),
	[distr_penetracion] [float] (20),
)
alter table cifras_operativas add constraint FK_CO_OP
	FOREIGN KEY (id_oportunidad)
	REFERENCES oportunidades(unique_id)






/*Contrato */
create table [dbo].[tipo_contrato](
	[unique_id] int primary key identity(1,1) Not null,
	[id_pais] [int] Not Null,
	[concesion] [nvarchar] (20) ,
	[BOMT] [nvarchar] (20) ,
	[BOOM] [nvarchar] (20),
	[PPA] [nvarchar] (20) ,
	[pague_generado] [nvarchar] (20) ,
	[pague_consumido] [nvarchar] (20) ,
	[takerOrPay] [nvarchar] (20) ,
)
alter table oportunidades add constraint FK_pais_opor 
	FOREIGN KEY (id_pais)
	REFERENCES pais(unique_id)

/* */
create table [dbo].[indicadores](
	[unique_id] int primary key identity(1,1) Not null,
	[id_pais] [int] Not Null,
	[deuda_unidades] [nvarchar] (20) ,
	[deuda_cifra] [float] (20),
	[deudaNeta_unidades] [nvarchar] (20) ,
	[deuda_neta_cifra] [float] (20),
	[ebitda_unidades] [nvarchar] (20),
	[ebitda_cifra] [float] (20),
	[FFO_unidades] [nvarchar] (20),
	[FFO_cifra] [float] (20),
	[deudaNeta_ebitda] [float] (20) ,
	[FFO_deuda] [float] (20) ,
)

create table[dbo].[benef_tributarios](
	[unique_id] int primary key identity(1,1) Not null,
	[id_pais] [int] Not Null,
	[deduccion_capex] [nvarchar] (20) ,
	[exencion_IVA] [nvarchar] (20),
	[dep_aAcelerada] [nvarchar] (20) ,
	[exencion_renta] [nvarchar] (20) ,
	[CEI] [nvarchar] (20) ,
)

create table [dbo].[tir_equity](
	[unique_id] int primary key identity(1,1) Not null,
	[id_cifras_finc] [int] Not Null,
	[id_cifras_financiras] [int] Not Null,
	[estructura_capital] [float] (20),
	[costo_deuda] [float] (20) ,
	[forma_amortizacion] [nvarchar] (20) ,
)




