-- INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (1,'Weimar','de',87,'Poststraße',05687);
-- INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (2,'Erfurt','de',87,'Musterstraße',05687);
-- INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (3,'Gotha','de',87,'Asbachstraße',05687);
-- -- --
-- --
-- -- INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (1,'Müller','Bosch',065386445,1);
-- -- INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (2,'Maier','Makita',5546456455,3);
-- -- INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (3,'Schulze','DeWalt',0657456445,2);
-- --
--
-- --
-- --
INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (100000, null, null, 'admin', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 0);

INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (200000, null, null, 'employee', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 1);

INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (300000, null, null, 'customer', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
--


INSERT INTO CUSTOMER(id, created, modified, birthday, firstname, lastname, phone_number, account_id, address_id)
VALUES (100000, null, null, null, 'Danny', 'Steinbrecher', null, 100000, null);

INSERT INTO CUSTOMER(id, created, modified, birthday, firstname, lastname, phone_number, account_id, address_id)
VALUES (200000, null, null, null, 'Marco', 'Petzold', null, 200000, null);

INSERT INTO EMPLOYEE(id, created, modified, birthday, firstname, lastname,  account_id, address_id, supervisor_id)
VALUES (300000, null, null, null, 'Christian', 'Koenig', 300000, null, null);

