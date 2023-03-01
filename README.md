# CST-590-Capstone Project
This is the repository hosting the code for the Capstone project by Mubasher Mehnaz Begum

# Project Background:
One of the popular methods used by hackers to target databases is the SQL injection attack. Even though this vulnerability has been around for a while, most mitigation strategies are based on safe coding techniques as many programmers do not evaluate the reliability of user input data when writing code, which increases the security risks of applications. Users can enter a database query code and receive the desired data based on the program's output.

This project aims to provide SQL Injection vulnerability mitigation techniques that may be used with practically any programming language and any kind of database. This project demonstrates how the SQL query might be changed to thwart such an attack; the project compares Safe Code against Unsafe Code.

# Project Benefits
The project will likely give a central comprehension of how to perceive and guard against SQL Infusion Assaults. 
Step by step instructions to confirm input information, keep away from SQL Infusion assaults, and plan safe SQL queries that acknowledge input from online applications.
Prevent SQL injection when running queries against the database and to safeguard the database. 
Using a unique static and dynamic analytic approach to detect SQL injection threats. 
Prevent loss of personal information data resulting in data breach and loss of customer trust in the company.

# Implementation Approach

This project contains two applications:
1) JAVA Rest API using Springboot framework that consists of API calls for User Authentication.
2) Front End UI application using React library that would have a login page for User data entry of Username and password for authorizing the user.


# Steps to Clone the Repo

Option 1: Goto Terminal and enter the following commands to clone the repository or 
$ git clone https://github.com/MubasherBegum/CST-590-capstone.git
$ cd CST-590-capstone

Option 2: Download and extract ZIP by clicking on below link directly
https://github.com/MubasherBegum/CST-590-capstone/archive/refs/heads/master.zip


# 1 Steps to build the JAVA Rest API using Springboot are provided below
Goto Folder CST-590-capstone/java-api

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

# JAVA application setup: 
Download the folder java-api and navigate into the folder.
Load the project into any IDE like IntelliJ or eclipse.
Configure Maven Depencies and download the dependencies when prompted.
Build the Maven project using below commands and run the application:

** using maven to build/run**
```bash
mvn spring-boot:run
```

Java Application can be tested in local using:
<http://localhost:8080>.

# API End points to Test:
POST request for authenticating Users using Un-safe method: http://localhost:8080/api/v1/unsafe/user/login?username=test123&password=xyz

POST request for authenticating Users using Safe method: http://localhost:8080/api/v1/safe/user/login?username=administrator' OR NOT 1=-1-- BGqV&password=tesdsfsd

GET Request for User by ID: http://localhost:8080/api/v1/safe/getusers?id=35


# 2 Steps to install and run UI Code
Goto Folder CST-590-capstone/UI-code

# This is a Frontend Application built using React library

# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

# Prerequisites needed for local setup
Download Node.js Installer for Windows/Mac from below URL:
from: https://nodejs.org/en/download/

Run the installation and complete with the installation steps

# Install Project Dependencies
From folder: CST-590-capstone/UI-code
Open Terminal and enter below command to install the project dependencies. 
### `npm i`

This creates a new Folder called node_modules with all the dependencies and ready to run the application.

## Start Application using:

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

# Additional scripts required for Deployment to Server
### `npm test`

Launches the test runner in the interactive watch mode.\


### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

