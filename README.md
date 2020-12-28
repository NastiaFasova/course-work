# Institute of Advanced Training

![IAT](/images/ipk.jpg)

## Table of contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#for_developer)
* [Authors](#authors)

# <a name="purpose"></a>Project purpose
This project is a simple version of Institute of Advanced Training which simulates its main functions.
By the way, it gives you an opportunity to add lessons into timetable of 
every group, add new listeners, teachers and subjects. You can also update and 
delete all the previously mentioned entities if you are ADMIN.
If you are user, you can find you group, look at the timetable, look through teachers, subjects,
 listeners, groups and specialities.
#### The main functions of IAT:

* Registration and log in form(provided by Spring Security)
* Services which will simulate the main features of cinema(which are described in more detail below)
* Two roles: User and Admin
* Authentication
  As it was mentioned above, your ROLE determines the provided opportunities.
  The main ones are listed below.
<hr>

### Depending on the role you will have such opportunities:

#### Functions available for all users:
* log in
* register
* get all teachers
* get all subjects
* get all groups
* get all specialities
* get all lessons

#### Functions available only for users with a ADMIN-role:

* add new lessons
* add new teachers and subjects
* add new listeners
* add new subjects
* add new groups
* update and delete lessons, listeners, teachers, subjects, groups, specialities


In order to add some security and give the access to appropriate resources,
depending on the role,
Spring Boot Security was plugged in. As a result, Basic Authentication is built into this project.
It also should be pointed out that it implements the principle of layered architecture.
By the way, such layers as DAO and, Service and Controller are absent.

I  implemented mapping of all our entities into the DataBase and vice verse on the DAO layer,
while on the Service layer all the business logic is concentrated.

# <a name="structure"></a>Project structure

* Java 11
* Spring Data JPA
* Thymeleaf
* Spring Web
* Maven 4.0.0
* lombok
* log4j 1.2.17
* maven-checkstyle-plugin
* mysql-connector-java 8.0.15

# <a name="for_developer"></a>For developer
#### To run and test this project you need to install:

* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Tomcat](https://tomcat.apache.org/download-90.cgi)
* [MySQL 8 ](https://www.mysql.com/downloads/)

#### After installation, you should do the following:

Add this project to your IDE as Maven project.

Configure Tomcat :
* Add artifact
* Add Java SDK 11

Change a path in src.main.java.resources.log4j.properties. It has to reach your logFile.

#### If you want to test it using SQL DataBase and see the results of HTTP requests, you should:

* Create a schema "my_ipk" in any SQL database.
* At src.main.resources.application.properties file use your personal data for the DB to plug in.

![Configure_db](/images/img.png)

You may change nothing in pom.xml file

Run the project and log in.

By default, two users will be generated.

The first one - with a USER role (login = prylipk09@Gmail.com, password = listener)
The second one – with an ADMIN role (login = prylipk099@Gmail.com, password = admin).

# <a name="authors"></a>Authors
* [NastiaFasova](https://github.com/NastiaFasova) 

