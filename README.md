# SALES-APP
Sale management system. 
* SpringBoot
* SpringMvc
* SpringSecurity
* SpringDataJPA
* Hibernate
* Thymeleaf/jQuery
* Maven
* MySQL


This is a demo of an application resquested by a customer for a freelancer job. She used to have a Google Sheet to manage her sales, but we decided to migrate her sheet to a web application adding some new features to it, like email reports and sales balance chart. I used my development skills to make things easy for her and people who work with her.

Backend is Java 8 with Spring framework, frontend is jQuery, Thymeleaf and Bootstrap and the data is stored in a MySql database.

[DEMO ON AMAZON AWS EC2](http://victommasi.tk/salesmanager)

### USAGE:
1. After downloading or cloning the project,
2. Create an application.properties file on src/main/resources folder.
3. An example content could be:

```sh
#MySQL properties
spring.datasource.url=jdbc:mysql://localhost/sales?useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1

#Hibernate properties
spring.jpa.database=MYSQL
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
hibernate.c3p0.validate=false
hibernate.c3p0.idle_test_period=30
hibernate.c3p0.automaticTestTable=conTestTable	

spring.mvc.view.suffix=.html

#Email properties
login=example		
password=example		
emailUser=example@example.com		
emailPassword=example
```
