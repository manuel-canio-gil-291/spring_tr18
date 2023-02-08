# Classroom and trolley reservation application

Welcome to my Spring Boot application. This application consists of making one or more reservations for a classroom and/or trolleys, whether for tablets or computers.

This application it's a reference with a database that includes the following tables:
- TIC classroom
- PC trolley
- Tablet trolley
- Teacher
- Reserves classroom
- Reserves PC trolley
- Reserves tablet trolley

## How work this app?

This app conects with MySQL database, it allows create databases, tables and links the another existent table (in this case the many to one) with foreign keys.

## Anything else?

There are also the controllers and the repositories.

The **controllers** make actions with the tables, for example: insert teacher data into the table teacher, or, make reserve of the PC trolley and insert it into the table of the reserves PC trolley...

The **repositories** allows make orders with SQL commands to modify the tables data in the database.

## Getting started

Before to download this application code, please install MySQL in your computer, it's necessary to interact with the database.

You can download this program in the following [link](https://dev.mysql.com/downloads/mysql/).

Once you have downloaded and installed MySQL, open the MySQL Command Line Client, type your password and write the following command:\
` CREATE DATABASE "name_of_the_database" `

> Important: The version source of Maven POM is 19, if you don't have JDK 19 in your computer, please install it. If you have an older version of JDK (1.8, 11 or 17), uninstall the version in your computer and install the JDK 19.

Once created, now you can download this application code, it's located in the right sidebar that indicates **Releases**. Download the Zip source code and extract the folder.

To open the application code, use some IDE that you use actually (Visual Studio Code, Intellij IDEA, Eclipse or something else).

Go to the file `application.yml` that it's located in `src/main/resources`. If you need some modification of the name of the database, user or password, modify it.

Once you have finished reviewing everything, you can now run the application.

### Dependencies used on this application

- Spring Data with JPA
- Spring web
- Spring session core
- Spring boot with Thymeleaf
- Spring boot test
- MySQL Connector for Java
- FasterXML Jackson
- Log4 Java core
- Log4 Java API

### About this app ###

Developed with Java 19 based on Spring Boot 3.0.2.