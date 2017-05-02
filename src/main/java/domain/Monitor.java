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
import javax.persistence.FetchType;
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

	@Column(length = 50, nullable = true)
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
	@OneToMany( mappedBy = "monitor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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
	
	public void addActividadesImpartidas(Actividad actividad){
		actividadesImpartidas.add(actividad);
	};
	
	
	
	
	/**
	 * Override the hashCode method
	 * 
	 * @return id the hash code for the Monitor entity
	 */
	@Override
	public int hashCode() {
	final int prime = 31;
	int result = 1;
//	result = prime * result + ((activo == null) ? 0 : activo.hashCode());
	result = prime * result + cp;
	result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
	result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
	result = prime * result + telefono;
	return result;
	}

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (getClass() != obj.getClass())
	return false;
	Monitor other = (Monitor) obj;
//	if (!activo.equals(other.activo))
//	return false;
	if (cp != other.cp)
	return false;
	if (direccion == null) {
	if (other.direccion != null)
	return false;
	} else if (!direccion.equals(other.direccion))
	return false;
	if (dni == null) {
	if (other.dni != null)
	return false;
	} else if (!dni.equals(other.dni))
	return false;
	if (email == null) {
	if (other.email != null)
	return false;
	} else if (!email.equals(other.email))
	return false;
	if (localidad == null) {
	if (other.localidad != null)
	return false;
	} else if (!localidad.equals(other.localidad))
	return false;
	if (nombre == null) {
	if (other.nombre != null)
	return false;
	} else if (!nombre.equals(other.nombre))
	return false;
	if (provincia == null) {
	if (other.provincia != null)
	return false;
	} else if (!provincia.equals(other.provincia))
	return false;
	if (sueldo == null) {
	if (other.sueldo != null)
	return false;
	} else if (!sueldo.equals(other.sueldo))
	return false;
	if (telefono != other.telefono)
	return false;
	return true;
	}

//	/**
//	 * Override the toString method
//	 * 
//	 * @return the Monitor object
//	 */
//
//	@Override
//	public String toString() {
//		return "Detalles del monitor \n"
//				+ "Id " + id + " \n"
//				+ "Nombre: " + nombre + " \n "
//				+ "DNI: " + dni + " \n"
//				+ "Email:" + email + " \n "
//				+ "Direccion: " + direccion + " \n "
//				+ "CP: " + cp + " \n "
//				+ "Localidad " + localidad + " \n"
//				+ "Provincia: " + provincia + " \n "
//				+ "Telefono: " + telefono + " \n"
//				+ "Sueldo: " + sueldo + " \n "
//				+ "Activo:" + activo + " \n "
//				+ "Contrato: " + contrato + " \n "
//				+ "Observaciones del monitor: " + observaciones_monitor;
//	}
	
}
