
CREATE TABLE `reservations` (
  `reservation_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` INT NULL,
  `movies_theater_id` INT NULL,
  `seats` INT NULL,
  CONSTRAINT `user_id_constraint`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `movies_theater_id_constraint`
    FOREIGN KEY (`movies_theater_id`)
    REFERENCES `movies_theater` (`movies_theater_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
