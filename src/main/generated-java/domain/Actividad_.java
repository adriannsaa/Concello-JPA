package domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Actividad.class)
public abstract class Actividad_ {

	public static volatile ListAttribute<Actividad, Alumno> listaDeAlumnos;
	public static volatile SingularAttribute<Actividad, String> horario;
	public static volatile SingularAttribute<Actividad, String> material;
	public static volatile SingularAttribute<Actividad, String> lugar;
	public static volatile SingularAttribute<Actividad, String> observaciones_actividad;
	public static volatile SingularAttribute<Actividad, Monitor> monitor;
	public static volatile SingularAttribute<Actividad, Integer> id;
	public static volatile SingularAttribute<Actividad, String> nombre;
	public static volatile SingularAttribute<Actividad, Integer> participantes;

}

