

	drop table tnn_has_voyage_ville;
	drop table tnn_voyage;
	drop table tnn_ville;
	
	create table tnn_voyage (
		idVoyage int( 10 ) not null auto_increment,
		nom varchar( 255 ) not null,
		primary key  (idVoyage)
	) engine = innodb;
	
	create table tnn_ville (
		idVille int( 10 ) not null auto_increment,
		nom varchar( 255 ) NOT NULL , 
		primary key(idVille)
	) engine = innodb;
	
	create table tnn_has_voyage_ville (
		idVoyageVille int (10) not null auto_increment,
		idVoyage int( 10 ) not null,
		idVille int( 10 ) not null,
		foreign key (idVoyage) references tnn_voyage (idVoyage),
		foreign key (idVille) references tnn_ville (idVille),
		primary key(idVoyageVille, idVoyage, idVille)
	) engine = innodb;
	
	insert into tnn_voyage (idVoyage,nom) values (1,'Autour de Brest');
	insert into tnn_voyage (idVoyage,nom) values (2,'Autour de Rennes');

	insert into tnn_ville (idVille, nom) values (1,'Brest');
	insert into tnn_ville (idVille, nom) values (2,'Quimper');
	insert into tnn_ville (idVille, nom) values (3,'Lorient');
	insert into tnn_ville (idVille, nom) values (4,'Rennes');
	insert into tnn_ville (idVille, nom) values (5,'Nantes');
	
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (1,1);
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (1,2);
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (1,3);
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (2,3);
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (2,4);
	insert into tnn_has_voyage_ville (idVoyage, idVille) values (2,5);
	
		