CREATE TABLE `citizens` (
  `id` int NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_no` varchar(10) NOT NULL,
  `gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1001,'Pinakin Patel','1980-05-26','2/5 Heerabagh Flats, Near Narayan Singh Circle','drpinakinp@gmail.com','9829837874','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1002,'Uttam Patel','2011-08-23','2/5 Heerabagh Flats','uttampatel0811@gmail.com','7976694711','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1003,'Ketan Patel','1978-06-13','B-507 Dwarika Apartment','ketan.neel@gmail.com','9829837874','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1004,'Megha Patel','1977-05-21','Ghiya Hospital','megha.patel@gmail.com','8824638881','Female');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1005,'Ghanshyam','1999-08-19','New Address','ghanu@gmail.com','9601290900','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1006,'Maharaj','2011-08-23','khambhat','maharaj@gmail.com','9873537463','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1007,'Varniraj','2000-06-16','Vadodara','varni@gmail.com','9601290987','Male');
INSERT INTO `citizens` (`id`,`name`,`dob`,`address`,`email_id`,`mobile_no`,`gender`) VALUES (1008,'Tapu','2012-09-23','Akshar Dham','ghanu@gmail.com','9602345671','Male');

