/* @author AlexNewton */

INSERT INTO movie VALUES (1, 'Ewan McGregor, Logan Gillies', '18', 'After 20 years abroad, Mark Renton returns to Scotland and reunites with his old friends Sick Boy, Spud, and Begbie.', 'Drama', 118, 'T2 Trainspotting', '2017-01-31');
INSERT INTO movie VALUES (2, 'Tom Hiddleston, Samuel L. Jackson, Brie Larson', '12A', 'A team of scientists explore an uncharted island in the Pacific, venturing into the domain of the mighty Kong, and must fight to escape a primal Eden.', 'Action', 120, 'Donkey Kong: Skull Island', '2017-03-01');
INSERT INTO movie VALUES (3, 'Hugh Jackman, Patrick Stewart', '15', 'In the near future, a weary Logan cares for an ailing Professor X somewhere on the Mexican border. However, Logan''s attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.', 'Adventure', 137, 'Logan', '2017-03-03');
INSERT INTO movie VALUES (4, 'Matthew McConaughey, Reese Witherspoon', 'PG', 'In a city of humanoid animals, a hustling theater impresario''s attempt to save his theater with a singing competition becomes grander than he anticipates even as its finalists'' find that their lives will never be the same.', 'Animation', 108, 'Sing', '2016-11-21');
INSERT INTO movie VALUES (5, 'Andrew Garfield, Richard Pyros', '18', 'WWII American Army Medic Desmond T. Doss, who served during the Battle of Okinawa, refuses to kill people, and becomes the first man in American history to receive the Medal of Honor without firing a shot.', 'Biography, Drama, History', 139, 'Hacksaw Ridge',  '2016-11-04');
INSERT INTO movie VALUES (6, 'Dakota Johnson, Jamie Dornan', '18', 'While Christian wrestles with his inner demons, Anastasia must confront the anger and envy of the women who came before her.', 'Drama, Romance', 118, '50 Shades Shitter',  '2017-02-10');
INSERT INTO movie VALUES (7, 'Casey Affleck, Kyle Chandler', '18', 'A depressed uncle is asked to take care of his teenage nephew after the boy''s father dies.', 'Drama', 137, 'Manchester by the Sea', '2016-12-16');
INSERT INTO movie VALUES (8, 'Will Arnett, Rosario Dawson', 'PG ', 'Bruce Wayne must not only deal with the criminals of Gotham City, but also the responsibility of raising a boy he adopted.', 'Animation, Action, Adventure', 104, 'The Lego Batman Movie', '2016-12-16');
INSERT INTO movie VALUES (9, 'Keanu Reeves, Riccardo Scamarcio', '18', 'After returning to the criminal underworld to repay a debt, John Wick discovers that a large bounty has been put on his life.', 'Action, Crime, Thriller', 122, 'John Wick: Chapter 2', '2017-02-10');
INSERT INTO movie VALUES (10, 'Matt Damon, Tian Jing', '12A', 'European mercenaries searching for black powder become embroiled in the defense of the Great Wall of China against a horde of monstrous creatures.', ' Action, Adventure, Fantasy', 103, 'The Great Wall', '2017-02-17');
INSERT INTO movie VALUES (11, 'Mahershala Ali', '18', 'A chronicle of the childhood, adolescence and burgeoning adulthood of a young black man growing up in a rough neighborhood of Miami.', 'Drama', 111, 'Moonlight', '2016-11-18');
INSERT INTO movie VALUES (12, 'Amy Adams, Jeremy Renner', '12A', 'When twelve mysterious spacecraft appear around the world, linguistics professor Louise Banks is tasked with interpreting the language of the apparent alien visitors.', ' Drama, Mystery, Sci-F', 116, 'Arrival', '2016-11-11');
INSERT INTO movie VALUES (13, 'Felicity Jones, Diego Luna', '12A', 'The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.', 'Action, Adventure, Sci-F', 133, 'Rogue One', '2016-12-16');
INSERT INTO movie VALUES (14, 'Dane DeHaan, Jason Isaacs', '12A', 'An ambitious young executive is sent to retrieve his company''s CEO from an idyllic but mysterious ''wellness center'' at a remote location in the Swiss Alps, but soon suspects that the spa''s treatments are not what they seem.', 'Drama, Fantasy, Horror ', 146, 'A Cure for Wellness', '2017-02-17');
INSERT INTO movie VALUES (15, 'Ryan Gosling, Emma Stone', '12A', 'A jazz pianist falls for an aspiring actress in Los Angeles.', ' Comedy, Drama, Music', 128, 'La La Land', '2016-12-25');
INSERT INTO movie VALUES (16, 'Natalie Portman', '18', 'Following the assassination of President John F. Kennedy, First Lady Jacqueline Kennedy fights through grief and trauma to regain her faith, console her children, and define her husband''s historic legacy.', 'Biography, Drama, History', 100, 'Jackie', '2016-12-02');

