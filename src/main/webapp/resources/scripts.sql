create database studentsportal;

use studentsportal;

CREATE TABLE Users( 
uid int(20) NOT NULL AUTO_INCREMENT, 
uname VARCHAR(60) NOT NULL, 
password VARCHAR(60) NOT NULL, 
PRIMARY KEY(uid));

CREATE TABLE Students( 
id int(20) NOT NULL AUTO_INCREMENT, 
name VARCHAR(60) NOT NULL, 
year VARCHAR(10) NOT NULL, 
contact_number VARCHAR(60) NOT NULL,
registration_number VARCHAR(60) NOT NULL, 
PRIMARY KEY(id));

commit;


INSERT INTO Users VALUES(1,'loganantham','loganantham');

commit;

select * from users;

update users set uname='714213104032' where uid=1;

commit;

commit;

update users set uname='714213104032' where uname='loganantham';