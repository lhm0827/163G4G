create database db_emp;
use db_emp;

create table t_emp(
	eid int primary key identity(1,1),
	empName varchar(30) not null,
	empSex varchar(1) not null,
	brithday varchar(20) not null,
	deptId int
);

create table t_dept(
	deptId int primary key identity(1,1),
	deptName varchar(30) not null,
	adrress varchar(30) not null
);

create table t_userinfo(
	userId int primary key identity(1,1),
	userName varchar(30) not null,
	userPwd varchar(30) not null
);