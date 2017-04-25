package jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Alumno;
import service.AlumnoEJB;

@Named(value = "alumnosDetailsBean")
@SessionScoped
public class AlumnosDetailsBean implements Serializable {
	
	@Inject
	AlumnoEJB alumnoEjb;

	private static final long serialVersionUID = 1L;

	private Alumno alumnoDetails;
	private Alumno alumnoSaved;
	private Alumno alumnoDelete;


	public Alumno getAlumnoDetails() {
		return alumnoDetails;
	}

	public void setAlumnoDetails(Alumno alumnoDetails) {
		this.alumnoDetails = alumnoDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getDetailsAlumno(int id){
		this.alumnoDetails = alumnoEjb.findAlumnoById(id);
		return "alumnoDetails";
	}
	
	public String saveDetailsAlumno(int id){
	
		alumnoSaved = alumnoEjb.findAlumnoById(id);
		
		alumnoSaved.setNombre(alumnoDetails.getNombre());
		alumnoSaved.setDni(alumnoDetails.getDni());
		alumnoSaved.setEdad(alumnoDetails.getEdad());
		alumnoSaved.setEmail(alumnoDetails.getEmail());
		alumnoSaved.setDireccion(alumnoDetails.getDireccion());
		alumnoSaved.setCp(alumnoDetails.getCp());
		alumnoSaved.setLocalidad(alumnoDetails.getLocalidad());
		alumnoSaved.setProvincia(alumnoDetails.getProvincia());
		alumnoSaved.setTelefono(alumnoDetails.getTelefono());
		alumnoSaved.setNombre_autorizador(alumnoDetails.getNombre_autorizador());
		alumnoSaved.setDni_autorizador(alumnoDetails.getDni_autorizador());
		alumnoSaved.setDescuento(alumnoDetails.getDescuento());
		alumnoSaved.setObservaciones_alumno(alumnoDetails.getObservaciones_alumno());
		alumnoSaved.setListaDeActividades(alumnoDetails.getListaDeActividades());
		
		alumnoEjb.updateAlumno(alumnoSaved);
		return "alumnos";
	}
	
	public String deleteAlumno(int id){
		
		alumnoDelete = alumnoEjb.findAlumnoById(id);
		alumnoEjb.removeAlumno(alumnoDelete);
		
		return "alumnos";
	}
}
