/* @author AlexNewton */
/* @editor Martyn Green */



INSERT INTO movie VALUES (1, 'Ewan McGregor, Logan Gillies', 'CLASS_18', 'After 20 years abroad, Mark Renton returns to Scotland and reunites with his old friends Sick Boy, Spud, and Begbie.', 'Drama', 118, TRUE,'T2 Trainspotting', '2017-01-31');
INSERT INTO movie VALUES (2, 'Tom Hiddleston, Samuel L. Jackson, Brie Larson', 'CLASS_12A', 'A team of scientists explore an uncharted island in the Pacific, venturing into the domain of the mighty Kong, and must fight to escape a primal Eden.', 'Action', 120, TRUE, 'King Kong: Skull Island', '2017-03-01' );
INSERT INTO movie VALUES (3, 'Hugh Jackman, Patrick Stewart', 'CLASS_15', 'In the near future, a weary Logan cares for an ailing Professor X somewhere on the Mexican border. However, Logan''s attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.', 'Adventure', 137, TRUE, 'Logan', '2017-03-03');
INSERT INTO movie VALUES (4, 'Matthew McConaughey, Reese Witherspoon', 'CLASS_PG', 'In a city of humanoid animals, a hustling theater impresario''s attempt to save his theater with a singing competition becomes grander than he anticipates even as its finalists'' find that their lives will never be the same.', 'Animation', 108, TRUE, 'Sing', '2016-11-21');
INSERT INTO movie VALUES (5, 'Andrew Garfield, Richard Pyros', 'CLASS_18', 'WWII American Army Medic Desmond T. Doss, who served during the Battle of Okinawa, refuses to kill people, and becomes the first man in American history to receive the Medal of Honor without firing a shot.', 'Biography, Drama, History', 139, TRUE, 'Hacksaw Ridge',  '2016-11-04');
INSERT INTO movie VALUES (6, 'Dakota Johnson, Jamie Dornan', 'CLASS_18', 'While Christian wrestles with his inner demons, Anastasia must confront the anger and envy of the women who came before her.', 'Drama, Romance', 118,  TRUE, '50 Shades Darker',  '2017-02-10');
INSERT INTO movie VALUES (7, 'Casey Affleck, Kyle Chandler', 'CLASS_18', 'A depressed uncle is asked to take care of his teenage nephew after the boy''s father dies.', 'Drama', 137, TRUE, 'Manchester by the Sea', '2016-12-16' );
INSERT INTO movie VALUES (8, 'Will Arnett, Rosario Dawson', 'CLASS_PG ', 'Bruce Wayne must not only deal with the criminals of Gotham City, but also the responsibility of raising a boy he adopted.', 'Animation, Action, Adventure', 104, TRUE, 'The Lego Batman Movie', '2016-12-16');
INSERT INTO movie VALUES (9, 'Keanu Reeves, Riccardo Scamarcio', 'CLASS_18', 'After returning to the criminal underworld to repay a debt, John Wick discovers that a large bounty has been put on his life.', 'Action, Crime, Thriller', 122, FALSE, 'John Wick: Chapter 2', '2017-02-10');
INSERT INTO movie VALUES (10, 'Matt Damon, Tian Jing', 'CLASS_12A', 'European mercenaries searching for black powder become embroiled in the defense of the Great Wall of China against a horde of monstrous creatures.', ' Action, Adventure, Fantasy', 103, FALSE, 'The Great Wall', '2017-02-17');
INSERT INTO movie VALUES (11, 'Mahershala Ali', 'CLASS_18', 'A chronicle of the childhood, adolescence and burgeoning adulthood of a young black man growing up in a rough neighborhood of Miami.', 'Drama', 111, FALSE, 'Moonlight', '2016-11-18');
INSERT INTO movie VALUES (12, 'Amy Adams, Jeremy Renner', 'CLASS_12A', 'When twelve mysterious spacecraft appear around the world, linguistics professor Louise Banks is tasked with interpreting the language of the apparent alien visitors.', ' Drama, Mystery, Sci-F', 116, FALSE, 'Arrival', '2016-11-11');
INSERT INTO movie VALUES (13, 'Felicity Jones, Diego Luna', 'CLASS_12A', 'The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.', 'Action, Adventure, Sci-F', 133, FALSE, 'Rogue One', '2016-12-16');
INSERT INTO movie VALUES (14, 'Dane DeHaan, Jason Isaacs', 'CLASS_12A', 'An ambitious young executive is sent to retrieve his company''s CEO from an idyllic but mysterious ''wellness center'' at a remote location in the Swiss Alps, but soon suspects that the spa''s treatments are not what they seem.', 'Drama, Fantasy, Horror ', 146, FALSE, 'A Cure for Wellness', '2017-02-17');
INSERT INTO movie VALUES (15, 'Ryan Gosling, Emma Stone', 'CLASS_12A', 'A jazz pianist falls for an aspiring actress in Los Angeles.', ' Comedy, Drama, Music', 128,  FALSE, 'La La Land', '2016-12-25');
INSERT INTO movie VALUES (16, 'Natalie Portman', 'CLASS_18', 'Following the assassination of President John F. Kennedy, First Lady Jacqueline Kennedy fights through grief and trauma to regain her faith, console her children, and define her husband''s historic legacy.', 'Biography, Drama, History', 100, FALSE, 'Jackie', '2016-12-02');

