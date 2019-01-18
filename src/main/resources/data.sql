INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (1, 'HOMER SIMPSON', '20345-3456', 'Springfield', '76876876', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (2, 'SELMA BOUVIER', '20521-9876', 'Springfield', '65774567', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (3, 'KENT BROCKMAN', '20909-2345', 'Springfield', '98565456', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (4, 'NED FLANDERS',  '20765-4567', 'Springfield', '23452345', 0);

INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(1, 1, '0000', '1111', '2222', '3333', 'Credit Card', '000', 0);
INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(2, 1, '5555', '6666', '7777', '8888', 'Credit Card', '9999', 0);
INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(3, 4, '9999', '8888', '7777', '6666', 'Credit Card', '777', 0);

INSERT INTO adviser (id, full_name, speciality, version) VALUES (1, 'Seymour Skinner', 'Seguros', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (2, 'Moe Szyslak', 'Negocios', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (3, 'Ralph Wiggum', 'Personal', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (4, 'Dr. Nick Riviera', 'Seguros', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (5, 'Grampa Simpson', 'Seguros', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (6, 'Apu Nahasapeemapetilon', 'Negocios', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (7, 'Otto Mann', 'Personal', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (8, 'Lenny Leonard', 'Seguros', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (9, 'Krusty the Clown', 'Seguros', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (10, 'Edna Krabappel', 'Negocios', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (11, 'Jimbo Jones', 'Personal', 0);
INSERT INTO adviser (id, full_name, speciality, version) VALUES (12, 'Barney Gumble', 'Seguros', 0);


drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1
