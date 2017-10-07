package com.udea.registro_actividades.excepciones;

public class ExcepcionGenerica extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String mensajeTecnico;
	protected String mensajeUsuario;
	protected String id;
	protected Exception excepcionOrigen;
	
	public ExcepcionGenerica(){	}
	
	public ExcepcionGenerica(String mensajeTecnico, String mensajeUsuario,
			String id, Exception excepcionOrigen) {
		super();
		this.mensajeTecnico = mensajeTecnico;
		this.mensajeUsuario = mensajeUsuario;
		this.id = id;
		this.excepcionOrigen = excepcionOrigen;
	}
	
	
	public ExcepcionGenerica(Exception excepcionOrigen) {
		super();
		this.excepcionOrigen = excepcionOrigen;
	}

	public Exception getExcepcionOrigen() {
		return excepcionOrigen;
	}

	public void setExcepcionOrigen(Exception excepcionOrigen) {
		this.excepcionOrigen = excepcionOrigen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	
	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}
	
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	
	public void imprimirMensajeTecnicoConsola(){
		this.printStackTrace();
	}
}
