package domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Monitor.class)
public abstract class Monitor_ {

	public static volatile SingularAttribute<Monitor, String> direccion;
	public static volatile SingularAttribute<Monitor, String> sueldo;
	public static volatile SingularAttribute<Monitor, Contrato> contrato;
	public static volatile ListAttribute<Monitor, Actividad> actividadesImpartidas;
	public static volatile SingularAttribute<Monitor, String> provincia;
	public static volatile SingularAttribute<Monitor, String> nombre;
	public static volatile SingularAttribute<Monitor, Integer> cp;
	public static volatile SingularAttribute<Monitor, String> observaciones_monitor;
	public static volatile SingularAttribute<Monitor, String> localidad;
	public static volatile SingularAttribute<Monitor, Integer> id;
	public static volatile SingularAttribute<Monitor, Integer> telefono;
	public static volatile SingularAttribute<Monitor, String> dni;
	public static volatile SingularAttribute<Monitor, String> email;
	public static volatile SingularAttribute<Monitor, String> activo;

}

