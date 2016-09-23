package com.victommasi;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		/*Flyway fw = new Flyway();
		fw.setDataSource("jdbc:mysql://localhost/sales?useSSL=false","root","123456");
		fw.repair();*/
		SpringApplication.run(SalesApplication.class, args);
	}
}
