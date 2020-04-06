# GolfWeb
Back end Spring Boot application built with Maven, reading from a MySQL database and providing CRUD (Create, Read, Update, Delete) through a REST API.
---
### Prerequisites
MySQL and Java SDK 8 should be installed. Modern IDE such as IntelliJ, Eclipse or Netbeans with Maven support.

### Installing and running
Run the DatabaseScript.sql in the workbench to create tables and populate with some dummy data.

Import project as maven project in IDE of choice (I used IntelliJ) and build and run as a Java application.

If you have mvn command line installed, you could also run it through the terminal when in the root directory of the project:
```
mvn spring-boot:run
```

To GET all users in database as JSON objects in your web browser go to:
localhost:8080/userapi/users