# Create and use database
CREATE DATABASE IF NOT EXISTS GolfDB;
USE GolfDB;

# Create tables
CREATE TABLE IF NOT EXISTS User(
	userId INT AUTO_INCREMENT,
	firstName VARCHAR(60) DEFAULT NULL,
	lastName VARCHAR(60) DEFAULT NULL,
	email VARCHAR(60) NOT NULL,
	PRIMARY KEY(userId)
);

# Create User for DB granting privileges
CREATE USER IF NOT EXISTS Happy IDENTIFIED BY 'password';

GRANT * ON User TO Happy;