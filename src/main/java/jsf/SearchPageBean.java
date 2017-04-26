package jsf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.validation.constraints.Size;

import domain.Actividad;
import domain.Alumno;
import domain.Monitor;
import service.ActividadEJB;
import service.AlumnoEJB;
import service.MonitorEJB;

@Named(value = "searchPageBean")
@ApplicationScoped
public class SearchPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Size(min = 0, max = 1090, message = "Unsupported text")
	private String textSearch;
	private List<Actividad> matchedActividadList;
	private List<Alumno> matchedAlumnoList;
	private List<Monitor> matchedMonitorList;
	
	@Inject
	private AlumnoEJB alumnoEjb;
	@Inject
	private ActividadEJB actividadEjb;
	@Inject
	private MonitorEJB monitorEjb;

	public SearchPageBean() {

	}

	public String getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}

	public List<Actividad> getMatchedActividadList() {
		return matchedActividadList;
	}

	public void setMatchedActividadList(List<Actividad> matchedActividadList) {
		this.matchedActividadList = matchedActividadList;
	}

	public List<Alumno> getMatchedAlumnoList() {
		return matchedAlumnoList;
	}

	public void setMatchedAlumnoList(List<Alumno> matchedAlumnoList) {
		this.matchedAlumnoList = matchedAlumnoList;
	}

	public List<Monitor> getMatchedMonitorList() {
		return matchedMonitorList;
	}

	public void setMatchedMonitorList(List<Monitor> matchedMonitorList) {
		this.matchedMonitorList = matchedMonitorList;
	}
	
	/**
	 * Inner call to the search event
	 *
	 * @return the search page
	 */
	public String doSearch() {
		try {
			matchedAlumnoList = alumnoEjb.findAlumnoByNombre(textSearch);

		} catch (EJBException e){
			// TODO: Check the if the exception is EntityNotFoundException and
			// show the not found event
			return "searchNotFound";
		}

		setTextSearch(textSearch);

		return "search";
	}

}
