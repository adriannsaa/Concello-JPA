package jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Monitor;
import service.MonitorEJB;

@Named(value = "monitoresDetailsBean")
@SessionScoped
public class MonitoresDetailsBean implements Serializable {
	
	@Inject
	MonitorEJB monitorEjb;

	private static final long serialVersionUID = 1L;

	private Monitor monitorDetails;
	private Monitor monitorSaved;
	private Monitor monitorDelete;


	public Monitor getmonitorDetails() {
		return monitorDetails;
	}

	public void setmonitorDetails(Monitor monitorDetails) {
		this.monitorDetails = monitorDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getDetailsMonitor(int id){
		this.monitorDetails = monitorEjb.findMonitorById(id);
		return "monitorDetails";
	}
	
	public String saveDetailsMonitor(int id){
	
		monitorSaved = monitorEjb.findMonitorById(id);
		
		monitorSaved.setNombre(monitorDetails.getNombre());
		monitorSaved.setDni(monitorDetails.getDni());
		monitorSaved.setEmail(monitorDetails.getEmail());
		monitorSaved.setDireccion(monitorDetails.getDireccion());
		monitorSaved.setCp(monitorDetails.getCp());
		monitorSaved.setLocalidad(monitorDetails.getLocalidad());
		monitorSaved.setProvincia(monitorDetails.getProvincia());
		monitorSaved.setTelefono(monitorDetails.getTelefono());
		monitorSaved.setSueldo(monitorDetails.getSueldo());
		monitorSaved.setActivo(monitorDetails.getActivo());
		monitorSaved.setContrato(monitorDetails.getContrato());
		monitorSaved.setObservaciones_monitor(monitorDetails.getObservaciones_monitor());
		monitorSaved.setActividadesImpartidas(monitorDetails.getActividadesImpartidas());
		
		monitorEjb.updateMonitor(monitorSaved);
		return "monitores";
	}
	
	public String deleteMonitor(int id){	
		monitorDelete = monitorEjb.findMonitorById(id);
		monitorEjb.removeMonitor(monitorDelete);
		
		return "monitores";
	}
}
