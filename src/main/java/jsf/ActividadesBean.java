package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.swing.JOptionPane;

import domain.Actividad;
import domain.Alumno;
import domain.Monitor;
import service.ActividadEJB;
import service.AlumnoEJB;

@Named(value = "actividadesBean")
@SessionScoped
public class ActividadesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ActividadEJB actividadEjb;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Introduzca el nombre de la actividad")
	@Size(min=5, max = 100)
	private String nombre;

	@NotNull(message="Introduzca el número de participantes")
	private int participantes;


	@NotNull(message="Introduzca un horario")
	@Size(min=6, max = 200)
	private String horario;
	
	@NotNull(message="Introduzca un lugar")
	@Size(min=5, max = 50)
	private String lugar;
	
	@Size(min=0, max = 500)
	private String material;
	
	@Size(min=0, max = 255)
	private String observaciones_actividad;
	
	private List<Alumno> listaDeAlumnos;

	private Monitor monitor;
	
	@PostConstruct
	public void init() {
		nombre ="";
		participantes=0;
		horario="";
		lugar="";
		material="";
		observaciones_actividad="";
		listaDeAlumnos = new ArrayList<Alumno>();;
		monitor = new Monitor();
	}

	public String createActividad(){
		Actividad actividadCreada = actividadEjb.createActividad(nombre, monitor, participantes, horario, lugar, material, observaciones_actividad);

		init();
		return "actividades";
	}
	
	
	/**
	 * Find details of actividad
	 * 
	 * @param id
	 *            id of the actividad
	 */
	public String getDetailsActividad(int id) {
		Actividad actividad = actividadEjb.findActividadById(id);

		this.id = actividad.getId();
		this.nombre = actividad.getNombre();
		this.participantes = actividad.getParticipantes();
		this.horario = actividad.getHorario();
		this.lugar = actividad.getLugar();
		this.material = actividad.getMaterial();
		this.observaciones_actividad = actividad.getObservaciones_actividad();
		this.listaDeAlumnos = actividad.getListaDeAlumnos();
		this.monitor = actividad.getMonitor();
		
		return "actividadDetails";
	}
	
	public List<Actividad> getAllActividades(){
		List<Actividad> allActividades = new ArrayList<Actividad>();
		allActividades = actividadEjb.getAllActividades();
		return allActividades;
	}

	public ActividadEJB getActividadEjb() {
		return actividadEjb;
	}

	public void setActividadEjb(ActividadEJB actividadEjb) {
		this.actividadEjb = actividadEjb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getObservaciones_actividad() {
		return observaciones_actividad;
	}

	public void setObservaciones_actividad(String observaciones_actividad) {
		this.observaciones_actividad = observaciones_actividad;
	}

	public List<Alumno> getListaDeAlumnos() {
		return listaDeAlumnos;
	}

	public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
		this.listaDeAlumnos = listaDeAlumnos;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
