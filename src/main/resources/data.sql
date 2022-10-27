create table CUSTOMER (CUSTOMER_ID number(10),CUSTOMER_NAME varchar2(30));
create table CUSTOMER_TRANSACTIONS (TRANSACTION_ID number(10),CUSTOMER_ID number(10),TRANSACTION_AMT number(30,6),TRANSACTION_DATE DATE);


INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME) VALUES (1, 'John');
INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME) VALUES (2, 'Garry');
INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME) VALUES (3, 'Catalina');
INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME) VALUES (4, 'Anna');
INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME) VALUES (5, 'Margarette');

INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1001, 1, 145,'2022-07-01');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1002, 2, 55,'2022-07-10');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1003, 3, 524,'2022-07-15');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1004, 4, 122,'2022-07-14');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1005, 5, 90,'2022-07-14');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1006, 1, 245,'2022-08-12');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1007, 2, 55,'2022-08-24');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1008, 3, 524,'2022-08-22');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1009, 4, 122,'2022-08-30');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1010, 5, 90,'2022-08-03');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1011, 1, 445,'2022-09-06');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1012, 2, 55,'2022-09-08');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1013, 3, 524,'2022-09-02');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1014, 4, 122,'2022-09-22');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1015, 5, 90,'2022-09-12');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1016, 1, 445,'2022-10-23');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1017, 2, 55,'2022-10-14');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1018, 3, 524,'2022-10-12');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1019, 4, 122,'2022-10-18');
INSERT INTO CUSTOMER_TRANSACTIONS (TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_AMT,TRANSACTION_DATE) VALUES (1020, 5, 90,'2022-10-13');