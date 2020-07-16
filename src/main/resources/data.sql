INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (1,'Weimar','de',87,'Poststraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (2,'Erfurt','de',87,'Musterstraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (3,'Gotha','de',87,'Asbachstraße',05687);

INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (1,'Müller','Bosch',065386445,1);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (2,'Maier','Makita',5546456455,3);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (3,'Schulze','DeWalt',0657456445,2);

INSERT INTO WAREHOUSE(id) VALUES (1);

INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (100,'Bo11A1',1,'Hammer','1A',0,2,3.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (101,'Mak11A1',2,'Schlagohrer','2A',0,0,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (102,'De001',3,'Heckenschere','3A',0,1,6.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (103,'Bo11A2',1,'Trennschleifer','4A',0,1,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (104,'Mak11A2',2,'Kettensäge','5A',0,1,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (105,'De002',3,'Kettensäge','6A',0,0,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (106,'Bo11A3',1,'Plasmaschneider','7A',0,1,15.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (107,'Mak11A3',2,'Schraubendreher-Set','8A',0,2,3.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (108,'De003',3,'Kreissäge','9A',0,1,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (109,'Bo11A4',1,'Rasentrimmer','10A',0,3,8.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (110,'Mak11A4',2,'Bohrmaschine','11A',0,1,8.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (111,'De004',3,'Schlüssel-Set','12A',1,2,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (112,'Bo11A5',1,'Säge','13A',1,2,5.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (113,'Mak11A5',2,'Trennschleifer','14A',1,0,7.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (114,'De005',3,'Rasenmäher','15A',2,3,11.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (115,'Bo11A6',1,'Rüttelplatte','16A',2,0,12.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (116,'Mak11A6',2,'Zementmischer','17A',2,2,20.00);

INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,100);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,101);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,102);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,103);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,104);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,105);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,106);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,107);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,108);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,109);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (1,110);

INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (1, null, null, 'customer1', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (2, null, null, 'customer2', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (3, null, null, 'customer3', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (4, null, null, 'customer4', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);

INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (5, null, null, 'employee', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 1);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (6, null, null, 'admin', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 0);

INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (1, null, 'Danny', 'Steinbrecher', '12345', 1, 1);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (2, null, 'Nietzsche', 'Friedrich', '12345', 2, 1);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (3, null, 'Sigmund', 'Freud', '12345', 3, 1);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (4, null, 'Wladimir', 'Lenin', '12345', 4, 1);

INSERT INTO EMPLOYEE(id, birthday, firstname, lastname,  account_id, address_id, supervisor_id) VALUES (1, null, 'Christian', 'Koenig', 6, 1, null);
INSERT INTO EMPLOYEE(id, birthday, firstname, lastname,  account_id, address_id, supervisor_id) VALUES (2, null, 'Marco', 'Petzold', 5, 1, 1);

INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (1,'Station 1',25,1);
INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (2,'Station 2',25,2);
INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (3,'Station 3',25,3);