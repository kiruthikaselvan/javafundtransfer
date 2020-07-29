create database transactiondb;
use transactiondb;
create table transaction(tranid int NOT NULL auto_increment,statusinfo varchar(50),balance int);
insert into transaction (statusinfo,balance) values ('Initial Balance',10000);