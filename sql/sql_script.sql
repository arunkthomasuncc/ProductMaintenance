DROP DATABASE IF EXISTS product_maint;

CREATE DATABASE product_maint;

USE product_maint;


CREATE TABLE `product` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(40) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `productID_UNIQUE` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from product;

INSERT INTO PRODUCT (code,description,price) VALUES ("8601", "86 (the band) - True Life Songs and Pictures",14.95);
INSERT INTO PRODUCT(code,description,price) VALUES ("pf01","Paddlefoot - The first CD",12.95);
INSERT INTO PRODUCT(code,description,price) VALUES ("pf02","Paddlefoot - The second CD",14.95);
INSERT INTO PRODUCT(code,description,price) VALUES ("jr01","Joe Rut - Genuine Wood Grained Finish",14.95);

select * from product;
commit;


DROP DATABASE IF EXISTS project_jpa;

CREATE DATABASE project_jpa;

USE project_jpa;

CREATE TABLE `userpass` (
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `userrole` (
  `Username` varchar(50) DEFAULT NULL,
  `Rolename` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into userpass (username, password) values ("arun","arun"); 
insert into userpass (username, password) values ("shashi","shashi"); 
insert into userpass (username, password) values ("gabriel","gabriel"); 

insert into userrole (username, rolename) values ("arun", "programmer");
insert into userrole (username, rolename) values ("shashi", "customer service");
insert into userrole (username, rolename) values ("gabriel", "tester");



------------------------- Keystore Generation ----------------------------------
keytool -genkey -alias tomcat -keyalg RSA
keytool -importkeystore -srckeystore C:\Users\GUDDU\.keystore -destkeystore C:\Users\GUDDU\.keystore -deststoretype pkcs12