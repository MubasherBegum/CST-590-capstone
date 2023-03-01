# This is a sample for Captsone project by Mubasher M Begum
# This is a REST API utilizing Spring Boot, Mysql and JPA & Hibernate

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

** using maven to build/run**
```bash
mvn spring-boot:run
```

Application can be tested in local using:
<http://localhost:8080>.
