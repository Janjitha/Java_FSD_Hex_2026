-- creating DB
create database hex;
-- select db for working
use hex;
-- create table customer
create table customers(id int primary key,
name varchar(255) not null,
city varchar(255),
age int);
-- semicolon is delimter, its a signal to mention that its the end of the query
-- check table structure
desc customers;
-- inserting in db
insert into customers values
(1,"harry potter","london",19),
(2,"ronald weasley","surrey",20),
(3,"hermione granger","london",19);

select * from customers;

/* Simple STORED Procedure to display all customers */
DELIMITER $$
create procedure get_all_customers()
BEGIN 
    select * from customers;
END
$$
/* to see the result we need to CALL the procedure */
CALL get_all_customers;

/* create a procedure to read input from the user and display rows
Input: city
Output: Customer rows */
DELIMITER $$
CREATE PROCEDURE get_customers_by_city(IN p_city varchar(255))
BEGIN
     -- validate the input
     IF TRIM(p_city) = "" OR p_city is null THEN
		SIGNAL sqlstate "45000"
        SET message_text ="city value cannot be blank or null";
     END IF;
     -- sql
     select * from customers where city = p_city;
END
$$
-- if i made a mistake i need to drop the procedure and create again new
-- drop the proc
drop procedure get_customers_by_city;

-- quotes can be single quotes or double quotes
call get_customers_by_city('london');
call get_customers_by_city('surrey');
call get_customers_by_city('');
call get_customers_by_city('   ');

/* IF <condition> then
      do something
   else if <condition> then
      do something
	END IF;
*/

/* Proc to count number of rows using 
Input and output */
DELIMITER $$
create procedure get_customer_count_by_city(IN p_city varchar(255), OUT p_total_customers INT)
BEGIN
	-- validate the input
    IF TRIM(p_city) = "" OR p_city IS NULL THEN
		SIGNAL sqlstate "45000" 
        SET message_text ="city value cannot be blank or null";
    END IF; 
    -- SQL 
	select COUNT(*) into p_total_customers
    from customers
    where city = p_city;
END
$$

CALL get_customer_count_by_city('london', @total_customers);
CALL get_customer_count_by_city('surrey', @total_customers); -- @ is for session variables 
select @total_customers;

-- DAY 2 PLSQL 
/*
Create a Proc for updating city(IN city, OUT city) and give back the updated city using INOUT param
*/
DELIMITER $$
create procedure city_updation(IN p_id int, INOUT p_city varchar(255))
BEGIN
     update customers 
     SET city = p_city
     where id = p_id;
END
$$
SET @city_val = "mumbai";
CALL city_updation(3, @city_val);
select @city_val;

/*
Create a View to hide age info of customers and also hide all records that have city as mumbai
*/
create VIEW customer_view AS 
select id, name, city
from Customers 
where city not in ('mumbai');

-- To view the result
select * from customer_view

