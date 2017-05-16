package domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Alumno implements Serializable {

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

	@Column(length = 2,nullable = false)
	@NotNull(message="Introduzca una edad")
	private int edad;

	@Column(length = 50, nullable = false)

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
	
	@Column(length = 100,nullable = true)
	private String nombre_autorizador;
	
	@Column(length = 9,nullable = true)
	private String dni_autorizador;
	
	@Column(length = 6,nullable = true)
	private String descuento;
	
	@Column(length = 255,nullable = true)
	private String observaciones_alumno;
	
	@Column
	@NotNull(message="Introduzca una fecha")
	private Date fechaAlta;

	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@XmlTransient
	@JoinTable(name = "asistir", 
			joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "actividad_id", referencedColumnName = "id")
			)
	private List<Actividad> listaDeActividades = new ArrayList<Actividad>();


	/**
	 * Constructor a new instance of {@link Alumno} This constructor is empty
	 * because is required
	 */
	public Alumno() {

	}
	
	/**
	 * Constructor with parameters {@link Alumno}
	 * 
	 */
	public Alumno(String nombre, String dni, int edad, String email, String direccion, int cp, String localidad, String provincia, 
			int telefono, String nombre_autorizador, String dni_autorizador, String descuento, String observaciones_alumno,Date fechaAlta, List<Actividad> listaDeActividades) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.email = email;
		this.direccion = direccion;
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.nombre_autorizador = nombre_autorizador;
		this.dni_autorizador = dni_autorizador;
		this.descuento = descuento;
		this.observaciones_alumno = observaciones_alumno;	
		this.listaDeActividades = listaDeActividades;
		//this.setListaDeActividades(listaDeActividades);
		this.fechaAlta = new Date();
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
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Override the hashCode method
	 * 
	 * @return id the hash code for the Alumno entity
	 */
	@Override
	public final int hashCode() {
		return id;
	}
	
//	@Override
//	public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//
//	result = prime * result + edad;
//	result = prime * result + telefono;
//	result = prime * result + cp;
//	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
//	result = prime * result + ((email == null) ? 0 : email.hashCode());
//	result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
//	result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
//	result = prime * result + ((nombre_autorizador == null) ? 0 : nombre_autorizador.hashCode());
//	result = prime * result + ((dni_autorizador == null) ? 0 : dni_autorizador.hashCode());
//	result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
//	result = prime * result + ((observaciones_alumno == null) ? 0 : observaciones_alumno.hashCode());
//	result = prime * result + ((listaDeActividades == null) ? 0 : listaDeActividades.hashCode());
//	return result;
//	}
	/**
	 * Override the equals method
	 * 
	 * @param obj
	 *            This is an Alumno to compare
	 * 
	 * @return if two alumnos are equals or not
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (isNull(obj) || !(obj instanceof Alumno))
			return false;

		Alumno other = (Alumno) obj;
		if (isNull(obj)) {
			return false;
			} else {
			return this.dni.equalsIgnoreCase(other.dni);
			}
	}
//	
//	@Override
//	public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	if (getClass() != obj.getClass())
//		return false;
//	Alumno other = (Alumno) obj;
//	if (cp != other.cp)
//		return false;
//	if (direccion == null) {
//	if (other.direccion != null)
//	return false;
//	} else if (!direccion.equals(other.direccion))
//	return false;
//	if (dni == null) {
//	if (other.dni != null)
//	return false;
//	} else if (!dni.equals(other.dni))
//	return false;
//	if (email == null) {
//	if (other.email != null)
//	return false;
//	} else if (!email.equals(other.email))
//	return false;
//	if (localidad == null) {
//	if (other.localidad != null)
//	return false;
//	} else if (!localidad.equals(other.localidad))
//	return false;
//	if (nombre == null) {
//	if (other.nombre != null)
//	return false;
//	} else if (!nombre.equals(other.nombre))
//	return false;
//	if (provincia == null) {
//	if (other.provincia != null)
//	return false;
//	} else if (!provincia.equals(other.provincia))
//	return false;
//	if (listaDeActividades == null) {
//	if (other.listaDeActividades != null)
//	return false;
//	} else if (!listaDeActividades.equals(other.listaDeActividades))
//	return false;
//	if (telefono != other.telefono)
//	return false;
//	return true;
//	}


	/**
	 * Override the toString method
	 * 
	 * @return the Alumno object
	 */
	
	@Override
	public String toString() {
		return "Detalles del alumno \n"
				+ "Id " + id + " \n"
				+ "Nombre: " + nombre + " \n "
				+ "DNI: " + dni + " \n"
				+ "Edad: " + edad + " \n "
				+ "Email:" + email + " \n "
				+ "Direccion: " + direccion + " \n "
				+ "CP: " + cp + " \n "
				+ "Localidad " + localidad + " \n"
				+ "Provincia: " + provincia + " \n "
				+ "Telefono: " + telefono + " \n"
				+ "Nombre_Autorizador: " + nombre_autorizador + " \n "
				+ "Descuento:" + descuento + " \n "
				+ "Observaciones_Alumno: " + observaciones_alumno + " \n "
				+ "Fecha de alta: " + fechaAlta + " \n" 
				+ "Lista de actividades: " + listaDeActividades;
	}
	
}

