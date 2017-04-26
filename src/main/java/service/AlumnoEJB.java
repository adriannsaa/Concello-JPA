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
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import domain.Alumno;

@PermitAll
@Stateless
public class AlumnoEJB {
	
	@PersistenceUnit
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MySqlDS");

	@PersistenceContext
	EntityManager em = factory.createEntityManager();

	@Resource
	protected SessionContext ctx;

	private static Logger logger = Logger.getLogger(AlumnoEJB.class.getName());

	/*
	 * Creación de alumno
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Alumno createAlumno(String nombre, String dni, int edad, String email, String direccion, int cp,
			String localidad, String provincia, int telefono, String nombre_autorizador, String dni_autorizador,
			String descuento, String observaciones_alumno,Date fechaAlta) {

		Alumno alumnoCreado = new Alumno(nombre, dni, edad, email, direccion, cp, localidad, provincia, telefono,
				nombre_autorizador, dni_autorizador, descuento, observaciones_alumno,fechaAlta);

		em.persist(alumnoCreado);
		em.flush();
		logger.log(Level.INFO, "El alumno " + alumnoCreado.getNombre() + " ha sido creado.");
		return alumnoCreado;
	}

	/*
	 * Búsqueda de alumnos
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Alumno findAlumnoByDNI(String dni) throws NoResultException {
		Alumno alumno = em.createQuery("SELECT a FROM Alumno a WHERE a.dni=:d", Alumno.class).setParameter("d", dni)
				.getSingleResult();
		return alumno;
	}

	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public Alumno findAlumnoById(int id) throws NoResultException {
		Alumno alumno = em.createQuery("SELECT a FROM Alumno a WHERE a.id=:i", Alumno.class).setParameter("i", id)
				.getSingleResult();
		return alumno;
	}

	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Alumno> findAlumnoByNombre(final String text) throws EntityNotFoundException {
		List<Alumno> listAlumnos = em
				.createQuery("Select a FROM Alumno a WHERE a.nombre LIKE :text OR a.nombre_autorizador LIKE :text ",
						Alumno.class)
				.setParameter("text", "%" + text + "%").getResultList();
		if (listAlumnos.size() == 0)
			throw new EntityNotFoundException("No coincide ningún nombre.");
		return listAlumnos;
	}

	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Alumno> getAllAlumnos() {
		List<Alumno> alumnos = new ArrayList<Alumno>();

		alumnos.addAll(em.createQuery("Select a FROM Alumno a ORDER BY a.id DESC", Alumno.class).getResultList());
		return alumnos;
	}

	/*
	 * Modificación de alumnos
	 */
	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void updateAlumno(final Alumno alumno) throws IllegalArgumentException, NoResultException {
		if (alumno == null) {
			throw new IllegalArgumentException("El alumno no existe.");
		}

		Alumno toUpdate = findAlumnoById(alumno.getId());

		toUpdate.setNombre(alumno.getNombre());
		toUpdate.setDni(alumno.getDni());
		toUpdate.setEdad(alumno.getEdad());
		toUpdate.setEmail(alumno.getEmail());
		toUpdate.setDireccion(alumno.getDireccion());
		toUpdate.setCp(alumno.getCp());
		toUpdate.setLocalidad(alumno.getLocalidad());
		toUpdate.setProvincia(alumno.getProvincia());
		toUpdate.setTelefono(alumno.getTelefono());
		toUpdate.setNombre_autorizador(alumno.getNombre_autorizador());
		toUpdate.setDni_autorizador(alumno.getDni_autorizador());
		toUpdate.setDescuento(alumno.getDescuento());
		toUpdate.setObservaciones_alumno(alumno.getObservaciones_alumno());
		toUpdate.setListaDeActividades(alumno.getListaDeActividades());

		em.merge(toUpdate);
		em.flush();
		
		logger.log(Level.INFO, "El alumno ha sido actualizado.");
	}

	/*
	 * Eliminar alumnos
	 */

	@PermitAll
	@Transactional(Transactional.TxType.SUPPORTS)
	public void removeAlumno(Alumno alumnoBorrar) throws NullPointerException, IllegalArgumentException {
		Alumno alumno = em.find(Alumno.class, alumnoBorrar.getId());

		em.remove(em.merge(alumnoBorrar)); //Al tenerlo en el mismo form que el edit hace falta el merge.
		em.flush();

		logger.log(Level.INFO, "El alumno " + alumno.getNombre() + " ha sido eliminado.");
	}

}
