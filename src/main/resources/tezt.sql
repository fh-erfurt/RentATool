DROP TABLE IF EXISTS LoginUser;

CREATE  TABLE LoginUser (
                        username VARCHAR(45) NOT NULL ,
                        password VARCHAR(45) NOT NULL ,
                        role VARCHAR(45) NOT NULL ,
                        PRIMARY KEY (username));


INSERT INTO LoginUser(username,password, role)
VALUES ('ADMIN','password', 'ADMIN');
INSERT INTO LoginUser(username,password, role)
VALUES ('EMPLOYEE','password', 'EMPLOYEE');
INSERT INTO LoginUser(username,password, role)
VALUES ('CUSTOMER','password', 'CUSTOMER');