INSERT INTO screen VALUES (1, 'url'),(2, 'url'),(3, 'lol'),(4, 'abc');

INSERT INTO block VALUES( 1,180, 8, 8, 1, 'A', 0, 0, 1);
INSERT INTO block VALUES( 2,180, 8, 8, 9, 'A', 1, 0, 1);
INSERT INTO block VALUES( 3,180, 8, 8, 1, 'I', 0, 1, 1);
INSERT INTO block VALUES( 4,180, 4, 2, 1, 'C', 1, 1, 1);
INSERT INTO block VALUES( 5,180, 4, 2, 3, 'C', 0, 0, 2);
INSERT INTO block VALUES( 6,180, 4, 2, 3, 'C', 1, 0, 2);
INSERT INTO block VALUES( 7,180, 4, 2, 3, 'C', 0, 1, 2);
INSERT INTO block VALUES( 8,180, 10, 10, 11, 'K', 1, 1, 2);
INSERT INTO block VALUES( 9,180, 10, 20, 1, 'A', 0, 0, 3);
INSERT INTO block VALUES( 10,180, 10, 20, 1, 'A', 0, 0, 3);


INSERT INTO seat values (1, 1, 'A', 1, 1);
INSERT INTO seat values (2, 1, 'B', 1, 1);
INSERT INTO seat values (3, 1, 'C', 1, 1);
INSERT INTO seat values (4, 1, 'D', 1, 1);
INSERT INTO seat values (5, 1, 'E', 1, 1);
INSERT INTO seat values (6, 1, 'F', 1, 1);
INSERT INTO seat values (7, 1, 'G', 1, 1);
INSERT INTO seat values (8, 1, 'H', 1, 1);
INSERT INTO seat values (9, 2, 'A', 1, 1);
INSERT INTO seat values (10, 2, 'B', 1, 1);
INSERT INTO seat values (11, 2, 'C', 1, 1);
INSERT INTO seat values (12, 2, 'D', 1, 1);
INSERT INTO seat values (13, 2, 'E', 1, 1);
INSERT INTO seat values (14, 2, 'F', 1, 1);
INSERT INTO seat values (15, 2, 'G', 1, 1);
INSERT INTO seat values (16, 2, 'H', 1, 1);
INSERT INTO seat values (17, 3, 'A', 1, 1);
INSERT INTO seat values (18, 3, 'B', 1, 1);
INSERT INTO seat values (19, 3, 'C', 1, 1);
INSERT INTO seat values (20, 3, 'D', 1, 1);
INSERT INTO seat values (21, 3, 'E', 1, 1);
INSERT INTO seat values (22, 3, 'F', 1, 1);
INSERT INTO seat values (23, 3, 'G', 1, 1);
INSERT INTO seat values (24, 3, 'H', 1, 1);
INSERT INTO seat values (25, 4, 'A', 1, 1);
INSERT INTO seat values (26, 4, 'B', 1, 1);
INSERT INTO seat values (27, 4, 'C', 1, 1);
INSERT INTO seat values (28, 4, 'D', 1, 1);
INSERT INTO seat values (29, 4, 'E', 1, 1);
INSERT INTO seat values (30, 4, 'F', 1, 1);
INSERT INTO seat values (31, 4, 'G', 1, 1);
INSERT INTO seat values (32, 4, 'H', 1, 1);
INSERT INTO seat values (33, 5, 'A', 1, 1);
INSERT INTO seat values (34, 5, 'B', 1, 1);
INSERT INTO seat values (35, 5, 'C', 1, 1);
INSERT INTO seat values (36, 5, 'D', 1, 1);
INSERT INTO seat values (37, 5, 'E', 1, 1);
INSERT INTO seat values (38, 5, 'F', 1, 1);
INSERT INTO seat values (39, 5, 'G', 1, 1);
INSERT INTO seat values (40, 5, 'H', 1, 1);
INSERT INTO seat values (41, 6, 'A', 1, 1);
INSERT INTO seat values (42, 6, 'B', 1, 1);
INSERT INTO seat values (43, 6, 'C', 1, 1);
INSERT INTO seat values (44, 6, 'D', 1, 1);
INSERT INTO seat values (45, 6, 'E', 1, 1);
INSERT INTO seat values (46, 6, 'F', 1, 1);
INSERT INTO seat values (47, 6, 'G', 1, 1);
INSERT INTO seat values (48, 6, 'H', 1, 1);
INSERT INTO seat values (49, 7, 'A', 1, 1);
INSERT INTO seat values (50, 7, 'B', 1, 1);
INSERT INTO seat values (51, 7, 'C', 1, 1);
INSERT INTO seat values (52, 7, 'D', 1, 1);
INSERT INTO seat values (53, 7, 'E', 1, 1);
INSERT INTO seat values (54, 7, 'F', 1, 1);
INSERT INTO seat values (55, 7, 'G', 1, 1);
INSERT INTO seat values (56, 7, 'H', 1, 1);
INSERT INTO seat values (57, 8, 'A', 1, 1);
INSERT INTO seat values (58, 8, 'B', 1, 1);
INSERT INTO seat values (59, 8, 'C', 1, 1);
INSERT INTO seat values (60, 8, 'D', 1, 1);
INSERT INTO seat values (61, 8, 'E', 1, 1);
INSERT INTO seat values (62, 8, 'F', 1, 1);
INSERT INTO seat values (63, 8, 'G', 1, 1);
INSERT INTO seat values (64, 8, 'H', 1, 1);
INSERT INTO seat values (65, 9, 'A', 2, 2);
INSERT INTO seat values (66, 9, 'B', 2, 2);
INSERT INTO seat values (67, 9, 'C', 2, 2);
INSERT INTO seat values (68, 9, 'D', 2, 2);
INSERT INTO seat values (69, 9, 'E', 2, 2);
INSERT INTO seat values (70, 9, 'F', 2, 2);
INSERT INTO seat values (71, 9, 'G', 2, 2);
INSERT INTO seat values (72, 9, 'H', 2, 2);
INSERT INTO seat values (73, 10, 'A', 2, 2);
INSERT INTO seat values (74, 10, 'B', 2, 2);
INSERT INTO seat values (75, 10, 'C', 2, 2);
INSERT INTO seat values (76, 10, 'D', 2, 2);
INSERT INTO seat values (77, 10, 'E', 2, 2);
INSERT INTO seat values (78, 10, 'F', 2, 2);
INSERT INTO seat values (79, 10, 'G', 2, 2);
INSERT INTO seat values (80, 10, 'H', 2, 2);
INSERT INTO seat values (81, 11, 'A', 2, 2);
INSERT INTO seat values (82, 11, 'B', 2, 2);
INSERT INTO seat values (83, 11, 'C', 2, 2);
INSERT INTO seat values (84, 11, 'D', 2, 2);
INSERT INTO seat values (85, 11, 'E', 2, 2);
INSERT INTO seat values (86, 11, 'F', 2, 2);
INSERT INTO seat values (87, 11, 'G', 2, 2);
INSERT INTO seat values (88, 11, 'H', 2, 2);
INSERT INTO seat values (89, 12, 'A', 2, 2);
INSERT INTO seat values (90, 12, 'B', 2, 2);
INSERT INTO seat values (91, 12, 'C', 2, 2);
INSERT INTO seat values (92, 12, 'D', 2, 2);
INSERT INTO seat values (93, 12, 'E', 2, 2);
INSERT INTO seat values (94, 12, 'F', 2, 2);
INSERT INTO seat values (95, 12, 'G', 2, 2);
INSERT INTO seat values (96, 12, 'H', 2, 2);
INSERT INTO seat values (97, 13, 'A', 2, 2);
INSERT INTO seat values (98, 13, 'B', 2, 2);
INSERT INTO seat values (99, 13, 'C', 2, 2);
INSERT INTO seat values (100, 13, 'D', 2, 2);
INSERT INTO seat values (101, 13, 'E', 2, 2);
INSERT INTO seat values (102, 13, 'F', 2, 2);
INSERT INTO seat values (103, 13, 'G', 2, 2);
INSERT INTO seat values (104, 13, 'H', 2, 2);
INSERT INTO seat values (105, 14, 'A', 2, 2);
INSERT INTO seat values (106, 14, 'B', 2, 2);
INSERT INTO seat values (107, 14, 'C', 2, 2);
INSERT INTO seat values (108, 14, 'D', 2, 2);
INSERT INTO seat values (109, 14, 'E', 2, 2);
INSERT INTO seat values (110, 14, 'F', 2, 2);
INSERT INTO seat values (111, 14, 'G', 2, 2);
INSERT INTO seat values (112, 14, 'H', 2, 2);
INSERT INTO seat values (113, 15, 'A', 2, 2);
INSERT INTO seat values (114, 15, 'B', 2, 2);
INSERT INTO seat values (115, 15, 'C', 2, 2);
INSERT INTO seat values (116, 15, 'D', 2, 2);
INSERT INTO seat values (117, 15, 'E', 2, 2);
INSERT INTO seat values (118, 15, 'F', 2, 2);
INSERT INTO seat values (119, 15, 'G', 2, 2);
INSERT INTO seat values (120, 15, 'H', 2, 2);
INSERT INTO seat values (121, 16, 'A', 2, 2);
INSERT INTO seat values (122, 16, 'B', 2, 2);
INSERT INTO seat values (123, 16, 'C', 2, 2);
INSERT INTO seat values (124, 16, 'D', 2, 2);
INSERT INTO seat values (125, 16, 'E', 2, 2);
INSERT INTO seat values (126, 16, 'F', 2, 2);
INSERT INTO seat values (127, 16, 'G', 2, 2);
INSERT INTO seat values (128, 16, 'H', 2, 2);
INSERT INTO seat values (129, 9, 'I', 2, 3);
INSERT INTO seat values (130, 9, 'J', 2, 3);
INSERT INTO seat values (131, 9, 'K', 2, 3);
INSERT INTO seat values (132, 9, 'L', 2, 3);
INSERT INTO seat values (133, 9, 'M', 2, 3);
INSERT INTO seat values (134, 9, 'N', 2, 3);
INSERT INTO seat values (135, 9, 'O', 2, 3);
INSERT INTO seat values (136, 9, 'P', 2, 3);
INSERT INTO seat values (137, 10, 'I', 2, 3);
INSERT INTO seat values (138, 10, 'J', 2, 3);
INSERT INTO seat values (139, 10, 'K', 2, 3);
INSERT INTO seat values (140, 10, 'L', 2, 3);
INSERT INTO seat values (141, 10, 'M', 2, 3);
INSERT INTO seat values (142, 10, 'N', 2, 3);
INSERT INTO seat values (143, 10, 'O', 2, 3);
INSERT INTO seat values (144, 10, 'P', 2, 3);
INSERT INTO seat values (145, 11, 'I', 2, 3);
INSERT INTO seat values (146, 11, 'J', 2, 3);
INSERT INTO seat values (147, 11, 'K', 2, 3);
INSERT INTO seat values (148, 11, 'L', 2, 3);
INSERT INTO seat values (149, 11, 'M', 2, 3);
INSERT INTO seat values (150, 11, 'N', 2, 3);
INSERT INTO seat values (151, 11, 'O', 2, 3);
INSERT INTO seat values (152, 11, 'P', 2, 3);
INSERT INTO seat values (153, 12, 'I', 2, 3);
INSERT INTO seat values (154, 12, 'J', 2, 3);
INSERT INTO seat values (155, 12, 'K', 2, 3);
INSERT INTO seat values (156, 12, 'L', 2, 3);
INSERT INTO seat values (157, 12, 'M', 2, 3);
INSERT INTO seat values (158, 12, 'N', 2, 3);
INSERT INTO seat values (159, 12, 'O', 2, 3);
INSERT INTO seat values (160, 12, 'P', 2, 3);
INSERT INTO seat values (161, 13, 'I', 2, 3);
INSERT INTO seat values (162, 13, 'J', 2, 3);
INSERT INTO seat values (163, 13, 'K', 2, 3);
INSERT INTO seat values (164, 13, 'L', 2, 3);
INSERT INTO seat values (165, 13, 'M', 2, 3);
INSERT INTO seat values (166, 13, 'N', 2, 3);
INSERT INTO seat values (167, 13, 'O', 2, 3);
INSERT INTO seat values (168, 13, 'P', 2, 3);
INSERT INTO seat values (169, 14, 'I', 2, 3);
INSERT INTO seat values (170, 14, 'J', 2, 3);
INSERT INTO seat values (171, 14, 'K', 2, 3);
INSERT INTO seat values (172, 14, 'L', 2, 3);
INSERT INTO seat values (173, 14, 'M', 2, 3);
INSERT INTO seat values (174, 14, 'N', 2, 3);
INSERT INTO seat values (175, 14, 'O', 2, 3);
INSERT INTO seat values (176, 14, 'P', 2, 3);
INSERT INTO seat values (177, 15, 'I', 2, 3);
INSERT INTO seat values (178, 15, 'J', 2, 3);
INSERT INTO seat values (179, 15, 'K', 2, 3);
INSERT INTO seat values (180, 15, 'L', 2, 3);
INSERT INTO seat values (181, 15, 'M', 2, 3);
INSERT INTO seat values (182, 15, 'N', 2, 3);
INSERT INTO seat values (183, 15, 'O', 2, 3);
INSERT INTO seat values (184, 15, 'P', 2, 3);
INSERT INTO seat values (185, 16, 'I', 2, 3);
INSERT INTO seat values (186, 16, 'J', 2, 3);
INSERT INTO seat values (187, 16, 'K', 2, 3);
INSERT INTO seat values (188, 16, 'L', 2, 3);
INSERT INTO seat values (189, 16, 'M', 2, 3);
INSERT INTO seat values (190, 16, 'N', 2, 3);
INSERT INTO seat values (191, 16, 'O', 2, 3);
INSERT INTO seat values (192, 16, 'P', 2, 3);
INSERT INTO seat values (193, 1, 'C', 2, 4);
INSERT INTO seat values (194, 2, 'C', 2, 4);
INSERT INTO seat values (195, 3, 'C', 2, 4);
INSERT INTO seat values (196, 4, 'C', 2, 4);
INSERT INTO seat values (197, 1, 'D', 2, 4);
INSERT INTO seat values (198, 2, 'D', 2, 4);
INSERT INTO seat values (199, 3, 'D', 2, 4);
INSERT INTO seat values (200, 4, 'D', 2, 4);
INSERT INTO seat values (201, 5, 'C', 2, 5);
INSERT INTO seat values (202, 6, 'C', 2, 5);
INSERT INTO seat values (203, 3, 'C', 2, 5);
INSERT INTO seat values (204, 4, 'C', 2, 5);
INSERT INTO seat values (205, 5, 'D', 2, 5);
INSERT INTO seat values (206, 6, 'D', 2, 5);
INSERT INTO seat values (207, 3, 'D', 2, 5);
INSERT INTO seat values (208, 4, 'D', 2, 5);
INSERT INTO seat values (209, 5, 'C', 2, 6);
INSERT INTO seat values (300, 6, 'C', 2, 6);
INSERT INTO seat values (301, 3, 'C', 2, 6);
INSERT INTO seat values (302, 4, 'C', 2, 6);
INSERT INTO seat values (303, 5, 'D', 2, 6);
INSERT INTO seat values (304, 6, 'D', 2, 6);
INSERT INTO seat values (305, 3, 'D', 2, 6);
INSERT INTO seat values (306, 4, 'D', 2, 6);
INSERT INTO seat values (307, 5, 'C', 2, 7);
INSERT INTO seat values (308, 6, 'C', 2, 7);
INSERT INTO seat values (309, 3, 'C', 2, 7);
INSERT INTO seat values (310, 4, 'C', 2, 7);
INSERT INTO seat values (311, 5, 'D', 2, 7);
INSERT INTO seat values (312, 6, 'D', 2, 7);
INSERT INTO seat values (313, 3, 'D', 2, 7);
INSERT INTO seat values (314, 4, 'D', 2, 7);



