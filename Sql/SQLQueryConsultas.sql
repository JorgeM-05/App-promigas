select * from oportunidades where oportunidades.id_pais=1;
SELECT * FROM pais WHERE pais = '' AND tipo_proyecto = 'MYA';

select * from pais join oportunidades 
		on pais = 'colombia' and tipo_proyecto='MYA' join sector on tipo_sector='Transporte Gas';







	
select * from cifras_operativas;
insert into cifras_operativas values(2,'USS',20,'USS',22,10,15,20,1000,3000,3500,5,500,40);


/*  */

select * from pais;
select * from sector;
select * from oportunidades ;
select * from cifras_financieras;
select * from oportunidades Where unique_id=1 and id_sector=1;

SELECT * FROM oportunidades op WHERE op.unique_id=1 AND op.id_sector=1;


/*  INSERT PAISES */


insert into pais values('Colombia','2022-10-09','greenfild','Yopal','descripcion','seccion','H','POC','TRM','af','alta');
insert into pais values('Venezuela','2022-11-10','greenfild','caracas','descripcion','seccion','H','POC','TRM','af','alta');
insert into pais values('Peru','2022-11-10','MYA','lima','descripcion','seccion','H','POC','TRM','af','alta');
insert into pais values('Panama','2022-11-10','greenfild','panama','descripcion','seccion','H','POC','TRM','af','alta');

/* INSERT SECTOR */
insert into sector values('Transporte Gas');
insert into sector values('Distribucion Gas');
insert into sector values('Distribucion E.E');
insert into sector values('Solares');
insert into sector values('Auto. Gen');
insert into sector values('Co. Gen');
insert into sector values('Otros');

/* INSERT OPORTUNIDADES */

insert into oportunidades values(1,1,'oportunidad 1','5.4939722,-70.9520643,8.25','greenfield',null);
insert into oportunidades values(1,2,'oportunidad 2','5.4939722,-70.9520643,8.25',null,'MYA');
insert into oportunidades values(2,2,'oportunidad 1','5.4939722,-70.9520643,8.25','greenfield',null);
insert into oportunidades values(2,3,'oportunidad 2','5.4939722,-70.9520643,8.25',null,'MYA');




select * from oportunidades;
delete from oportunidades;
insert into oportunidades values(3,'oportunidad 8','5.4939722,-70.9520643,8.25','greenfield',null);

select * from pais;
select * from oportunidades;
select * from cifras_operativas;


select * from cifras_financieras;
insert into cifras_financieras values(3,'USS',100.2,'ing Unidad UUSS',21.2,'USS',20,30,'tar uni',2,'tar t ind','opex',4,'util net','33');


select * from sector tipo_sector;
select * from oportunidades;

delete from sector;



select * from oportunidades;
select * from pais join oportunidades 
		on pais = 'venezuela' and tipo_proyecto='MYA' join sector on tipo_sector='Transporte Gas';

select * from pais join oportunidades 
		on pais = 'colombia' OR pais ='peru' and tipo_proyecto='MYA' join sector on tipo_sector='Distribucion Gas' join cifras_financieras on capex_cifra >= 10;