Easy e-Commerce

ABC Inc., a leader in e-commerce business wants to create an e-commerce platform which could be used by retailers to 
build their e-Commerce portals.  ABC Inc. has already got couple of book sellers who are interested to pilot this product. 
The initial Minimum Viable Product should serve only the book sellers and later they would like to expand it to people selling 
other things (Electronics, Mobile or a complete set like Homeshop18). 

Getting Started

Application Configuration
---------------------------
-->Added dependencies for mysql,tomcat,jpa in pom.xml
-->Added properties to connect mysql in application.properties

Connecting mysql database
--------------------------
-->created database for the application
create database book_store

-->created tables product and customer with below fields

create table customer
(
  customer_id int not null,
  customer_name varchar(30)
 );
 
create table product
(
  customer_id int not null,
  product_id int not null,
  product_name varchar(30),
  price double

);

Application Api's details :
------------------------------

a . Add to Cart - 
Is an Post Api which will take Customer and Product information as input and which will add(insert) the data into
into Cart.

b . Checkout -
Is an Get APi which will take CustomerId as an input to fetch the details of the Billing.
