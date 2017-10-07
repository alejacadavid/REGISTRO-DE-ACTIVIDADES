package com.udea.producto_backend;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.servicios.AsignacionesRestController;

@RunWith(MockitoJUnitRunner.class)
public class AsignacionesTest {
	
	private Asignaciones asignacionesDto;
	
	@InjectMocks
	private AsignacionesRestController servicioAsignaciones = new AsignacionesRestController();
	
	@Mock
	private AsignacionesDAO asignacionesDao;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		asignacionesDto = new Asignaciones();
		
		List<Asignaciones> todasLasAsignaciones = new ArrayList<Asignaciones>();
		todasLasAsignaciones.add(asignacionesDto);
		
	    when(asignacionesDao.findAll()).thenReturn(todasLasAsignaciones);
	    
	    when(asignacionesDao.findById(anyInt())).thenReturn(asignacionesDto);
	}

	@Test
	public void testIndex() throws ServiceException, ValidationException {
		String mensaje = servicioAsignaciones.index();
		assertTrue(mensaje.equals("servicios para asignaciones: /asignaciones/findAll, /asignaciones/findBy?id="));
	}

	@Test
	public void testGetAllAsignaciones() throws ServiceException, ValidationException{
		List<Asignaciones> todasLasAsignaciones;
		todasLasAsignaciones = servicioAsignaciones.getAllAsignaciones();
		assertNotNull(todasLasAsignaciones);
		assertTrue(todasLasAsignaciones.size()>0);
	}

	@Test
	public void testGetAsignaciones() throws ServiceException, ValidationException {
		Asignaciones asignacion = servicioAsignaciones.getAsignaciones(4);
		assertNotNull(asignacion);
	}
	

}
