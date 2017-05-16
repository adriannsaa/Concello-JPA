package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import domain.Actividad;
import domain.Alumno;
import domain.Monitor;
import service.ActividadEJB;
import service.AlumnoEJB;

@Named(value = "alumnosBean")
@SessionScoped
public class AlumnosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AlumnoEJB alumnoEjb;

	@Inject
	ActividadEJB actividadEjb;

	private int id;

	@NotNull(message = "Introduzca un nombre")
	@Size(min = 5, max = 100)
	private String nombre;

	@NotNull(message = "Introduzca un DNI")
	@Size(min = 9, max = 9)
	private String dni;

	@NotNull(message = "Introduzca una edad")
	private int edad;
	
	private String email;

	@NotNull(message = "Introduzca una durección")
	@Size(min = 5, max = 100)
	private String direccion;

	@NotNull(message = "Introduzca un código postal")
	private int cp;

	@NotNull(message = "Introduzca una localidad")
	@Size(min = 2, max = 50)
	private String localidad;

	@NotNull(message = "Introduzca una provincia")
	@Size(min = 2, max = 30)
	private String provincia;

	@NotNull(message = "Introduzca un teléfono")
	private int telefono;

	private String nombre_autorizador;

	private String dni_autorizador;

	private String descuento;

	private String observaciones_alumno;

	private List<Actividad> listaDeActividades;
	
	private int actividadID;
	
	private List<Actividad> actividadesSeleccionadas = new ArrayList<Actividad>();
	

	@NotNull(message="Introduzca una fecha")
	private Date fechaAlta;	


	@PostConstruct
	public void init() {

		nombre = "";
		dni = "";
		edad = 0;
		email = "";
		direccion = "";
		cp = 0;
		localidad = "";
		provincia = "";
		telefono = 0;
		nombre_autorizador = "";
		dni_autorizador = "";
		descuento = "";
		observaciones_alumno = "";
		listaDeActividades = new ArrayList<Actividad>();
		fechaAlta= new Date();
	}

	public String createAlumno(){
		Alumno alumnoCreado = alumnoEjb.createAlumno(nombre, dni, edad, email, direccion, cp, localidad, provincia, telefono, 
													 nombre_autorizador, dni_autorizador, descuento, observaciones_alumno,fechaAlta,listaDeActividades);
		init();
		return "alumnos";
	}
	
	
	/**
	 * Find details of alumno
	 * 
	 * @param id
	 *            id of the alumno
	 */
	public String getDetailsAlumno(int id) {
		Alumno alumno = alumnoEjb.findAlumnoById(id);

		this.id = alumno.getId();
		this.nombre = alumno.getNombre();
		this.dni = alumno.getDni();
		this.edad = alumno.getEdad();
		this.email = alumno.getEmail();
		this.direccion = alumno.getDireccion();
		this.cp = alumno.getCp();
		this.localidad = alumno.getLocalidad();
		this.provincia = alumno.getProvincia();
		this.telefono = alumno.getTelefono();
		this.nombre_autorizador = alumno.getNombre_autorizador();
		this.dni_autorizador = alumno.getDni_autorizador();
		this.descuento = alumno.getDescuento();
		this.observaciones_alumno = alumno.getObservaciones_alumno();
		this.listaDeActividades = alumno.getListaDeActividades();
		this.fechaAlta = alumno.getFechaAlta();
		
		return "alumnoDetails";
	}
	
	public List<Alumno> getAllAlumnos(){
		List<Alumno> allAlumnos = new ArrayList<Alumno>();
		allAlumnos = alumnoEjb.getAllAlumnos();
		return allAlumnos;
	}	
		
	public void asignarActividadById(){
		Actividad actividadAdd = actividadEjb.findActividadById(actividadID);
		
		if(!this.actividadesSeleccionadas.contains(actividadAdd))
			actividadesSeleccionadas.add(actividadAdd);
		
		this.setListaDeActividades(actividadesSeleccionadas);
	}
	
	public AlumnoEJB getAlumnoEjb() {
		return alumnoEjb;
	}

	public void setAlumnoEjb(AlumnoEJB alumnoEjb) {
		this.alumnoEjb = alumnoEjb;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre_autorizador() {
		return nombre_autorizador;
	}

	public void setNombre_autorizador(String nombre_autorizador) {
		this.nombre_autorizador = nombre_autorizador;
	}

	public String getDni_autorizador() {
		return dni_autorizador;
	}

	public void setDni_autorizador(String dni_autorizador) {
		this.dni_autorizador = dni_autorizador;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getObservaciones_alumno() {
		return observaciones_alumno;
	}

	public void setObservaciones_alumno(String observaciones_alumno) {
		this.observaciones_alumno = observaciones_alumno;
	}

	public List<Actividad> getListaDeActividades() {
		return listaDeActividades;
	}

	public void setListaDeActividades(List<Actividad> listaDeActividades) {
		this.listaDeActividades = listaDeActividades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public List<Actividad> getActividadesSeleccionadas() {
		return actividadesSeleccionadas;
	}

	public void setActividadesSeleccionadas(List<Actividad> actividadesSeleccionadas) {
		this.actividadesSeleccionadas = actividadesSeleccionadas;
	}

	public int getActividadID() {
		return actividadID;
	}

	public void setActividadID(int actividadID) {
		this.actividadID = actividadID;
	}


}
