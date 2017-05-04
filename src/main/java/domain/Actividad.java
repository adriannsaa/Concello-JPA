package domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	@ManyToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Asistir", 
	joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "actividad_id", referencedColumnName = "id")
	)
	private List<Alumno> listaDeAlumnos;

	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "monitor_id")
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
	
	public void addAlumno(Alumno alumno){
		this.listaDeAlumnos.add(alumno);
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
	
//	@Override
//	public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//
//	result = prime * result + participantes;
//	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//	result = prime * result + ((monitor == null) ? 0 : monitor.hashCode());
//	result = prime * result + ((horario== null) ? 0 : horario.hashCode());
//	result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
//	result = prime * result + ((material == null) ? 0 : material.hashCode());
//	result = prime * result + ((observaciones_actividad == null) ? 0 : observaciones_actividad.hashCode());
//	result = prime * result + ((listaDeAlumnos == null) ? 0 : listaDeAlumnos.hashCode());
//
//	return result;
//	}

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
			return false;
			} else {
			return this.nombre.equalsIgnoreCase(other.nombre);
			}
	}
//	@Override
//	public boolean equals(Object obj) {
//	if (this == obj)
//	return true;
//	if (obj == null)
//	return false;
//	if (getClass() != obj.getClass())
//	return false;
//	Actividad other = (Actividad) obj;
//	if (nombre == null) {
//	if (other.nombre != null)
//	return false;
//	} else if (!nombre.equals(other.nombre))
//	return false;
//	if (monitor == null) {
//	if (other.monitor != null)
//	return false;
//	} else if (!monitor.equals(other.monitor))
//	return false;
//	if (horario == null) {
//	if (other.horario != null)
//	return false;
//	} else if (!horario.equals(other.horario))
//	return false;
//	if (lugar == null) {
//	if (other.lugar != null)
//	return false;
//	} else if (!lugar.equals(other.lugar))
//	return false;
//	if (material == null) {
//	if (other.material != null)
//	return false;
//	} else if (!material.equals(other.material))
//	return false;
//	if (observaciones_actividad == null) {
//	if (other.observaciones_actividad != null)
//	return false;
//	} else if (!observaciones_actividad.equals(other.observaciones_actividad))
//	return false;
//	if (listaDeAlumnos == null) {
//	if (other.listaDeAlumnos != null)
//	return false;
//	} else if (!listaDeAlumnos.equals(other.listaDeAlumnos))
//	return false;
//	if (participantes != other.participantes)
//	return false;
//	return true;
//	}

	/**
	 * Override the toString method
	 * 
	 * @return the actividad object
	 */
	
	@Override
	public String toString() {
//		return "Detalles de la actividad \n"
//				+ "Id " + id + " \n"
//				+ "Nombre: " + nombre + " \n "
//				+ "Monitor: " + monitor + " \n"
//				+ "Participantes: " + participantes + " \n "
//				+ "Horario:" + horario + " \n "
//				+ "Lugar: " + lugar + " \n "
//				+ "Material: " + material + " \n "
//				+ "Observariones_Actividad " + observaciones_actividad + " \n"
//				+ "Lista de alumnos: " + listaDeAlumnos;
		
		return nombre;
	}


}


