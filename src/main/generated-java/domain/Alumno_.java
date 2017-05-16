package domain;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Alumno.class)
public abstract class Alumno_ {

	public static volatile SingularAttribute<Alumno, String> observaciones_alumno;
	public static volatile SingularAttribute<Alumno, String> nombre_autorizador;
	public static volatile SingularAttribute<Alumno, Date> fechaAlta;
	public static volatile SingularAttribute<Alumno, String> descuento;
	public static volatile SingularAttribute<Alumno, String> direccion;
	public static volatile SingularAttribute<Alumno, String> provincia;
	public static volatile SingularAttribute<Alumno, String> nombre;
	public static volatile SingularAttribute<Alumno, Integer> edad;
	public static volatile SingularAttribute<Alumno, Integer> cp;
	public static volatile ListAttribute<Alumno, Actividad> listaDeActividades;
	public static volatile SingularAttribute<Alumno, String> localidad;
	public static volatile SingularAttribute<Alumno, Integer> id;
	public static volatile SingularAttribute<Alumno, String> dni_autorizador;
	public static volatile SingularAttribute<Alumno, Integer> telefono;
	public static volatile SingularAttribute<Alumno, String> dni;
	public static volatile SingularAttribute<Alumno, String> email;

}