INSERT INTO screen VALUES (1, 'url'),(2, 'url'),(3, 'lol'),(4, 'abc');

INSERT INTO block VALUES( 1, 34, 3, 5, 6, 7, 5, 1, 2);
INSERT INTO block VALUES( 2, 34, 3, 5, 6, 3, 5, 2, 1);
INSERT INTO block VALUES( 3, 34, 3, 5, 6, 5, 5, 3, 1);
INSERT INTO block VALUES( 4, 34, 3, 5, 6, 8, 5, 3, 2);
INSERT INTO block VALUES( 5, 34, 3, 5, 6, 10, 5, 2, 3);

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
INSERT INTO booking VALUES (4, 945884235000, 'fred@fred.com', 'alex@alex.com');

INSERT INTO seat values (1, 2, 7, 1);
INSERT INTO seat values (2, 3, 7, 1);
INSERT INTO seat values (3, 2, 7, 2);
INSERT INTO seat values (4, 1, 7, 2);
INSERT INTO seat values (5, 1, 7, 0);


INSERT INTO ticket VALUES (1, 1, 6.99, 'Child', 1, 1);
INSERT INTO ticket VALUES (2, 1, 9.99, 'Adult', 2, 2);
INSERT INTO ticket VALUES (3, 2, 5.99, 'Child', 3, 4);
INSERT INTO ticket VALUES (4, 2, 7.99, 'Concession',3, 3);
INSERT INTO ticket VALUES (5, 3, 6.99, 'Adult', 4, 4);


/*MediaType:
    0 - POSTER
    1 - TRAILER
    2 - IMAGE
    3 - OFFER*/
INSERT INTO media VALUES (1, 1, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU2NTA0NDM0MF5BMl5BanBnXkFtZTgwMDMzMTQzMTI@._V1_SY1000_CR0,0,666,1000_AL_.jpg');
INSERT INTO media VALUES (2, 2, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwMzI5ODEwNF5BMl5BanBnXkFtZTgwNjAzNjI2MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg');
INSERT INTO media VALUES (3, 3, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SY1000_CR0,0,676,1000_AL_.jpg');
INSERT INTO media VALUES (4, 4, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYzODYzODU2Ml5BMl5BanBnXkFtZTgwNTc1MTA2NzE@._V1_SY1000_CR0,0,674,1000_AL_.jpg');
INSERT INTO media VALUES (5, 5, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_SY1000_CR0,0,647,1000_AL_.jpg');
INSERT INTO media VALUES (6, 6, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ5NTk0Njg2N15BMl5BanBnXkFtZTgwNzk5Nzk3MDI@._V1_SY1000_CR0,0,631,1000_AL_.jpg');
INSERT INTO media VALUES (7, 7, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMjk0NDg4Ml5BMl5BanBnXkFtZTgwODcyNjA5OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg');
INSERT INTO media VALUES (8, 8, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg');
INSERT INTO media VALUES (9, 9, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE2NDkxNTY2M15BMl5BanBnXkFtZTgwMDc2NzE0MTI@._V1_SY1000_CR0,0,648,1000_AL_.jpg');
INSERT INTO media VALUES (10, 10, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3MjAzOTQxNF5BMl5BanBnXkFtZTgwOTc5OTY1OTE@._V1_SY1000_CR0,0,631,1000_AL_.jpg');
INSERT INTO media VALUES (11, 11, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzQxNTIyODAxMV5BMl5BanBnXkFtZTgwNzQyMDA3OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg');
INSERT INTO media VALUES (12, 12, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTExMzU0ODcxNDheQTJeQWpwZ15BbWU4MDE1OTI4MzAy._V1_SY1000_CR0,0,640,1000_AL_.jpg');
INSERT INTO media VALUES (13, 13, 0, 'amazon.com/images/M/MV5BMjEwMzMxODIzOV5BMl5BanBnXkFtZTgwNzg3OTAzMDI@._V1_SY1000_SX675_AL_.jpg');
INSERT INTO media VALUES (14, 14, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTg5Njg1MzIwNl5BMl5BanBnXkFtZTgwNDU1NjczMDI@._V1_SY1000_SX675_AL_.jpg');
INSERT INTO media VALUES (15, 15, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg');
INSERT INTO media VALUES (16, 16, 0, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzg4MjYzNjk5N15BMl5BanBnXkFtZTgwODgwODI3MDI@._V1_SY1000_SX675_AL_.jpg');
