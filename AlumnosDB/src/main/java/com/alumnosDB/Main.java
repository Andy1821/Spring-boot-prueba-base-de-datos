package com.alumnosDB;

import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static DB db = new DB();
	public static void menu() {
		System.out.println("\n------------------------------------------");
		System.out.println("\n\t[BASE DE DATOS ALUMNOS]");
		System.out.println("Opciones:");
		System.out.println("[1] Nuevo alumno.");
		System.out.println("[2] Actualizar alumno.");
		System.out.println("[3] Borrar alumno.");
		System.out.println("[4] Imprimir lista de alumnos.");
		System.out.println("[5] Salir.");
		System.out.println("\nElija su opción: ");
	}
	
	public static void op1() { //Nuevo alumno
		int matricula;
		String nombre;
		String apellido;
		int grupo;
		String materia;
		float calificacion;
		System.out.println("\n------------------------------------------");
		System.out.println("\n[NUEVO ALUMNO]");
		System.out.println("Ingrese la matrícula: ");
		matricula = scan.nextInt();
		scan.nextLine();
		if(db.alumnoExists(matricula)) {
			System.out.println("\n¡Esa matrícula está ocupada!");
		}else {
			System.out.println("Ingrese el nombre: ");
			nombre = scan.nextLine();
			System.out.println("Ingrese el apellido: ");
			apellido = scan.nextLine();
			System.out.println("Ingrese el grupo (número): ");
			grupo = scan.nextInt();
			scan.nextLine();
			System.out.println("Ingrese la materia: ");
			materia = scan.nextLine();
			System.out.println("\nIngrese la calificacion: ");
			calificacion = scan.nextFloat();
			db.newAlumno(matricula, nombre, apellido, grupo, materia, calificacion);
		}
	}
	
	public static void op2() { //Actualizar alumno
		int op = 0;
		int matricula;
		int matriculaNueva;
		String nombreNuevo;
		String apellidoNuevo;
		int grupoNuevo;
		String materiaNueva;
		float calificacionNueva;
		Alumno al;
		System.out.println("\n------------------------------------------");
		System.out.println("\n[ACTUALIZAR ALUMNO]");
		System.out.println("\nIngrese la matricula:");
		matricula = scan.nextInt();
		if(db.alumnoExists(matricula)) {
			do {
				al = db.searchAlumno(matricula);
				System.out.println("\n( Actualizando matricula )");
				System.out.println("¿Qué desea modificar?");
				System.out.println("\n[1] Matrícula: " + al.getMatricula());
				System.out.println("[2] Nombre: " + al.getNombre());
				System.out.println("[3] Apellido: " + al.getApellido());
				System.out.println("[4] Grupo: " + al.getGrupo());
				System.out.println("[5] Materia: " + al.getMateria());
				System.out.println("[6] Calificación: " + al.getCalificacion());
				System.out.println("[7] Volver.");
				System.out.println("\nElija su opción: ");
				op = scan.nextInt();
				scan.nextLine();
				switch(op) {
				case 1:
					System.out.println("\n\nIngrese la nueva matricula:");
					matriculaNueva = scan.nextInt();
					db.updateMatricula(matricula, matriculaNueva);
					matricula = matriculaNueva;
					break;
				case 2:
					System.out.println("\n\nIngrese el nuevo nombre:");
					nombreNuevo = scan.nextLine();
					db.updateNombre(matricula, nombreNuevo);
					break;
				case 3:
					System.out.println("\n\nIngrese el nuevo apellido:");
					apellidoNuevo = scan.nextLine();
					db.updateApellido(matricula, apellidoNuevo);
					break;
				case 4:
					System.out.println("\n\nIngrese el nuevo grupo (número):");
					grupoNuevo = scan.nextInt();
					scan.nextLine();
					db.updateGrupo(matricula, grupoNuevo);
					break;
				case 5:
					System.out.println("\n\nIngrese la nueva materia:");
					materiaNueva = scan.nextLine();
					db.updateMateria(matricula, materiaNueva);
					break;
				case 6:
					System.out.println("\n\nIngrese la nueva calificacion:");
					calificacionNueva = scan.nextFloat();
					scan.nextLine();
					db.updateCalificacion(matricula, calificacionNueva);
					break;
				}
			}while(op!=7);
		}else {
			System.out.println("\n¡Esa matrícula no existe!");
		}
	}
	
	public static void op3() { //Borrar alumno
		int matricula;
		System.out.println("\n------------------------------------------");
		System.out.println("\n[BORRAR ALUMNO]");
		System.out.println("Ingrese la matrícula: ");
		matricula = scan.nextInt();
		db.deleteAlumno(matricula);
	}
	
	public static void op4() { //Imprimir lista de alumnos
		String continuar;
		System.out.println("\n------------------------------------------");
		System.out.println("\n[LISTA DE ALUMNOS]");
		db.printLista();
		System.out.println("\n\nPresione enter para continuar...");
	}
	
	public static void main(String[] args) {
		int op = 0;
		do {
			menu();
			op = scan.nextInt();
			switch(op) {
			case 1:
				op1();
				break;
			case 2:
				op2();
				break;
			case 3:
				op3();
				break;
			case 4:
				op4();
				break;
			}
		}while(op!=5);
	}

}
