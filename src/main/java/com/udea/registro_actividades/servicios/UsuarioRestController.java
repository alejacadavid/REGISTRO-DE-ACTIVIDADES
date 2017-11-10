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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.mail.util.MailSSLSocketFactory;
import com.udea.registro_actividades.dao.UsuarioDAO;
import com.udea.registro_actividades.modelo.Roles;
import com.udea.registro_actividades.modelo.Usuarios;

@CrossOrigin
@Controller
public class UsuarioRestController {
	
	@Autowired 
	UsuarioDAO usuarioDAO;
	
	@RequestMapping("/usuario/login")
	@ResponseBody
	public String login(String nombreUsuario, String password) {
		Usuarios usuario=new Usuarios();
		String login="Usuario o cantraseña no validos";
		try{
			//usuario= usuarioDAO.findByUsuUsuario(nombreUsuario);	
			usuario= usuarioDAO.findByUsuEmail(nombreUsuario);
			if(usuario!=null && usuario.getUsuPassword().equalsIgnoreCase(password)) {
			
				login=usuario.getRol().getRolNombre();
			}
		}catch(Exception e) {
			login=e.getMessage();
			
		}
		
		return login;
		
	}
	
	//metodo para enviar un correo de recuperacion 
	 public void SendMail(String Username, String Subject,String Mensage) throws GeneralSecurityException {
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	    
	        
	 String usu="yesidmontoya77@gmail.com";
	 String pas="iamcrazy1";
	 
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(usu, pas);
                    }
               });
	 
	        try {
	 System.out.println("entro 1");
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
}