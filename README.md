# sales-app
Sale management system (SpringBoot, SpringSecurity, SpringDataJPA, Hibernate, Thymeleaf/jQuery,  Maven)


This application was resquested by a customer. She used to have a Google Sheet to manage her sales, but we decided to migrate her sheet to a better application adding some new features to it, like email reports and balance chart.

I used my development skills to make things easy for her and people who work with her.

Backend is Java 8 with Spring framework, frontend is jQuery, Thymeleaf and Bootstrap and the data is stored in a MySql database.

# USAGE:
After downloading or cloning the project, create an application.properties file on src/main/resources folder. An example context could be:

  spring.datasource.url=jdbc:mysql://localhost/salesmanager
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.testWhileIdle = true
  spring.jpa.database=MYSQL
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
  spring.jpa.hibernate.ddl-auto=update
  .
  .
  email and login requirements
  [...]
