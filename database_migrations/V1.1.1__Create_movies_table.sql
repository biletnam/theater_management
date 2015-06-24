 CREATE TABLE `movies` (
  `movies_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NULL,
  `description` VARCHAR(120) NULL,
  PRIMARY KEY (`movies_id`));
