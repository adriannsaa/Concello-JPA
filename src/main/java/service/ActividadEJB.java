package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import domain.Actividad;
import domain.Alumno;
import domain.Monitor;


@PermitAll
@Stateless
public class ActividadEJB {
    
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Concello");
	
	@PersistenceContext
	EntityManager em = factory.createEntityManager();
	
	@Resource
	protected SessionContext ctx;
	
	private static Logger logger = Logger.getLogger(AlumnoEJB.class.getName());
	
	/*
	 * Creación de Actividad
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Actividad createActividad(String nombre, Monitor monitor, int participantes, 
			Date horario, String lugar, String material, String observaciones_actividad){
		
		Actividad actividadCreada = new Actividad(nombre, monitor, participantes, horario, lugar, material, observaciones_actividad);

		em.getTransaction().begin();
		em.persist(actividadCreada);
		em.flush();
		em.getTransaction().commit();
		logger.log(Level.INFO, "La actividad " + actividadCreada.getNombre() + " ha sido creada.");
		return actividadCreada;
	}
	
	
	/*
	 * Búsqueda de actvidades
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Actividad> getAllActividades() throws NoResultException {
		List<Actividad> listActividades = em.createQuery("SELECT a FROM Actividad", Actividad.class).getResultList();
		return listActividades;
	}
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Actividad findActividadById(int id) throws NoResultException {
		Actividad actividad = em.createQuery("SELECT a FROM Actividad a WHERE a.id=:i", Actividad.class).setParameter("i", id)
				.getSingleResult();
		return actividad;
	}
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)	
	public List<Actividad> findActividadByNombre(final String text) throws EntityNotFoundException {
		List<Actividad> listActividades = em.createQuery(
				"Select a FROM Actividad a WHERE a.nombre LIKE :text OR a.observaciones_actividad LIKE :text ",Actividad.class)
				.setParameter("text", "%" + text + "%").getResultList();
		if (listActividades.size() == 0)
			throw new EntityNotFoundException("No coincide ningún nombre.");
		return listActividades;
	}
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Alumno> getAllAlumnos() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.addAll(em.createQuery("Select a FROM Alumno ", Alumno.class).getResultList());
		return alumnos;
	}
	
	/*
	 * Modificación de actividades
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void updateActividad(final Actividad actividad)
			throws IllegalArgumentException, NoResultException{
		if (actividad == null) {
			throw new IllegalArgumentException("La actividad no existe.");
		}
		
		Actividad toUpdate = findActividadById(actividad.getId());
		
		toUpdate.setNombre(actividad.getNombre());
		toUpdate.setMonitor(actividad.getMonitor());
		toUpdate.setParticipantes(actividad.getParticipantes());
		toUpdate.setHorario(actividad.getHorario());
		toUpdate.setLugar(actividad.getLugar());
		toUpdate.setMaterial(actividad.getMaterial());
		toUpdate.setObservaciones_actividad(actividad.getObservaciones_actividad());
		toUpdate.setListaDeAlumnos(actividad.getListaDeAlumnos());

		em.getTransaction().begin();
		em.merge(toUpdate);
		em.flush();
		em.getTransaction().commit();
		logger.log(Level.INFO, "La actividad ha sido actualizada.");
	}

	
	/*
	 * Eliminar actividades
	 */
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void removeActividad(Actividad actividadBorrar)
			throws NullPointerException, IllegalArgumentException {
		Actividad actividad = em.find(Actividad.class, actividadBorrar.getId());
		
		em.getTransaction().begin();
		em.remove(actividad);
		em.flush();
		em.getTransaction().commit();
		
		logger.log(Level.INFO, "La actividad " + actividad.getNombre() + " ha sido eliminada.");
	}

}