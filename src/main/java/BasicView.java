import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.annotation.PostConstruct;

import javax.servlet.http.HttpServletRequest;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

@ManagedBean(name="dView")
public class BasicView implements Serializable {
	
	@ManagedProperty("#{unuser}")
	 private ServiceUsuario us;
	 private List<Grupo> grupos;
	 private String nombre;
	
	 @PostConstruct
	public void init() {
		nombre = us.getNombre();
		grupos = us.cargarGrupos();
	}


	public List<Grupo> getGrupo() {
		return grupos;
	}

	public void setGrupo(List<Usuario> usuarios) {
		this.grupos = grupos;
	}

	public ServiceUsuario getUs() {
		return us;
	}

	public void setUs(ServiceUsuario us) {
		this.us = us;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
	
	 
	 
	 
	 
}