INSERT INTO media VALUES (1, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTU2NTA0NDM0MF5BMl5BanBnXkFtZTgwMDMzMTQzMTI@._V1_SY1000_CR0,0,666,1000_AL_.jpg', 1);
INSERT INTO media VALUES (2, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwMzI5ODEwNF5BMl5BanBnXkFtZTgwNjAzNjI2MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 2);
INSERT INTO media VALUES (3, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SY1000_CR0,0,676,1000_AL_.jpg', 3);
INSERT INTO media VALUES (4, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYzODYzODU2Ml5BMl5BanBnXkFtZTgwNTc1MTA2NzE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 4);
INSERT INTO media VALUES (5, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_SY1000_CR0,0,647,1000_AL_.jpg', 5);
INSERT INTO media VALUES (6, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ5NTk0Njg2N15BMl5BanBnXkFtZTgwNzk5Nzk3MDI@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 6);
INSERT INTO media VALUES (7, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMjk0NDg4Ml5BMl5BanBnXkFtZTgwODcyNjA5OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 7);
INSERT INTO media VALUES (8, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 8);
INSERT INTO media VALUES (9, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjE2NDkxNTY2M15BMl5BanBnXkFtZTgwMDc2NzE0MTI@._V1_SY1000_CR0,0,648,1000_AL_.jpg', 9);
INSERT INTO media VALUES (10, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3MjAzOTQxNF5BMl5BanBnXkFtZTgwOTc5OTY1OTE@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 10);
INSERT INTO media VALUES (11, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzQxNTIyODAxMV5BMl5BanBnXkFtZTgwNzQyMDA3OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 11);
INSERT INTO media VALUES (12, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTExMzU0ODcxNDheQTJeQWpwZ15BbWU4MDE1OTI4MzAy._V1_SY1000_CR0,0,640,1000_AL_.jpg', 12);
INSERT INTO media VALUES (13, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjEwMzMxODIzOV5BMl5BanBnXkFtZTgwNzg3OTAzMDI@._V1_SY1000_SX675_AL_.jpg', 13);
INSERT INTO media VALUES (14, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTg5Njg1MzIwNl5BMl5BanBnXkFtZTgwNDU1NjczMDI@._V1_SY1000_SX675_AL_.jpg', 14);
INSERT INTO media VALUES (15, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg', 15);
INSERT INTO media VALUES (16, 'POSTER', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMzg4MjYzNjk5N15BMl5BanBnXkFtZTgwODgwODI3MDI@._V1_SY1000_SX675_AL_.jpg', 16);

INSERT INTO media VALUES (17, 'TRAILER', 'https://www.youtube.com/embed/EsozpEE543w', 1);
INSERT INTO media VALUES (18, 'TRAILER', 'https://www.youtube.com/embed/44LdLqgOpjo', 2);
INSERT INTO media VALUES (19, 'TRAILER', 'https://www.youtube.com/embed/Div0iP65aZo', 3);
INSERT INTO media VALUES (20, 'TRAILER', 'https://www.youtube.com/embed/RYHBD9RF2dk', 4);

INSERT INTO showing VALUES (01,1490000400000,1,1);
INSERT INTO showing VALUES (02,1490011200000,1,1);
INSERT INTO showing VALUES (03,1490022000000,1,1);
INSERT INTO showing VALUES (04,1490032800000,1,1);
INSERT INTO showing VALUES (05,1490043600000,1,1);
INSERT INTO showing VALUES (06,1490054400000,1,1);
INSERT INTO showing VALUES (07,1490086800000,1,1);
INSERT INTO showing VALUES (08,1490097600000,1,1);
INSERT INTO showing VALUES (09,1490108400000,1,1);
INSERT INTO showing VALUES (10,1490119200000,1,1);
INSERT INTO showing VALUES (11,1490130000000,1,1);
INSERT INTO showing VALUES (12,1490140800000,2,2);
INSERT INTO showing VALUES (13,1490000400000,2,2);
INSERT INTO showing VALUES (14,1490011200000,2,2);
INSERT INTO showing VALUES (15,1490022000000,2,2);
INSERT INTO showing VALUES (16,1490032800000,2,2);
INSERT INTO showing VALUES (17,1490043600000,2,2);
INSERT INTO showing VALUES (18,1490054400000,2,2);
INSERT INTO showing VALUES (19,1490086800000,2,2);
INSERT INTO showing VALUES (20,1490097600000,2,2);
INSERT INTO showing VALUES (21,1490108400000,2,2);
INSERT INTO showing VALUES (22,1490119200000,2,2);
INSERT INTO showing VALUES (23,1490130000000,3,3);
INSERT INTO showing VALUES (24,1490140800000,3,3);
INSERT INTO showing VALUES (25,1490000400000,3,3);
INSERT INTO showing VALUES (26,1490011200000,3,3);
INSERT INTO showing VALUES (27,1490022000000,3,3);
INSERT INTO showing VALUES (28,1490032800000,3,3);
INSERT INTO showing VALUES (29,1490043600000,3,3);
INSERT INTO showing VALUES (30,1490054400000,3,3);
INSERT INTO showing VALUES (31,1490086800000,3,3);
INSERT INTO showing VALUES (32,1490097600000,3,3);
INSERT INTO showing VALUES (33,1490108400000,3,3);

INSERT INTO booking VALUES (1,1488887075419,'Jan@Newton.com','Jan@Newton.com');
INSERT INTO booking VALUES (2,1489498268947,'Jim@Surname.com','Jim@Surname.com');
INSERT INTO booking VALUES (3,1489138622572,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (4,1488686880389,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (5,1488945104008,'Bob@Blue.com','Bob@Blue.com');
INSERT INTO booking VALUES (6,1489531453500,'James@Lamkin.com','James@Lamkin.com');
INSERT INTO booking VALUES (7,1489094850907,'Mary@Green.com','Mary@Green.com');
INSERT INTO booking VALUES (8,1488891205352,'Mary@Green.com','Mary@Green.com');
INSERT INTO booking VALUES (9,1488819823601,'Sam@jackson.com','Sam@jackson.com');
INSERT INTO booking VALUES (10,1488836050979,'Carl@Jarvis.com','Carl@Jarvis.com');
INSERT INTO booking VALUES (11,1489007492048,'Bob@Newton.com','Bob@Newton.com');
INSERT INTO booking VALUES (12,1489375695387,'James@Lamkin.com','James@Lamkin.com');
INSERT INTO booking VALUES (13,1489061893959,'Martyn@jackson.com','Martyn@jackson.com');
INSERT INTO booking VALUES (14,1488875680086,'Martyn@jackson.com','Martyn@jackson.com');
INSERT INTO booking VALUES (15,1488835199574,'Carl@Surname.com','Carl@Surname.com');
INSERT INTO booking VALUES (16,1489051031481,'Fred@Surname.com','Fred@Surname.com');
INSERT INTO booking VALUES (17,1489322222669,'Jan@Newton.com','Jan@Newton.com');
INSERT INTO booking VALUES (18,1489357727473,'Hary@Lamkin.com','Hary@Lamkin.com');
INSERT INTO booking VALUES (19,1489345012022,'Fred@Jarvis.com','Fred@Jarvis.com');
INSERT INTO booking VALUES (20,1489359266641,'Sue@Blue.com','Sue@Blue.com');
INSERT INTO booking VALUES (21,1488663839690,'Hary@Lamkin.com','Hary@Lamkin.com');
INSERT INTO booking VALUES (22,1489116444139,'Jim@Newton.com','Jim@Newton.com');
INSERT INTO booking VALUES (23,1488776662632,'Bob@Newton.com','Bob@Newton.com');
INSERT INTO booking VALUES (24,1488783878977,'Steve@Jarvis.com','Steve@Jarvis.com');
INSERT INTO booking VALUES (25,1488792694375,'James@Green.com','James@Green.com');
INSERT INTO booking VALUES (26,1489119745858,'Hary@Lamkin.com','Hary@Lamkin.com');
INSERT INTO booking VALUES (27,1488863447209,'Fred@Surname.com','Fred@Surname.com');
INSERT INTO booking VALUES (28,1489043533149,'Bob@Newton.com','Bob@Newton.com');
INSERT INTO booking VALUES (29,1488554747931,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (30,1488837329177,'Mary@Green.com','Mary@Green.com');
INSERT INTO booking VALUES (31,1488546227803,'Alex@Newton.com','Alex@Newton.com');
INSERT INTO booking VALUES (32,1489509265577,'Fred@Jarvis.com','Fred@Jarvis.com');
INSERT INTO booking VALUES (33,1488338780967,'James@Lamkin.com','James@Lamkin.com');
INSERT INTO booking VALUES (34,1489209639190,'Sue@Blue.com','Sue@Blue.com');
INSERT INTO booking VALUES (35,1489176220542,'Alex@Newton.com','Alex@Newton.com');
INSERT INTO booking VALUES (36,1489284151028,'Jim@Newton.com','Jim@Newton.com');
INSERT INTO booking VALUES (37,1489279924146,'Martyn@Green.com','Martyn@Green.com');
INSERT INTO booking VALUES (38,1488477034174,'Sam@jackson.com','Sam@jackson.com');
INSERT INTO booking VALUES (39,1489198115749,'Bob@Newton.com','Bob@Newton.com');
INSERT INTO booking VALUES (40,1489198983450,'Carl@Surname.com','Carl@Surname.com');
INSERT INTO booking VALUES (41,1488360629327,'Fred@Surname.com','Fred@Surname.com');
INSERT INTO booking VALUES (42,1489010804297,'Bob@Blue.com','Bob@Blue.com');
INSERT INTO booking VALUES (43,1488874274479,'Fred@Surname.com','Fred@Surname.com');
INSERT INTO booking VALUES (44,1488512791125,'Sam@Lamkin.com','Sam@Lamkin.com');
INSERT INTO booking VALUES (45,1488893979569,'Jan@Newton.com','Jan@Newton.com');
INSERT INTO booking VALUES (46,1489379298469,'Steve@Jarvis.com','Steve@Jarvis.com');
INSERT INTO booking VALUES (47,1488491090220,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (48,1489518542224,'Sam@Jarvis.com','Sam@Jarvis.com');
INSERT INTO booking VALUES (49,1489502625926,'Sam@Jarvis.com','Sam@Jarvis.com');
INSERT INTO booking VALUES (50,1488344657123,'Bob@Newton.com','Bob@Newton.com');
INSERT INTO booking VALUES (51,1488725697080,'Martyn@Green.com','Martyn@Green.com');
INSERT INTO booking VALUES (52,1489525831902,'James@Green.com','James@Green.com');
INSERT INTO booking VALUES (53,1489393693132,'Carl@Surname.com','Carl@Surname.com');
INSERT INTO booking VALUES (54,1489204160315,'Bob@Blue.com','Bob@Blue.com');
INSERT INTO booking VALUES (55,1488470780058,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (56,1489311585929,'Jim@Newton.com','Jim@Newton.com');
INSERT INTO booking VALUES (57,1488906853277,'Carl@Surname.com','Carl@Surname.com');
INSERT INTO booking VALUES (58,1489453250739,'Sam@Blue.com','Sam@Blue.com');
INSERT INTO booking VALUES (59,1489585797432,'Martyn@Green.com','Martyn@Green.com');
INSERT INTO booking VALUES (60,1489261667303,'James@Lamkin.com','James@Lamkin.com');
INSERT INTO booking VALUES (61,1488766028094,'Steve@Jarvis.com','Steve@Jarvis.com');
INSERT INTO booking VALUES (62,1489370335848,'Fred@Jarvis.com','Fred@Jarvis.com');
INSERT INTO booking VALUES (63,1488438396836,'Jim@Newton.com','Jim@Newton.com');
INSERT INTO booking VALUES (64,1488487788171,'James@Green.com','James@Green.com');
INSERT INTO booking VALUES (65,1488518459268,'Lisa@jackson.com','Lisa@jackson.com');
INSERT INTO booking VALUES (66,1488414815085,'Alex@Newton.com','Alex@Newton.com');
INSERT INTO booking VALUES (67,1489237916929,'Bob@Blue.com','Bob@Blue.com');
INSERT INTO booking VALUES (68,1489336351446,'Sue@Blue.com','Sue@Blue.com');
INSERT INTO booking VALUES (69,1489281256072,'Alex@Surname.com','Alex@Surname.com');
INSERT INTO booking VALUES (70,1488625450684,'Jan@Newton.com','Jan@Newton.com');


INSERT INTO ticket VALUES (1,12.99,'PREMIUM',117,1,1);
INSERT INTO ticket VALUES (2,7.49,'CONCESSION',45,2,2);
INSERT INTO ticket VALUES (3,7.49,'CONCESSION',200,2,3);
INSERT INTO ticket VALUES (4,7.49,'CONCESSION',208,2,3);
INSERT INTO ticket VALUES (5,5.99,'CHILD',3,3,4);
INSERT INTO ticket VALUES (6,9.99,'ADULT',50,3,5);
INSERT INTO ticket VALUES (7,9.99,'ADULT',58,3,5);
INSERT INTO ticket VALUES (8,9.99,'ADULT',251,4,6);
INSERT INTO ticket VALUES (9,5.99,'CHILD',127,4,7);
INSERT INTO ticket VALUES (10,5.99,'CHILD',135,4,7);
INSERT INTO ticket VALUES (11,12.99,'PREMIUM',69,5,8);
INSERT INTO ticket VALUES (17,7.49,'CONCESSION',115,7,12);
INSERT INTO ticket VALUES (18,12.99,'PREMIUM',152,7,13);
INSERT INTO ticket VALUES (19,12.99,'PREMIUM',160,7,13);
INSERT INTO ticket VALUES (21,7.49,'CONCESSION',199,8,15);
INSERT INTO ticket VALUES (23,7.49,'CONCESSION',125,9,16);
INSERT INTO ticket VALUES (24,5.99,'CHILD',30,9,17);
INSERT INTO ticket VALUES (25,5.99,'CHILD',38,9,17);
INSERT INTO ticket VALUES (26,12.99,'PREMIUM',151,10,18);
INSERT INTO ticket VALUES (27,7.49,'CONCESSION',172,10,19);
INSERT INTO ticket VALUES (28,7.49,'CONCESSION',180,10,19);
INSERT INTO ticket VALUES (30,5.99,'CHILD',59,11,21);
INSERT INTO ticket VALUES (31,5.99,'CHILD',67,11,21);


INSERT INTO user VALUES('Alex@Newton.com','Alex','Newton','1 Street','Second','Townsville','Citydom','CT8 6SE','password');
INSERT INTO user VALUES('Fred@Surname.com','Fred','Surname','987 Lane','Here','Nowheresville','Nowhere','NN9 5HE','password');
INSERT INTO user VALUES('Sam@Jarvis.com','Sam','Jarvis','123 Street','Place','Townstown','Citycity','CT9 2PL','password');
INSERT INTO user VALUES('James@Lamkin.com','James','Lamkin','The House',' 1 Street','Townsville','Citydom','CT14 6 1','password');
INSERT INTO user VALUES('Martyn@Green.com','Martyn','Green','123 Lane','Here','Nowheresville','Nowhere','NN10 5HE','password');
INSERT INTO user VALUES('Sam@jackson.com','Sam','jackson','19 Street Lane','Place','Townstown','Citycity','CT9 0PL','password');
INSERT INTO user VALUES('Bob@Blue.com','Bob','Blue','15 House Lane','Town','City','City','CC6 2TO','password');
INSERT INTO user VALUES('Jim@Newton.com','Jim','Newton','51 Street','Second','Townsville','Citydom','CT19 0SE','password');
INSERT INTO user VALUES('Carl@Surname.com','Carl','Surname','8987 Lane','Here','Nowheresville','Nowhere','NN13 4HE','password');
INSERT INTO user VALUES('Steve@Jarvis.com','Steve','Jarvis','5123 Street','Place','Townstown','Citycity','CT19 2PL','password');
INSERT INTO user VALUES('Hary@Lamkin.com','Hary','Lamkin','5The House',' 1 Street','Townsville','Citydom','CT3 1 1','password');
INSERT INTO user VALUES('Mary@Green.com','Mary','Green','8123 Lane','Here','Nowheresville','Nowhere','NN3 7HE','password');
INSERT INTO user VALUES('Lisa@jackson.com','Lisa','jackson','419 Street Lane','Place','Townstown','Citycity','CT12 1PL','password');
INSERT INTO user VALUES('Sue@Blue.com','Sue','Blue','715 House Lane','Town','City','City','CC15 6TO','password');
INSERT INTO user VALUES('Jan@Newton.com','Jan','Newton','451 Street','Second','Townsville','Citydom','CT8 5SE','password');
INSERT INTO user VALUES('Alex@Surname.com','Alex','Surname','98987 Lane','Here','Nowheresville','Nowhere','NN6 1HE','password');
INSERT INTO user VALUES('Fred@Jarvis.com','Fred','Jarvis','65123 Street','Place','Townstown','Citycity','CT3 0PL','password');
INSERT INTO user VALUES('Sam@Lamkin.com','Sam','Lamkin','55The House',' 1 Street','Townsville','Citydom','CT14 5 1','password');
INSERT INTO user VALUES('James@Green.com','James','Green','58123 Lane','Here','Nowheresville','Nowhere','NN1 8HE','password');
INSERT INTO user VALUES('Martyn@jackson.com','Martyn','jackson','5419 Street Lane','Place','Townstown','Citycity','CT15 3PL','password');
INSERT INTO user VALUES('Sam@Blue.com','Sam','Blue','5715 House Lane','Town','City','City','CC3 0TO','password');
INSERT INTO user VALUES('Bob@Newton.com','Bob','Newton','5451 Street','Second','Townsville','Citydom','CT11 3SE','password');
INSERT INTO user VALUES('Jim@Surname.com','Jim','Surname','698987 Lane','Here','Nowheresville','Nowhere','NN5 3HE','password');
INSERT INTO user VALUES('Carl@Jarvis.com','Carl','Jarvis','165123 Street','Place','Townstown','Citycity','CT1 0PL','password');
