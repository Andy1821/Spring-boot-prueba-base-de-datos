package com.alumnosDB;

public class Alumno {
	private int matricula;
	private String nombre;
	private String apellido;
	private int grupo;
	private String materia;
	private float calificacion;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	public Alumno(int matricula, String nombre, String apellido, int grupo, String materia, float calificacion) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.grupo = grupo;
		this.materia = materia;
		this.calificacion = calificacion;
	}
	
}
