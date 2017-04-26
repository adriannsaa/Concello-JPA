package domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Monitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100,nullable = false)
	@NotNull(message="Introduzca un nombre")
	@Size(min=5, max = 100)
	private String nombre;

	@Column(length = 9,unique = true, nullable = false)
	@NotNull(message="Introduzca un DNI")
	@Size(min=9, max = 9)
	private String dni;

	@Column(length = 50, nullable = false)
	@Size(min=6, max = 50)
	private String email;
	
	@Column(length = 100,nullable = false)
	@NotNull(message="Introduzca una dirección")
	@Size(min=5, max = 100)
	private String direccion;
	
	@Column(length = 5,nullable = false)
	@NotNull(message="Introduzca un código postal")
	private int cp;
	
	@Column(length = 50,nullable = false)
	@NotNull(message="Introduzca una localidad")
	@Size(min=2, max = 50)
	private String localidad;
	
	@Column(length = 30,nullable = false)
	@NotNull(message="Introduzca una provincia")
	@Size(min=2, max = 30)
	private String provincia;
	
	@Column(length = 9,nullable = false)
	@NotNull(message="Introduzca un teléfono")
	private int telefono;
	
	@Column(length = 15,nullable = true)
	@Size(min=0, max = 15)
	private String sueldo;
	
	@Column
	@NotNull(message="Activo o No activo")
	private String activo;
	
	@Column
	@NotNull(message="Seleccione un contrato")
	@Enumerated(EnumType.STRING)
	private Contrato contrato;
	
	@Column(length = 255,nullable = true)
	@Size(min=0, max = 250)
	private String observaciones_monitor;

	@XmlTransient
	@OneToMany( mappedBy = "monitor", cascade = CascadeType.ALL)
	private List<Actividad> actividadesImpartidas;


	/**
	 * Constructor a new instance of {@link Monitor} This constructor is empty
	 * because is required
	 */
	public Monitor() {

	}
	
	/**
	 * Constructor with parameters {@link Monitor}
	 * 
	 */
	
	public Monitor(String nombre, String dni, String email, String direccion, int cp, String localidad, String provincia, 
			int telefono, String sueldo, String activo, Contrato contrato, String observaciones_monitor) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.direccion = direccion;
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.activo = activo;
		this.contrato = contrato;
		this.observaciones_monitor = observaciones_monitor;	
		this.actividadesImpartidas = new ArrayList<Actividad>();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/**
	 * Override the hashCode method
	 * 
	 * @return id the hash code for the Monitor entity
	 */
	@Override
	public final int hashCode() {
		return id;
	}

	/**
	 * Override the equals method
	 * 
	 * @param obj
	 *            This is an Monitor to compare
	 * 
	 * @return if two monitores are equals or not
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (isNull(obj) || !(obj instanceof Monitor))
			return false;

		Monitor other = (Monitor) obj;
		if (isNull(obj)) {
			return isNull(other.dni);
		} else {
			return this.dni.equalsIgnoreCase(other.dni);
		}
	}

	/**
	 * Override the toString method
	 * 
	 * @return the Monitor object
	 */

	@Override
	public String toString() {
		return "Detalles del monitor \n"
				+ "Id " + id + " \n"
				+ "Nombre: " + nombre + " \n "
				+ "DNI: " + dni + " \n"
				+ "Email:" + email + " \n "
				+ "Direccion: " + direccion + " \n "
				+ "CP: " + cp + " \n "
				+ "Localidad " + localidad + " \n"
				+ "Provincia: " + provincia + " \n "
				+ "Telefono: " + telefono + " \n"
				+ "Sueldo: " + sueldo + " \n "
				+ "Activo:" + activo + " \n "
				+ "Contrato: " + contrato + " \n "
				+ "Observaciones del monitor: " + observaciones_monitor;
	}
	
}
