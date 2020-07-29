CREATE DEFINER=`student`@`localhost` PROCEDURE `Inserting_Transaction_Data`(In the_status varchar(20),in the_balance int)
BEGIN
    insert into transaction (statusinfo,balance) values (the_status,the_balance);
END