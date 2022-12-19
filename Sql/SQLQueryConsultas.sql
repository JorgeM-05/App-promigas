
/*  */

;
select * from sector;
select * from type_contract;
select * from opportunities;
select * from country
select * from 



/*  INSERT PAISES */
insert into country values('Colombia');
insert into country values('Venezuela');
insert into country values('Panama');
insert into country values('Argentina');

/* INSERT SECTOR */
insert into sector values('Transporte Gas');
insert into sector values('Distribucion Gas');
insert into sector values('Distribucion E.E');
insert into sector values('Solares');
insert into sector values('Auto. Gen');
insert into sector values('Co. Gen');
insert into sector values('Otros');
/* Tipo de contrato*/

insert into type_contract values('BONT')
insert into type_contract values('BOOM')

/* INSERT OPORTUNIDADES */

insert into opportunities values(1,1,1,'NO','SI','Vincorte','12/12/2022','5.4939722,-70.9520643,8.25','Proyecto fotovoltaico','abc',123, 232,'enero/24',4850,4900,'51','49',null);
insert into opportunities values(2,3,1,'NO','SI','Vincorte','12/12/2022','5.4939722,-70.9520643,8.25','Proyecto fotovoltaico','abc',123, 232,'enero/24',4850,4900,'51','49',null);


/* CIFR FINANC */
insert into cifras_financieras values(,'USS',100.2,'ing Unidad UUSS',21.2,'USS',20,30,'tar uni',2,'tar t ind','opex',4,'util net','33');




select * from oportunidades;
delete from oportunidades;
insert into oportunidades values(3,'oportunidad 8','5.4939722,-70.9520643,8.25','greenfield',null);

select * from pais;
select * from oportunidades;
select * from cifras_operativas;


select * from cifras_financieras;


select * from sector tipo_sector;
select * from oportunidades;

delete from sector;



select * from oportunidades;
select * from pais join oportunidades 
		on pais = 'venezuela' and tipo_proyecto='MYA' join sector on tipo_sector='Transporte Gas';

select * from pais join oportunidades 
		on pais = 'colombia' OR pais ='peru' and tipo_proyecto='MYA' join sector on tipo_sector='Distribucion Gas' join cifras_financieras on capex_cifra >= 10;