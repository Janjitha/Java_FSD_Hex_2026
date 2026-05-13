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

