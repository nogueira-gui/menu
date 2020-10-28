# RestAPI Spring-Boot Menu Restaurant

This repository is just an example on how to dockerize Spring Boot application with an embedded tomcat server. The app could perform CRUD operations using particular HTTP methods i.e. GET, POST, PUT, and DELETE..

Prerequisites
1. Spring Tool Suite or IntelliJ

2. Spring Boot 2.3.4

3. Maven

4. Tomcat Embedded

5. Docker Toolbox

6. java:11 Image

7. mysql:9.0.8   


#URL docker-> localhost:8080/menu/
#Swagger2 -> http://localhost:8080/swagger-ui/

The following steps are essential to get this project running:

1. Pull this project from docker hub:

$sudo docker pull ninjadexter/menu

2. Pull mysql image from your docker toolbox:

$sudo docker pull mysql

3. Create table on database menu_mysql:

Field	    Type	  Null	  Key	          Default

menu_id   int	    NO	    Primary Key	  NULL
titulo    VARCHAR(100)	  NO		        NULL
descricao	VARCHAR(150)	  NO		        NULL


4. Run this project image: docker-compose up --build --force-recreate 
  The file Dockerfile is already configured to run mysql and listen app in port 8080
  
5. Now you could access the resources through REST URLs. Below are the list of URLs:

  a. Return menus data with json format (HTTP Method-> GET): http://localhost:8080/menu/

  b. Return a menu object with json format (HTTP Method-> GET): http://localhost:8080/menu/?id=?

  c. Add menu (HTTP Method-> POST): http://localhost:8080/menu/?id=?&titulo=?&descricao=?

  d. Update menu (HTTP Method-> PUT): http://localhost:8080/menu/?id=?&titulo=?&descricao=?

  e. Delete menu (HTTP Method-> DELETE): http://localhost:8080/menu/?id=?

