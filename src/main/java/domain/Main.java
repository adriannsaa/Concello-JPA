package domain;


import javax.inject.Inject;

import service.AlumnoEJB;

public class Main {
	
	@Inject
	static AlumnoEJB alumnoEjb = new AlumnoEJB();
	
	public static void main (String[] args)
	{
		Alumno alumnoPrueba= alumnoEjb.createAlumno("Adrian", "33551492N", 28, "aasdf@gmail.com", "BernardoCahcha", 32004, "Ourense", "Ourense", 646867768,"Ramon" ,"33551498P" ,"30%" , "Prueba1");
		System.out.println(alumnoPrueba.getDni());
		//alumnoEjb.removeAlumno(alumnoPrueba);
	}
}
