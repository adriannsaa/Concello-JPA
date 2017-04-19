package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="NavigationBean")
public class NavigationBean {
	
	public String goToAlumnos() {
	    return "alumnos";
	}
	
	public String goToAddAlumno() {
	    return "addAlumno";
	}
}
