<!-- @author AlexNewton -->

INSERT INTO movie VALUES (1, 'Ralph Finnnes, Maria Carey et Al', 'U', 'In a world full of lego..... there is batman', 'Adventure', 118, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Lego Batman Movie', '<iframe width="560" height="315" src="https://www.youtube.com/embed/LHgQSwgKygk" frameborder="0" allowfullscreen></iframe>', '2017-03-10');
INSERT INTO movie VALUES (2, 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', '15', 'mystery and dreaming', 'Action, Sci-Fi', 148, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg', 'Inception', '<iframe width="560" height="315" src="https://www.youtube.com/embed/LHgQSwgKygk" frameborder="0" allowfullscreen></iframe>', '2010-07-08');
INSERT INTO movie VALUES (3, 'Tom Hiddleston, Samuel L. Jackson, Brie Larson', '18', 'Humanity tries to save itself from a rather large ape.', 'Action', 120, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwMzI5ODEwNF5BMl5BanBnXkFtZTgwNjAzNjI2MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Kong: Skull Island', '<iframe width="560" height="315" src="https://www.youtube.com/embed/LHgQSwgKygk" frameborder="0" allowfullscreen></iframe>', '2017-03-01');
INSERT INTO movie VALUES (4, 'Roy Scheider, Robert Shaw, Richard Dreyfuss', '12A', 'A big shark is eating people. The special effects are on point.', 'Adventure', 96, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMmVmODY1MzEtYTMwZC00MzNhLWFkNDMtZjAwM2EwODUxZTA5XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX651_CR0,0,651,999_AL_.jpg', 'Jaws', '<iframe width="560" height="315" src="https://www.youtube.com/embed/LHgQSwgKygk" frameborder="0" allowfullscreen></iframe>', '1975-01-10');

INSERT INTO screen VALUES (1, 'N', 40),(2, 'P', 30),(3, 'P',10),(4, 'M', 15);

INSERT INTO user VALUES ('alex@alex.com','Alex','Name','Line 1 Street','Second','Townsville','Citydom','CT1 S50','password');
INSERT INTO user VALUES ('fred@fred.com','Fred','Surname','987 Lane','Here','Nowheresville','Nowhere','NO9 8RT','password');
INSERT INTO user VALUES ('sam@sam.com','Sam','Othername','123 Street','Place','Townstown','Citycity','CY3 9PL','password');

INSERT INTO showing VALUES (1, '2017-09-03', 1, 2);
INSERT INTO showing VALUES (2, '2017-11-03', 3, 3);
INSERT INTO showing VALUES (3, '2017-15-03', 4, 1);
INSERT INTO showing VALUES (4, '2017-12-03', 2, 4);

INSERT INTO booking VALUES (1, 915814235000, 'alex@alex.com', 'alex@alex.com');
INSERT INTO booking VALUES (2, 995894235000, 'sma@sam.com', 'sam@sam.com');
INSERT INTO booking VALUES (3, 985824235000, 'fred@fred.com', 'alex@alex.com');
INSERT INTO booking VALUES (3, 945884235000, 'fred@fred.com', 'alex@alex.com');


INSERT INTO ticket VALUES (1, 6.99, 'A1', 'Child', 1, 1),
INSERT INTO ticket VALUES (2, 9.99, 'A3', 'Adult', 2, 2);
INSERT INTO ticket VALUES (3, 5.99, 'F222', 'Child', 4, 2),
INSERT INTO ticket VALUES (4, 7.99, 'N7', 'Concession', 3, 4);
INSERT INTO ticket VALUES (5, 6.99, 'M15', 'Adult', 4, 4);
