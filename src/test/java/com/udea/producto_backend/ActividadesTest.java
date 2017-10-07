package com.udea.producto_backend;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.udea.registro_actividades.dao.ActividadesDAO;
import com.udea.registro_actividades.modelo.Actividades;
import com.udea.registro_actividades.servicios.ActividadesRestController;

@RunWith(MockitoJUnitRunner.class)
public class ActividadesTest {
	
	private Actividades actividadesDto;
	
	@InjectMocks 
	private ActividadesRestController servicioActividades = new ActividadesRestController();

	@Mock
	private ActividadesDAO actividadDao;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		actividadesDto = new Actividades();
		
		List<Actividades> todasLasActividades = new ArrayList<Actividades>();
		todasLasActividades.add(actividadesDto);
		
	    when(actividadDao.findAll()).thenReturn(todasLasActividades);
	    
	    when(actividadDao.findById(anyInt())).thenReturn(actividadesDto);
	}

	@Test
	public void testIndex() throws ServiceException, ValidationException{
		String mensaje = servicioActividades.index();
		assertTrue(mensaje.equals("servicios para actividades: /actividades/findAll, /actividades/findBy?id="));
	}

	@Test
	public void testGetAllActividades() throws ServiceException, ValidationException{
		List<Actividades> todasLasActividades;
		todasLasActividades = servicioActividades.getAllActividades();
		assertNotNull(todasLasActividades);
		assertTrue(todasLasActividades.size()>0);
		
	}

	@Test
	public void testGetActividad() throws ServiceException, ValidationException{
		Actividades actividad = servicioActividades.getActividad(2);
		assertNotNull(actividad);
	}
	

}
