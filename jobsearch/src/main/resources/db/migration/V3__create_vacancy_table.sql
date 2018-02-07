create table vacancy (
	id int8 not null, 
	company varchar(255),
	description varchar(255),
	dt_creation timestamp,
	dt_vacancy timestamp,
	level varchar(255), 
	quality varchar(255), 
	role varchar(255), 
	skills varchar(255), 
	url varchar(255), 
	xp_time int4, 
	primary key (id)
);