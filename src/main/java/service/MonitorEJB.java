package service;

import java.util.ArrayList;
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

import domain.Contrato;
import domain.Monitor;


@PermitAll
@Stateless
public class MonitorEJB {
    
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Concello");
	
	@PersistenceContext
	EntityManager em = factory.createEntityManager();
	
	@Resource
	protected SessionContext ctx;
	
	private static Logger logger = Logger.getLogger(AlumnoEJB.class.getName());
	
	/*
	 * Creación de Monitor
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Monitor createMonitor(String nombre, String dni, String email, String direccion, int cp, String localidad, String provincia, 
			int telefono, String sueldo, boolean activo, Contrato contrato, String observaciones_monitor){
		
		Monitor monitorCreado = new Monitor(nombre, dni, email, direccion, cp, localidad, provincia,telefono,sueldo,activo,contrato,observaciones_monitor);

		em.getTransaction().begin();
		em.persist(monitorCreado);
		em.flush();
		em.getTransaction().commit();
		logger.log(Level.INFO, "La actividad " + monitorCreado.getNombre() + " ha sido creada.");
		return monitorCreado;
	}
	
	
	/*
	 * Búsqueda de monitores
	 */
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Monitor findMonitorById(int id) throws NoResultException {
		Monitor monitor = em.createQuery("SELECT m FROM Monitor m WHERE m.id=:i", Monitor.class).setParameter("i", id)
				.getSingleResult();
		return monitor;
	}
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)	
	public List<Monitor> findMonitorByNombre(final String text) throws EntityNotFoundException {
		List<Monitor> listMonitores = em.createQuery(
				"Select m FROM Monitor m WHERE m.nombre LIKE :text OR m.observaciones_monitor LIKE :text ",Monitor.class)
				.setParameter("text", "%" + text + "%").getResultList();
		if (listMonitores.size() == 0)
			throw new EntityNotFoundException("No coincide ningún nombre.");
		return listMonitores;
	}
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Monitor> getAllMonitores() {
		List<Monitor> monitores = new ArrayList<Monitor>();
		
		monitores.addAll(em.createQuery("Select m FROM Monitor m", Monitor.class).getResultList());
		return monitores;
	}
	
	/*
	 * Modificación de actividades
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void updateMonitor(final Monitor monitor)
			throws IllegalArgumentException, NoResultException{
		if (monitor == null) {
			throw new IllegalArgumentException("El monitor no existe.");
		}
		
		Monitor toUpdate = findMonitorById(monitor.getId());
		
		toUpdate.setNombre(monitor.getNombre());
		toUpdate.setDni(monitor.getDni());
		toUpdate.setEmail(monitor.getEmail());
		toUpdate.setDireccion(monitor.getDireccion());
		toUpdate.setCp(monitor.getCp());
		toUpdate.setLocalidad(monitor.getDireccion());
		toUpdate.setProvincia(monitor.getProvincia());
		toUpdate.setTelefono(monitor.getTelefono());
		toUpdate.setSueldo(monitor.getSueldo());
		toUpdate.setContrato(monitor.getContrato());
		toUpdate.setObservaciones_monitor(monitor.getObservaciones_monitor());
		toUpdate.setActividadesImpartidas(monitor.getActividadesImpartidas());

		em.getTransaction().begin();
		em.merge(toUpdate);
		em.flush();
		em.getTransaction().commit();
		logger.log(Level.INFO, "El monitor ha sido actualizada.");
	}

	
	/*
	 * Eliminar monitores
	 */
	
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void removeMonitor(Monitor monitorBorrar)
			throws NullPointerException, IllegalArgumentException {
		Monitor monitor = em.find(Monitor.class, monitorBorrar.getId());
		
		em.getTransaction().begin();
		em.remove(monitor);
		em.flush();
		em.getTransaction().commit();
		
		logger.log(Level.INFO, "El monitor " + monitor.getNombre() + " ha sido eliminado.");
	}

}
