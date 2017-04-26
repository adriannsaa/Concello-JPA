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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Actividad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100,nullable = false)
	@NotNull(message="Introduzca el nombre de la actividad")
	@Size(min=5, max = 100)
	private String nombre;

	@Column(length = 3,nullable = true)
	@NotNull(message="Introduzca el número de participantes")
	private int participantes;

	@Column(length = 200, nullable = false)
	@NotNull(message="Introduzca un horario")
	@Size(min=6, max = 200)
	private String horario;
	
	@Column(length = 50,nullable = false)
	@NotNull(message="Introduzca un lugar")
	@Size(min=5, max = 50)
	private String lugar;
	
	@Column(length = 500,nullable = true)
	@Size(min=0, max = 500)
	private String material;
	
	@Column(length = 255,nullable = true)
	@Size(min=0, max = 255)
	private String observaciones_actividad;
	
	@ManyToMany(mappedBy="listaDeActividades")
	private List<Alumno> listaDeAlumnos;

	@ManyToOne
	@JoinColumn(name = "actividad_monitor")
	private Monitor monitor;

	/**
	 * Constructor a new instance of {@link Actividad} This constructor is empty
	 * because is required
	 */
	public Actividad() {

	}
	
	/**
	 * Constructor with parameters {@link Actividad}
	 * 
	 */
	public Actividad(String nombre, Monitor monitor, int participantes, String horario, String lugar, String material, String observaciones_actividad){
		
		this.nombre = nombre;
		this.monitor = monitor;
		this.participantes = participantes;
		this.horario = horario;
		this.lugar = lugar;
		this.material = material;
		this.observaciones_actividad = observaciones_actividad;
		this.listaDeAlumnos = new ArrayList<Alumno>();
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

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Override the hashCode method
	 * 
	 * @return id the hash code for the Actividad entity
	 */
	@Override
	public final int hashCode() {
		return id;
	}

	/**
	 * Override the equals method
	 * 
	 * @param obj
	 *            This is an Actividad to compare
	 * 
	 * @return if two actividades are equals or not
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (isNull(obj) || !(obj instanceof Actividad))
			return false;

		Actividad other = (Actividad) obj;
		if (isNull(obj)) {
			return isNull(other.nombre);
		} else {
			return this.nombre.equalsIgnoreCase(other.nombre);
		}
	}

	/**
	 * Override the toString method
	 * 
	 * @return the actividad object
	 */
	
	@Override
	public String toString() {
		return "Detalles de la actividad \n"
				+ "Id " + id + " \n"
				+ "Nombre: " + nombre + " \n "
				+ "Monitor: " + monitor + " \n"
				+ "Participantes: " + participantes + " \n "
				+ "Horario:" + horario + " \n "
				+ "Lugar: " + lugar + " \n "
				+ "Material: " + material + " \n "
				+ "Observariones_Actividad " + observaciones_actividad + " \n"
				+ "Lista de alumnos: " + listaDeAlumnos;
	}
	
}


