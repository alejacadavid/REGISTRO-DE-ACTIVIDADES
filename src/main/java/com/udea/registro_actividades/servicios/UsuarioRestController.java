package com.udea.registro_actividades.servicios;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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


import com.udea.registro_actividades.dao.UsuarioDAO;
import com.udea.registro_actividades.modelo.Usuarios;

/**
 * Esta clase define Los servicios REST para el objeto usuario.
 * @author: Yesid Montoya - yesid.montoyap@udea.edu.co
 * @version: 01/11/2017/
 */
@CrossOrigin
@Controller

//Clase mediante la cual se controlan el uso de los servicios rest
public class UsuarioRestController { 
	final static Logger logger = Logger.getLogger(UsuarioRestController.class);
	@Autowired 
	UsuarioDAO usuarioDAO;
	
	//@RequestMapping etiqueta empleada para direccionar las llamadas del cliente.
		
	@RequestMapping("/usuario/login")  
	@ResponseBody
	/**
	 * Método que recibe los parámetros y permite el login
	 * @param username guarda el nombre de usuario
	 * @param password guarda la contraseña
	 * @return retorna el login para poder ingresar a la aplicación
	 */
	public Usuarios login(String username,String password) {
		Usuarios usuario=new Usuarios();
		Usuarios login=null;
		try{
			//usuario= usuarioDAO.findByUsuUsuario(nombreUsuario);	
			usuario= usuarioDAO.findByUsuEmail(username);
			if(usuario!=null && usuario.getUsuPassword().equalsIgnoreCase(password)) {
			
				login=usuario;
			}
		}catch(Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
						
		}
		logger.info("Login bien ");
		return login;
		
	}
	
	
	/**
	 * Método para enviar un correo de recuperación
	 * @param Username recibe nombre de usuario
	 * @param Subject  recibe el asunto
	 * @param Mensage  recibe el cuerpo del correo
	 * @throws GeneralSecurityException controla las excepciones 
	 */
	
	 public void SendMail(String Username, String Subject,String Mensage) throws GeneralSecurityException {
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	    
	        
	 String usu="";//poner correo electronico de gmail como servidor
	 String pas="";//poner contraseña del correo del campo anterior
	 
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(usu, pas);
                    }
               });
	 
	        try {
	 
	            Message message = new MimeMessage(session);	            
	            message.setFrom(new InternetAddress(usu));	            
	            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Username));	           
	            message.setSubject(Subject);	            
	            message.setText(Mensage);	            
	            Transport.send(message);
	           
	 
	        } catch (MessagingException e) {
	        	System.out.println(e.getMessage());
	            throw new RuntimeException(e);
	            
	        }
	    }
	
	@RequestMapping("/usuario/recuperar")
	@ResponseBody
	/**
	 * Método que permite la recuperación de la contraseña
	 * @param nombreUsuario recibe el usuario
	 * @return retorna el login
	 */
	public String recuperarContraseña(String nombreUsuario) {
		Usuarios usuario=new Usuarios();
		String login="El correo no es un correo valido";
		try{
			//usuario= usuarioDAO.findByUsuUsuario(nombreUsuario);	
			usuario= usuarioDAO.findByUsuEmail(nombreUsuario);
			if(usuario!=null) {
			String password=usuario.getUsuPassword();
			String mensage="Su nombre de usuario es "+nombreUsuario+" y su contraseña es: "+password;
			String asunto="Recuperacion de contraseña";
			SendMail(nombreUsuario,asunto, mensage);
			
			login="valido";
			}
		}catch(Exception e) {
			login=e.getMessage();
			
		}
		
		return login;
	}
	
	@RequestMapping(value= "/usuario/modificar", method = RequestMethod.PUT)
	@ResponseBody
	/**
	 * Método que permite modificar la contraseña
	 * @param nombreUsuario recibe el usuario
	 * @param pswd recibe la contraseña
	 * @return retorna la respuesta del proceso
	 */
	public String modificarContraseña(String nombreUsuario, String pswd) {
		String respuesta = null;
		try {}catch(Exception e){}
		Usuarios usuario=new Usuarios();
		usuario= usuarioDAO.findByUsuEmail(nombreUsuario);
		if (usuario != null) {
			usuario.setUsuPassword(pswd);
			usuarioDAO.save(usuario);
			respuesta = "valida";
		}
		return respuesta;
	}
}