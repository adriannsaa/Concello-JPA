package domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@NotNull(message="Introduzca un Email")
	@Size(min=6, max = 50)
	private String email;
	
	@Column(length = 100,nullable = false)
	@NotNull(message="Introduzca una durección")
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
	@Size(min=5, max = 30)
	private String provincia;
	
	@Column(length = 9,nullable = false)
	@NotNull(message="Introduzca un teléfono")
	private int telefono;
	
	@Column(length = 100,nullable = true)
	@Size(min=5, max = 100)
	private String nombre_autorizador;
	
	@Column(length = 9,nullable = true)
	@Size(min=9, max = 9)
	private String dni_autorizador;
	
	@Column(length = 6,nullable = true)
	@Size(min=0, max = 6)
	private String descuento;
	
	@Column(length = 255,nullable = true)
	@Size(min=0, max = 250)
	private String observaciones_alumno;

	@ManyToMany
	@XmlTransient
	@JoinTable(name = "Asistir", 
			joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "actividad_id", referencedColumnName = "id")
			)
	private List<Actividad> listaDeActividades;


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
			int telefono, String nombre_autorizador, String dni_autorizador, String descuento, String observaciones_alumno) {
		
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
		this.listaDeActividades = new ArrayList<Actividad>();
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
	
	/**
	 * Override the hashCode method
	 * 
	 * @return id the hash code for the Alumno entity
	 */
	@Override
	public final int hashCode() {
		return id;
	}

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
			return isNull(other.dni);
		} else {
			return this.dni.equalsIgnoreCase(other.dni);
		}
	}

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
				+ "Lista de actividades: " + listaDeActividades;
	}
	
}

