package com.udea.registro_actividades;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Application { 	
	
	// para correc con maven: mvn spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//System.out.println(Application.class.getProtectionDomain().getCodeSource().getLocation()+"com/udea/cursos/reportes/");
	}
}

//falta response entity en update
//se debería utilizar put y no post para actualizaciones
//arreglar formato de fecha en registro de actividades
//mapear la entidad usuarios y roles


