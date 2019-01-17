INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (1, 'Homer Simpson', '20345-3456', 'Springfield', '76876876', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (2, 'Selma Bouvier', '20521-9876', 'Springfield', '65774567', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (3, 'Kent Brockman', '20909-2345', 'Springfield', '98565456', 0);
INSERT INTO customer (id, full_name, address, city, phone, version) VALUES (4, 'Ned Flanders',  '20765-4567', 'Springfield', '23452345', 0);

INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(1, 1, '0000', '1111', '2222', '3333', 'Credit Card', '000', 0);
INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(2, 1, '5555', '6666', '7777', '8888', 'Credit Card', '9999', 0);
INSERT INTO card(id, customer_id, number1, number2, number3, number4, card_type, ccv, version)
VALUES(3, 4, '9999', '8888', '7777', '6666', 'Credit Card', '777', 0);

drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1
