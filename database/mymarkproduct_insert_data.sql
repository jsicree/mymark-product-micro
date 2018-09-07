-- PRODUCTS
INSERT INTO PRODUCT (product_code, name, price, short_desc, long_desc) value ("PROD-001","Widget A", 19.99, "A simple widget", "Lorem ipsum ipso facto.");
INSERT INTO PRODUCT (product_code, name, price, short_desc, long_desc) value ("PROD-002","Widget B", 29.99, "An even better widget", "Lorem ipsum ipso facto.");

-- INVENTORY
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-001","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-002","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-003","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-004","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-005","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-006","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-007","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-008","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-009","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-010","AVAILABLE");

INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-020","SOLD", '2017-05-10');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-021","SOLD", '2017-11-05');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-022","SOLD", '2018-01-21');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-023","SOLD", '2018-02-14');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-024","SOLD", '2018-03-01');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-025","SOLD", '2018-05-13');

INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-030","IN_PROCESS",'2018-04-05');
INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-031","IN_PROCESS",'2018-05-24');
INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-032","IN_PROCESS",'2018-06-10');

INSERT INTO INVENTORY (product_id, sku, status, return_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-040","RETURNED", '2018-03-23');
INSERT INTO INVENTORY (product_id, sku, status, return_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-001"),"PROD-001-041","RETURNED", '2018-05-02');

INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-070","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-071","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-072","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-073","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-074","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-075","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-076","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-077","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-078","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-079","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-080","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-081","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-082","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-083","AVAILABLE");
INSERT INTO INVENTORY (product_id, sku, status) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-084","AVAILABLE");

INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-001","SOLD", '2017-05-10');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-002","SOLD", '2018-01-09');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-003","SOLD", '2018-01-15');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-004","SOLD", '2017-02-03');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-005","SOLD", '2017-03-14');
INSERT INTO INVENTORY (product_id, sku, status, sell_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-006","SOLD", '2017-06-02');

INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-010","IN_PROCESS",'2018-06-05');
INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-011","IN_PROCESS",'2018-07-02');
INSERT INTO INVENTORY (product_id, sku, status, in_process_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-012","IN_PROCESS",'2018-07-05');

INSERT INTO INVENTORY (product_id, sku, status, return_date) values ((SELECT p.id from PRODUCT p where p.product_code = "PROD-002"),"PROD-002-030","RETURNED", '2018-06-27');

