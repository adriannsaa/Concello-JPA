package jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import domain.Actividad;
import domain.Alumno;
import domain.Monitor;
import service.ActividadEJB;
import service.MonitorEJB;

@Named(value = "actividadesDetailsBean")
@SessionScoped
public class ActividadesDetailsBean implements Serializable {
	
	@Inject
	ActividadEJB actividadEjb;
	@Inject
	MonitorEJB monitorEjb;

	private static final long serialVersionUID = 1L;

	private Actividad actividadDetails;
	private Actividad actividadSaved;
	private Actividad actividadDelete;
	private int monitorId;

	public int getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(int monitorId) {
		this.monitorId = monitorId;
	}

	public ActividadEJB getActividadEjb() {
		return actividadEjb;
	}

	public void setActividadEjb(ActividadEJB actividadEjb) {
		this.actividadEjb = actividadEjb;
	}

	public Actividad getActividadDetails() {
		return actividadDetails;
	}

	public void setActividadDetails(Actividad actividadDetails) {
		this.actividadDetails = actividadDetails;
	}

	public Actividad getActividadSaved() {
		return actividadSaved;
	}

	public void setActividadSaved(Actividad actividadSaved) {
		this.actividadSaved = actividadSaved;
	}

	public Actividad getActividadDelete() {
		return actividadDelete;
	}

	public void setActividadDelete(Actividad actividadDelete) {
		this.actividadDelete = actividadDelete;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getDetailsActividad(int id){
		this.actividadDetails = actividadEjb.findActividadById(id);
		return "actividadDetails";
	}
	
	public String saveDetailsActividad(int id){
	
		actividadSaved = actividadEjb.findActividadById(id);
		
		actividadSaved.setNombre(actividadDetails.getNombre());
		actividadSaved.setParticipantes(actividadDetails.getParticipantes());
		actividadSaved.setHorario(actividadDetails.getHorario());
		actividadSaved.setLugar(actividadDetails.getLugar());
		actividadSaved.setMaterial(actividadDetails.getMaterial());
		actividadSaved.setObservaciones_actividad(actividadDetails.getObservaciones_actividad());
		actividadSaved.setListaDeAlumnos(actividadDetails.getListaDeAlumnos());
		actividadSaved.setMonitor(actividadDetails.getMonitor());
		
		actividadEjb.updateActividad(actividadSaved);
		return "actividades";
	}
	
	public void asignarMonitorById(){
		actividadDetails.setMonitor(monitorEjb.findMonitorById(monitorId));
	}
	
	public String deleteActividad(int id){
		
		actividadDelete = actividadEjb.findActividadById(id);
		actividadEjb.removeActividad(actividadDelete);
		
		return "actividades";
	}

}
