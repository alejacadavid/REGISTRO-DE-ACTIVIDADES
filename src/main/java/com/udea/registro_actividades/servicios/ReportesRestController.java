/**
 * Esta clase define Los servicios REST para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.udea.registro_actividades.Application;
import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.dao.SemestresDAO;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.Grupos;
import com.udea.registro_actividades.modelo.Registro_Actividades;
import com.udea.registro_actividades.modelo.Semestres;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@Controller
public class ReportesRestController {

	final static Logger logger = Logger.getLogger(ReportesRestController.class);

	@Autowired
	SemestresDAO semestresDAO;
	@Autowired
	AsignacionesDAO asignacionesDAO;
	@Autowired
	GruposDAO gruposDAO;
	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;
	

	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 02/06/2017/
	 */
	@RequestMapping("/reportes")
	@ResponseBody
	public String index() {
		return "servicios para los reportes con jasper reports";
	}

	//https://stackoverflow.com/questions/8935925/jasperreports-compilation-error
		@RequestMapping(value= "/reportes/regActividades", method = RequestMethod.GET, produces="application/pdf")
		public @ResponseBody void reporteRegActividades(HttpServletResponse response, Integer idAsig) throws Throwable {
			try{
				InputStream jasperStream = this.getClass().getResourceAsStream("/repRegActividades.jrxml");
				//com/udea/registro_Actividades/reportes
				//C:/Users/GonzaloAndres/Desktop/actividades/target/classes/com/udea/registro_actividades/reportes
				System.out.println(this.getClass().getResourceAsStream("/repRegActividades.jrxml"));
				//JasperDesign design = JRXmlLoader.load(jasperStream);
				String ruta = Application.class.getProtectionDomain().getCodeSource().getLocation()+"reportes/repRegActividades.jrxml";
				ruta = ruta.substring(5);
				JasperDesign design = JRXmlLoader.load(ruta);
				
				JasperReport report = JasperCompileManager.compileReport(design);
				
				Map<String, Object> parameterMap = new HashMap();
				Asignaciones asignaciones = new Asignaciones();
				asignaciones = asignacionesDAO.findById(idAsig);			
				if (asignaciones == null) {
					throw new Exception("no se pudo consultar una asignacion con ese id o no existe");
				}
				List<Registro_Actividades> registro_actividades = registroActividadesDAO.findByAsignaciones(asignaciones);
				JRDataSource jRDataSource = new JRBeanCollectionDataSource(registro_actividades);
				
				parameterMap.put("datasource", jRDataSource);
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameterMap, jRDataSource);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline: filename = reporteRegActividades");
				final OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			}catch(JRException ex){
				logger.info("jre exception");
				ex.printStackTrace(); 
			}
		}

}
