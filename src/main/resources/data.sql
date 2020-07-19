INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (100000,'Weimar','de',87,'Poststraße','05687');
INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (200000,'Erfurt','de',87,'Musterstraße','05687');
INSERT into ADDRESS (id, city,country,house_nr,street,zip) VALUES (300000,'Gotha','de',87,'Asbachstraße','05687');

INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (100000,'Müller','Bosch',065386445,100000);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (200000,'Maier','Makita',5546456455,300000);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) VALUES (300000,'Schulze','DeWalt',0657456445,200000);

INSERT INTO WAREHOUSE(id) VALUES (100000);

INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10000,'Bo11A1',100000,'Hammer','1A',0,2,3.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10001,'Mak11A1',200000,'Schlagohrer','2A',0,0,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10002,'De001',300000,'Heckenschere','3A',0,1,6.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10003,'Bo11A2',100000,'Trennschleifer','4A',0,1,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10004,'Mak11A2',200000,'Kettensäge','5A',0,1,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10005,'De002',300000,'Kettensäge','6A',0,0,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10006,'Bo11A3',100000,'Plasmaschneider','7A',0,1,15.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10007,'Mak11A3',200000,'Schraubendreher-Set','8A',0,2,3.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10008,'De003',300000,'Kreissäge','9A',0,1,10.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10009,'Bo11A4',100000,'Rasentrimmer','10A',0,3,8.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10010,'Mak11A4',200000,'Bohrmaschine','11A',0,1,8.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10011,'De004',300000,'Schlüssel-Set','12A',1,2,4.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10012,'Bo11A5',100000,'Säge','13A',1,2,5.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10013,'Mak11A5',200000,'Trennschleifer','14A',1,0,7.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10014,'De005',300000,'Rasenmäher','15A',2,3,11.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10015,'Bo11A6',100000,'Rüttelplatte','16A',2,0,12.00);
INSERT into TOOL (id, item_id, manufacturer_id, description, stock, tool_status, category, rent_price) VALUES (10016,'Mak11A6',200000,'Zementmischer','17A',2,2,20.00);

INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10000);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10001);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10002);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10003);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10004);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10005);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10006);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10007);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10008);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10009);
INSERT INTO WAREHOUSE_TOOLS (warehouse_id,tool_id) VALUES (100000,10010);

INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100000, null, null, 'customer1', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100001, null, null, 'customer2', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100002, null, null, 'customer3', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100003, null, null, 'customer4', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 2);

INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100004, null, null, 'employee', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 1);
INSERT INTO ACCOUNT(id, created, modified, email, password, role) VALUES (100005, null, null, 'admin', '$2a$10$Ijtq5paiwKrZ7RG4RAadHux0SrXBcCKiu7fkNQUrMStruqhDFh8ia', 0);

INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (100000, null, 'Danny', 'Steinbrecher', '12345', 100000, 100000);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (100001, null, 'Nietzsche', 'Friedrich', '12345', 100001, 200000);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (100002, null, 'Sigmund', 'Freud', '12345', 100002, 300000);
INSERT INTO CUSTOMER(id, birthday, firstname, lastname, phone_number, account_id, address_id) VALUES (100003, null, 'Wladimir', 'Lenin', '12345', 100003, 100000);

INSERT INTO EMPLOYEE(id, birthday, firstname, lastname,  account_id, address_id, supervisor_id) VALUES (100000, null, 'Christian', 'Koenig', 100005, 200000, null);
INSERT INTO EMPLOYEE(id, birthday, firstname, lastname,  account_id, address_id, supervisor_id) VALUES (100001, null, 'Marco', 'Petzold', 100004, 100000, 100000);

INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (100000,'Station 1',25,100000);
INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (100001,'Station 2',25,200000);
INSERT INTO STATION(id,description,number_of_boxes,address_id) VALUES (100002,'Station 3',25,300000);