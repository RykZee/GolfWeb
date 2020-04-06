# Create and use database
DROP DATABASE IF EXISTS GolfDB;
CREATE DATABASE GolfDB;
USE GolfDB;

# Create tables
DROP TABLE IF EXISTS user;
CREATE TABLE user(
	user_id INT AUTO_INCREMENT,
	first_name VARCHAR(60) DEFAULT NULL,
	last_name VARCHAR(60) DEFAULT NULL,
	email VARCHAR(60) NOT NULL,
	PRIMARY KEY(user_id)
);

DROP TABLE IF EXISTS message;
CREATE TABLE message(
	message_id INT AUTO_INCREMENT,
	sender INT NOT NULL,
	receiver INT NOT NULL,
	content TEXT DEFAULT NULL,
	timestmp DATE NOT NULL,
	PRIMARY KEY(message_id),
	FOREIGN KEY(sender) REFERENCES user(user_id),
	FOREIGN KEY(receiver) REFERENCES user(user_id)
);

# Populate tables
INSERT INTO user VALUES
	(1, 'Sebastian', 'Vettel', 'vettel@golf.com'),
	(2, 'Tony', 'Stark', 'stark@golf.com'),
	(3, 'Natasha', 'Romanova', 'romanova@gmail.com');

INSERT INTO message VALUES
	(1, 2, 3, 'Lunch tomorrow?', '2020-03-30'),
	(2, 3, 2, 'You bet!', '2020-03-31');

# Create User for DB granting privileges
CREATE USER IF NOT EXISTS Happy IDENTIFIED BY 'password';

GRANT INSERT, SELECT, UPDATE, DELETE ON User TO Happy;
GRANT INSERT, SELECT, UPDATE, DELETE ON Message TO Happy;