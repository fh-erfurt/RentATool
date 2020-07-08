INSERT INTO Login_User(id, user_name, password, active, roles) VALUES (1,'user1', 'pass', false, 'CUSTOMER');
INSERT INTO Login_User(id, user_name, password, active, roles) VALUES (2,'user2', 'pass', true, 'CUSTOMER');
INSERT INTO Login_User(id, user_name, password, active, roles) VALUES (3,'user3', 'pass', true, 'ADMIN');


INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (1,'Weimar','de',87,'Poststraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (2,'Arnstadt','de',87,'Musterstraße',05687);
INSERT into ADDRESS (id, city,country,house_nr,street,zip) values (3,'Gotha','de',87,'Asbachstraße',05687);


INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (1,'Müller','Bosch',065386445,1);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (2,'Maier','Makita',5546456455,2);
INSERT into MANUFACTURER  (id, agent,name,phone_number,address_id) values (3,'Schulze','DeWalt',0657456445,3);