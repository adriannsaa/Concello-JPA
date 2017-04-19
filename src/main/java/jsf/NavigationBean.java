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
	
	public String goToAddAlumno() {
	    return "addAlumno";
	}
}
