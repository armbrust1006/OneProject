create table membership(
	user_name varchar2(20) not null,
	age number(3) not null,
	sex varchar2(10) not null,
	email varchar2(30) not null,
	user_id varchar2(20) not null,
	user_pw varchar2(15) not null,
	constraint tmembership_userid_pk primary key(user_id));
	
create table membertype(
	user_id varchar2(20) not null,
	set_date date not null,
	type_aw_data varchar2(200) not null,
	type_select varchar2(30) not null,
	constraint typecheck_userid_fk foreign key(user_id) references membership(user_id));
	
create table typetest(
	typenum number(3) not null,
	type_qu_data varchar2(200) not null,
	constraint typetest_typenum_pk primary key(typenum));

create table typetestqu(
	typenum number(3) not null,
	type_aw_data varchar2(200) not null,
	type_select varchar2(30) not null,
	constraint typetestqu_typenum_fk foreign key(typenum) references typetest(typenum));
	
create table cook(
	type_select varchar2(30) not null,
	image_cafeteria varchar2(80) not null,
	image_cooks varchar2(80) not null,
	cafeteria varchar2(50) not null,
	cooks varchar2(50) not null,
	address varchar2(150) not null);
	
create table travel(
	type_select varchar2(30) not null,
	image_country varchar2(80) not null,
	image_city varchar2(80) not null,
	country varchar2(30) not null,
	city varchar2(30) not null,
	address varchar2(150) not null);