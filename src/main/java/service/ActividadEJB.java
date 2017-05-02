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
import domain.Monitor;


@PermitAll
@Stateless
public class ActividadEJB {
    
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MySqlDS");
	
	@PersistenceContext
	EntityManager em = factory.createEntityManager();
	
	@Resource
	protected SessionContext ctx;
	
	private static Logger logger = Logger.getLogger(Actividad.class.getName());
	
	/*
	 * Creación de Actividad
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Actividad createActividad(String nombre, Monitor monitor, int participantes, 
			String horario, String lugar, String material, String observaciones_actividad){
		
		Actividad actividadCreada = new Actividad(nombre, monitor, participantes, horario, lugar, material, observaciones_actividad);

		em.persist(em.merge(actividadCreada));
		em.flush();
		
		logger.log(Level.INFO, "La actividad " + actividadCreada.getNombre() + " ha sido creada.");
		return actividadCreada;
	}
	
	
	/*
	 * Búsqueda de actvidades
	 */
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
	public List<Actividad> getAllActividades() {
		List<Actividad> actividades = new ArrayList<Actividad>();
		
		actividades.addAll(em.createQuery("Select a FROM Actividad a ORDER BY a.id DESC", Actividad.class).getResultList());
		return actividades;
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

		em.merge(toUpdate);
		em.flush();
		
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
		
		em.remove(em.merge(actividad));
		em.flush();
		
		logger.log(Level.INFO, "La actividad " + actividad.getNombre() + " ha sido eliminada.");
	}

}
