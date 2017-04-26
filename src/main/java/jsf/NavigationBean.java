package jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "NavigationBean")
@SessionScoped
public class NavigationBean implements Serializable{
	
	public String goToAlumnos() {
	    return "alumnos";
	}
	
	public String goToNewAlumno() {
	    return "newAlumno";
	}
	
	public String goToHome() {
	    return "index";
	}
	
	public String goToActividades() {
	    return "actividades";
	}
	
	public String goToNewActividad() {
	    return "newActividad";
	}
	
	public String goToMonitores() {
	    return "monitores";
	}
	
	public String goToNewMonitor() {
	    return "newMonitor";
	}
}
