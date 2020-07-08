INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (1,'Weimar','de',87,'Poststraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (2,'Erfurt','de',87,'Musterstraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (3,'Gotha','de',87,'Asbachstraße',05687);


INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (1,'Müller','Bosch',065386445,1);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (2,'Maier','Makita',5546456455,3);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (3,'Schulze','DeWalt',0657456445,2);


INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (1, null, null, 'admin', 'password', 0);

INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (2, null, null, 'employee', 'password', 1);

INSERT INTO ACCOUNT(id, created, modified, email, password, role)
VALUES (3, null, null, 'customer', 'password', 2);

-- INSERT INTO EMPLOYEE(id, created, modified, birthday, firstname, lastname, account_id, supervisor_id)
-- VALUES (1,null, null, null, null, null, 1, null);