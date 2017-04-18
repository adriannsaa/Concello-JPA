package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="NavigationBean")
public class NavigationBean {
	
	public String goToPrueba() {
	    return "prueba";
	}
}
