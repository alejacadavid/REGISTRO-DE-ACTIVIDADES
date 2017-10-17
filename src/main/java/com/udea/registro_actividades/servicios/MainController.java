/**
 * Esta clase define la entidad para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.dao.CursoDAO;
import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.dao.SemestresDAO;
import com.udea.registro_actividades.modelo.Actividades;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.Grupos;
import com.udea.registro_actividades.modelo.Registro_Actividades;
import com.udea.registro_actividades.modelo.Semestres;


//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@RestController
@ComponentScan("com.udea.registro_actividades.servicios") // No need to include component-scan in xml
public class MainController {
	@Autowired
	SemestresDAO semestresDAO;
	@Autowired
	AsignacionesDAO asignacionesDAO;
	@Autowired
	CursoDAO cursosDAO;
	@Autowired
	GruposDAO gruposDAO;	
	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;


  @RequestMapping("/index")
  @ResponseBody
  public String index() {
    return "Microservicios de Registro Actividades";
  }
  
  
	
	 /**
		 * @author: Gonzalo Garcia gonchalo620@gmail.com
		 * @version: 03/05/2017/
		 */
		@RequestMapping("/grupos/findAll")
		@ResponseBody
		public List<Grupos> getAllGrupos() {
			List<Grupos> grupos = new ArrayList<Grupos>();
			grupos = (List<Grupos>) gruposDAO.findAll();
			//logger.info("todos las Actividades buscadas desde la funcion getAllActividades /actividades/findAll");
			return grupos;

		}
		
		/**
		 * @author: Gonzalo Garcia gonchalo620@gmail.com
		 * @version: 03/05/2017/
		 */
		@RequestMapping("/grupos/findBy")
		@ResponseBody
		public Grupos getgrupo(Integer id) {
			Grupos grupo = gruposDAO.findById(id);
			return grupo;
		}
	
}
