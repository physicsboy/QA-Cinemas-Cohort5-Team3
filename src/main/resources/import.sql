<!-- @author AlexNewton -->

INSERT INTO movie VALUES (1, 'Some person', '12A', 'string', 'Action', 118, 'urlhere', 'Kong', '2017-03-10');
INSERT INTO movie VALUES (2, 'An actor', '15', 'string', 'RomCom', 85, 'urlHere', '50  shades of Grey', '2015-03-10');
INSERT INTO movie VALUES (3, 'Somebody', '18', 'string', 'Action', 118, 'urlHere', 'Kong', '2016-03-10');
INSERT INTO movie VALUES (4, 'All Yall', '12A', 'string', 'Looooolll', 24, 'urlHere', 'American Horror Story', '2012-01-10');

INSERT INTO screen VALUES (1, 'N', 40),(2, 'P', 30),(3, 'P',10),(4, 'M', 15);

INSERT INTO user VALUES ('alex@alex.com','Alex','Name','Line 1 Street','Second','Townsville','Citydom','CT1 S50','password');
INSERT INTO user VALUES ('fred@fred.com','Fred','Surname','987 Lane','Here','Nowheresville','Nowhere','NO9 8RT','password');
INSERT INTO user VALUES ('sam@sam.com','Sam','Othername','123 Street','Place','Townstown','Citycity','CY3 9PL','password');

INSERT INTO showing VALUES (1, '2017-09-03', 1, 2);
INSERT INTO showing VALUES (2, '2017-11-03', 3, 3);
INSERT INTO showing VALUES (3, '2017-15-03', 4, 1);
INSERT INTO showing VALUES (4, '2017-12-03', 2, 4);

INSERT INTO booking VALUES (1, '2017-09-03', 'alex@alex.com', 'alex@alex.com');
INSERT INTO booking VALUES (2, '2017-11-03', 'sma@sam.com', 'sam@sam.com');
INSERT INTO booking VALUES (3, '2017-12-03', 'fred@fred.com', 'alex@alex.com');
INSERT INTO booking VALUES (3, '2017-12-03', 'fred@fred.com', 'alex@alex.com');


INSERT INTO ticket VALUES (1, 6.99, 'A1', 'Child', 1, 1),
INSERT INTO ticket VALUES (2, 9.99, 'A3', 'Adult', 2, 2);
INSERT INTO ticket VALUES (3, 5.99, 'A1', 'Child', 4, 2),
INSERT INTO ticket VALUES (4, 7.99, 'A3', 'Concession', 3, 4);
INSERT INTO ticket VALUES (5, 6.99, 'A3', 'Adult', 4, 4);
