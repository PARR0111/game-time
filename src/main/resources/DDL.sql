CREATE SCHEMA `game-time`;

CREATE TABLE `game-time`.`user` (
                                    `userID` int NOT NULL AUTO_INCREMENT,
                                    `email` varchar(45) NOT NULL,
                                    `username` varchar(45) NOT NULL,
                                    `password` varchar(45) NOT NULL,
                                    `is_verified` int NOT NULL,
                                    PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;