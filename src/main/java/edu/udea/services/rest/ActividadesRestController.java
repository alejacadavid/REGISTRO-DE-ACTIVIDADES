package edu.udea.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/actividades")
public class ActividadesRestController {
	
	Logger logger = LoggerFactory.getLogger(ActividadesRestController.class.getName());
	
	@RequestMapping("saludar")
	public String saludar(){
		return "Hola a todos";
	}

}
