 CREATE TABLE `movies_theater` (
  `reserved_seats` INT NULL,
  `movie_time` DATETIME NULL,
  `theater_id` INT NOT NULL,
  `movies_id` INT NOT NULL,
  `movies_theater_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CONSTRAINT `movies_id_constraint`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `theater_id_constraint`
    FOREIGN KEY (`theater_id`)
    REFERENCES `theater` (`theater_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
