package domain;


import javax.inject.Inject;

import service.AlumnoEJB;

public class Main {
	
	@Inject
	static AlumnoEJB alumnoEjb = new AlumnoEJB();
	
	public static void main (String[] args)
	{
		Alumno alumnoPrueba2= new Alumno("Adrian", "33551492N", 28, "aasdf@gmail.com", "BernardoCahcha", 32004, "Ourense", "Ourense", 646867768,"Ramon" ,"33551498P" ,"30%" , "Prueba1");
		System.out.println(alumnoPrueba2.getDni());
		Alumno alumnoPrueba= alumnoEjb.createAlumno("NombrePrueba", "31511492N", 23, "rff@gmail.com", "asdf", 35004, "tr", "rtg", 666867768,"dfg" ,"37551498P" ,"32%" , "Prueba2");
		System.out.println(alumnoPrueba.getDni());
		String pruebaEjb= alumnoEjb.prueba();
		System.out.println(pruebaEjb);
	}
}
