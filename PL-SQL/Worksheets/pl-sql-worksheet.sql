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

-- create product table 
create table product(id INT primary key, name varchar(255), price double, stock INT);
create table transaction(id INT primary key, product_id INT, qty INT, sale_date Date);

insert into product values (1,'Macbook Air', 40000, 2);
insert into product values (2,'Macbook Pro', 111000, 1);

/*
create a trigger that gets executed BEFORE the insert on transaction
and does following check
1. if purchase quantity is more than available stock quantity , trigget must throw 45000 sql state error with message
'Requested quantity not available'
*/
insert into transaction values (1, 1, 3, now()); -- this query is going to call the trigger

DELIMITER $$

create trigger trg_product_stock_check
BEFORE INSERT on transaction
FOR EACH ROW
BEGIN
    -- declare a variable to hold stock of product
    DECLARE v_stock INT;

    select stock into v_stock
    from product
    where id=NEW.product_id ;  -- the product_id that the user wants to add to transaction

    -- check if stock is less than qty
    IF v_stock < NEW.qty THEN
        SIGNAL sqlstate "45000"
        SET message_text="Requested quantity not available";
    END if;
END
$$

/*
create trigger to update stock quantity in ptoduct table
AFTER the insert has happend

insert into transaction values (1, 1, 3, now()); -- this query is going to call the trigger
insert into transaction values (1, 1, 1, now());
*/

DELIMITER $$

create trigger trg_update_product_stock
AFTER INSERT on transaction
FOR EACH ROW
BEGIN
    -- update the stock quantity
    update product
    set stock = stock - NEW.qty
    where id = NEW.product_id;

END
$$


/*
Cursors: they are used to fetch records from the DB 
Cursor STEPS : 
1. Declare the cursor 
   - declare the variables to hold the record values  
	1.5.  Declare cursor continue handler   
2. OPEN it 
3. Fetch the records
	3.1. Start the labelled loop 
    3.2. FETCH into variables 
    3.3. Wrtie termination IF using cursor handler 
    3.4. Perform ops with variables 
    3.5. Close the loop 
4. CLOSE it  
*/

-- Create a Cursor to fetch all products  
DELIMITER $$
create procedure fetch_all_products()
BEGIN
    -- Delcare variables 
    declare v_id INT ;
    declare v_price double ;
    declare complete boolean DEFAULT false; 
    
	-- Declare the cursor
    declare all_products_cursor cursor FOR   -- for this query i use this cursor 
    select p.id,p.price  
	from product p ; 
    
    -- decalre termination condition 
    declare continue handler FOR NOT FOUND SET complete = true ; -- cursor will now manage this complete 
    
    OPEN all_products_cursor; 
    
    -- loop thru the cursor 
    loop_lbl: 
    LOOP    -- this starts the loop and stays in it until we leave the loop 
		FETCH all_products_cursor into v_id,v_price ;
		
		if complete = true THEN 
			leave loop_lbl;   -- leave the loop when complete is done 
		END if ; 
		-- Note: complete is managed by cursor itself as it is defined as a handler 
    
    -- perform ops on these row values 
    select v_id, v_price; 
    
    END LOOP;
    CLOSE all_products_cursor; 
END; 
$$

call fetch_all_products(); 
