package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import domain.Actividad;
import domain.Contrato;
import domain.Monitor;
import service.ActividadEJB;
import service.MonitorEJB;

@Named(value = "monitoresBean")
@SessionScoped
public class MonitoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	MonitorEJB monitorEjb;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Introduzca un nombre")
	@Size(min=5, max = 100)
	private String nombre;

	@NotNull(message="Introduzca un DNI")
	@Size(min=9, max = 9)
	private String dni;

	private String email;
	
	@NotNull(message="Introduzca una dirección")
	@Size(min=5, max = 100)
	private String direccion;
	
	@NotNull(message="Introduzca un código postal")
	private int cp;

	@NotNull(message="Introduzca una localidad")
	@Size(min=2, max = 50)
	private String localidad;
	
	@NotNull(message="Introduzca una provincia")
	@Size(min=2, max = 30)
	private String provincia;
	
	@NotNull(message="Introduzca un teléfono")
	private int telefono;
	
	@Size(min=0, max = 15)
	private String sueldo;
	
	@NotNull(message="Activo o No activo")
	private String activo;
	
	@NotNull(message="Seleccione un contrato")
	private Contrato contrato;
	
	@Size(min=0, max = 250)
	private String observaciones_monitor;

	private List<Actividad> actividadesImpartidas;
	
	private Contrato itemContratoConcello=Contrato.Concello;
	private Contrato itemContratoAutonomo=Contrato.Autonomo;
	private Contrato itemContratoSubcontratado=Contrato.Subcontratado;
	
	private List<Monitor> listaMonitores;
	
	public List<Monitor> getListaMonitores() {
		return listaMonitores;
	}

	public void setListaMonitores(List<Monitor> listaMonitores) {
		this.listaMonitores = listaMonitores;
	}

	@PostConstruct
	public void init() {

		nombre = "";
		dni = "";
		email = "";
		direccion = "";
		cp = 0;
		localidad = "";
		provincia = "";		
		telefono = 0;		
		sueldo = "";		
		activo = "";		
		contrato  = Contrato.Concello;		
		observaciones_monitor = "";
		actividadesImpartidas = new ArrayList<Actividad>();
		listaMonitores = new ArrayList<Monitor>();
	}

	public String createMonitor(){
		Monitor monitorCreado = monitorEjb.createMonitor(nombre, dni, email, direccion, cp, localidad, provincia, telefono, sueldo, activo, contrato, observaciones_monitor);
		
		init();
		return "monitores";
	}
	
	
	/**
	 * Find details of monitor
	 * 
	 * @param id
	 *            id of the monitor
	 */
	public String getDetailsMonitor(int id) {
		Monitor monitor = monitorEjb.findMonitorById(id);
		this.id = monitor.getId();
		this.nombre = monitor.getNombre();
		this.dni = monitor.getDni();
		this.email = monitor.getEmail();
		this.direccion = monitor.getDireccion();
		this.cp = monitor.getCp();
		this.localidad = monitor.getLocalidad();
		this.provincia = monitor.getProvincia();
		this.telefono = monitor.getTelefono();
		this.sueldo = monitor.getSueldo();
		this.activo = monitor.getActivo();
		this.contrato  = monitor.getContrato();
		this.observaciones_monitor = monitor.getObservaciones_monitor();
		this.actividadesImpartidas = monitor.getActividadesImpartidas();

		return "monitorDetails";
	}
	
	public List<Monitor> getAllMonitores(){
		List<Monitor> allMonitores = new ArrayList<Monitor>();
		allMonitores = monitorEjb.getAllMonitores();	
		
		return allMonitores;
	}
	
	public Monitor getMonitorByID(int id){
		Monitor m = new Monitor();
		m = monitorEjb.findMonitorById(id);	
		
		return m;
	}
	
	public List<Monitor> getListMonitores(){
		this.listaMonitores = monitorEjb.getAllMonitores();	
		
		return this.listaMonitores;
	}
	
	public MonitorEJB getMonitorEjb() {
		return monitorEjb;
	}

	public void setMonitorEjb(MonitorEJB monitorEjb) {
		this.monitorEjb = monitorEjb;
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

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public String getObservaciones_monitor() {
		return observaciones_monitor;
	}

	public void setObservaciones_monitor(String observaciones_monitor) {
		this.observaciones_monitor = observaciones_monitor;
	}

	public List<Actividad> getActividadesImpartidas() {
		return actividadesImpartidas;
	}

	public void setActividadesImpartidas(List<Actividad> actividadesImpartidas) {
		this.actividadesImpartidas = actividadesImpartidas;
	}

	public Contrato getItemContratoConcello() {
		return itemContratoConcello;
	}

	public void setItemContratoConcello(Contrato itemContratoConcello) {
		this.itemContratoConcello = itemContratoConcello;
	}

	public Contrato getItemContratoAutonomo() {
		return itemContratoAutonomo;
	}

	public void setItemContratoAutonomo(Contrato itemContratoAutonomo) {
		this.itemContratoAutonomo = itemContratoAutonomo;
	}

	public Contrato getItemContratoSubcontratado() {
		return itemContratoSubcontratado;
	}

	public void setItemContratoSubcontratado(Contrato itemContratoSubcontratado) {
		this.itemContratoSubcontratado = itemContratoSubcontratado;
	}
		
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
