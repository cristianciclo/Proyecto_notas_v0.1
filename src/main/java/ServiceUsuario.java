import java.util.*;
import redis.clients.jedis.Jedis;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

import java.util.Map;

@ManagedBean(name="unuser")
@SessionScoped
public class ServiceUsuario {
		
	private String nombre;
	private String passwd;
	private String asignatura;
	private String nota;
	private String cad_nota;
	private List<Grupo> grupos;
	private String asignatura1;
	private String nota1;

	public String outcome(){

		FacesContext fc = FacesContext.getCurrentInstance();
		this.asignatura1 = getAsignaturaParam(fc);
		this.nota1 = getNotaParam(fc);

		return "result";
	}

	public String getAsignaturaParam(FacesContext fc){

		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("asignatura");

	}

	public String getNotaParam(FacesContext fc){

		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("nota");

	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getAsignatura1() {
		return asignatura1;
	}

	public void setAsignatura1(String asignatura1) {
		this.asignatura1 = asignatura1;
	}

	public List<Grupo> cargarGrupos() {
	    Jedis conn = new Jedis("localhost");
	    conn.select(15);
	    grupos = new ArrayList<Grupo>();
	    for (String member : conn.lrange("notas:usuario:"+this.nombre+":notas", 0, -1)){
		      grupos.add(new Grupo(member.substring(0,3).toUpperCase(), member.substring(3,5)));
		    }
	    return grupos;
	}

	public String login() {
	    Jedis conn = new Jedis("localhost");
	    conn.select(15);
	    List<Usuario> us = new ArrayList<Usuario>();
	    for (String member : conn.keys("*")){
	      String[] campos = member.split(":");
	      us.add(new Usuario(campos[2], campos[2].substring(0, 3)));
	    }
	    
	    for (int i = 0; i < us.size(); i++) {
			if(this.nombre.equals(us.get(i).getNombre())) {
				if(this.passwd.equals(us.get(i).getPasswd())) {
					System.out.println("Hecho");
					return "show";
				}
			}
		}
	    return null;
	  }
	
	public String logout(){
		
		this.nombre="";
		this.passwd="";
		
		return "login";
	}
	
	public String insertar(){
		
		return "insertar";
	}

	public String modificar(){
		outcome();
		return "modificar";
	}

	public String add(){
		
		Jedis conn = new Jedis("localhost");
	    	conn.select(15);
		cad_nota=asignatura+nota;
	    	conn.rpush("notas:nota:"+asignatura , nombre+"-"+nota);
		conn.rpush("notas:usuario:"+nombre+":notas",cad_nota);
		System.out.println("Funciona");
		System.out.println(nombre);
		System.out.println(asignatura);
		System.out.println(nota);
		System.out.println(cad_nota);
		
		return "show";
	}

	public String del(){

	  	outcome();
		Jedis conn = new Jedis("localhost");
	    	conn.select(15);
		cad_nota=asignatura1+nota1;
		cad_nota.toLowerCase();
		conn.lrem("notas:usuario:"+nombre+":notas", 0 ,cad_nota.toLowerCase());
		conn.lrem("notas:nota:"+asignatura1.toLowerCase(), 0, nombre+"-"+nota1); 		
		return "show";
	}

	public String modificarnota(){

		Jedis conn = new Jedis("localhost");
	    	conn.select(15);
		cad_nota=asignatura1+nota1;
		cad_nota.toLowerCase();
		conn.lrem("notas:usuario:"+nombre+":notas", 0 ,cad_nota.toLowerCase());
		conn.lrem("notas:nota:"+asignatura1.toLowerCase(), 0, nombre+"-"+nota1); 
		cad_nota=asignatura1+nota;
	    	conn.rpush("notas:nota:"+asignatura1.toLowerCase() , nombre+"-"+nota);
		conn.rpush("notas:usuario:"+nombre+":notas",cad_nota.toLowerCase());		
		return "show";
	}

	
	
}
