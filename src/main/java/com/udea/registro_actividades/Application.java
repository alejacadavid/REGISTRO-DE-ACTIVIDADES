package com.udea.registro_actividades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication 
@ComponentScan(basePackages="com.udea.registro_actividades")
@EntityScan(basePackages = { "com.udea.registro_actividades.modelo" }, basePackageClasses = { Jsr310JpaConverters.class })
@EnableJpaRepositories(basePackages = { "com.udea.registro_actividades.dao" })
@EnableTransactionManagement
public class Application { 	
	
	//Para correr con maven: mvn spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


