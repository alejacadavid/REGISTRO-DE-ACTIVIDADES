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

import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.modelo.Registro_Actividades;
import com.udea.registro_actividades.servicios.Registro_ActividadesRestController;

@RunWith(MockitoJUnitRunner.class)
public class Registro_ActividadesTest {
	
	private Registro_Actividades RegActividadesDto;
	
	@InjectMocks
	private Registro_ActividadesRestController servicioRegActividades = new Registro_ActividadesRestController();
	
	@Mock
	private Registro_ActividadesDAO regActividadesDao;
	
	@Mock
	private GruposDAO gruposDao;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		RegActividadesDto = new Registro_Actividades();
		
		List<Registro_Actividades> todosLosRegActividades = new ArrayList<Registro_Actividades>();
		todosLosRegActividades.add(RegActividadesDto);
		
	    when(regActividadesDao.findAll()).thenReturn(todosLosRegActividades);
	    
	    when(regActividadesDao.findById(anyInt())).thenReturn(RegActividadesDto);
	}

	@Test
	public void testIndex() {
		String mensaje = servicioRegActividades.index();
		assertTrue(mensaje.equals("servicios para registro actividades: /findAll, /findBy?id=, /save, /update "));
	}

	@Test
	public void testGetAllRegistroActividades() {
		assertNotNull(servicioRegActividades.getAllRegistroActividades());
	}

	@Test
	public void testGetRegistroId() {
		assertNotNull(servicioRegActividades.getRegistroId(3));
	}

	@Test
	public void testFindByAsignacionesByOrderByRegfecha() {
		assertNotNull(servicioRegActividades.findByAsignacionesByOrderByRegfecha(3));
	}

	@Test
	public void testDeleteRegistro() {
		assertNotNull(servicioRegActividades.deleteRegistro(2));
	}

	@Test
	public void testSetRegistroActividades() {
		assertNotNull(servicioRegActividades.setRegistroActividades(RegActividadesDto));
	}

	@Test
	public void testUpdateUser() {
		assertNotNull(servicioRegActividades.updateUser(RegActividadesDto));
	}

	@Test
	public void testGetRegistroGrupoAct() {
		assertNotNull(servicioRegActividades.getRegistroGrupoAct(2));
	}

	@Test
	public void testGetRegistroByGrupoSemestre() {
		assertNotNull(servicioRegActividades.getRegistroByGrupoSemestre(2, 5));
	}
	

}
