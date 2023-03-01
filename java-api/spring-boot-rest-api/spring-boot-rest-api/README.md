# This is a sample for Captsone project by Mubasher M Begum
# This is a REST API utilizing Spring Boot, Mysql and JPA & Hibernate

#1 Steps to build the JAVA Rest API using Springboot are provided below
Goto Folder java-api
# This is a REST API utilizing Spring Boot, Mysql and JPA & Hibernate
Database schema is provided in java-api/datbase_schema.sql and also provided below
**Creating mysql database can be done with the script below **
```bash
CREATE SCHEMA authusers;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `email` varchar(96) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(64) DEFAULT NULL,
  `upassword` varchar(64) NOT NULL,
  `urole` varchar(40) NOT NULL,
  `logged_in` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

use authusers;
CREATE TABLE `users_2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `email` varchar(96) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(64) DEFAULT NULL,
  `upassword` varchar(64) NOT NULL,
  `urole` varchar(40) NOT NULL,
  `logged_in` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

JAVA application setup: 
Download the folder java-api and navigate into the folder.
Load the project into any IDE like IntelliJ or eclipse.
Configure Maven Depencies and download the dependencies when prompted.
Build the Maven project using below commands and run the application:

** using maven to build/run**
```bash
mvn spring-boot:run
```

Application can be tested in local using:
<http://localhost:8080>.

API End points to Test:
POST request for authenticating Users using Un-safe method: http://localhost:8080/api/v1/unsafe/user/login?username=test123&password=xyz

POST request for authenticating Users using Safe method: http://localhost:8080/api/v1/safe/user/login?username=administrator' OR NOT 1=-1-- BGqV&password=tesdsfsd

GET Request for User by ID: http://localhost:8080/api/v1/safe/getusers?id=35
