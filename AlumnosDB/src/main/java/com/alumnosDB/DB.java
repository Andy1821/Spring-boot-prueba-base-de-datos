package com.alumnosDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private String url;
	private String user;
	private String pass;
	
	public Alumno searchAlumno(int matricula) {
		String nombre;
		String apellido;
		int grupo;
		String materia;
		float calificacion;
		Alumno alumno = null;
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumno");
			while(rs.next()) {
				if(rs.getInt("matricula") == matricula) {
					nombre = rs.getString("nombre");
					apellido = rs.getString("apellido");
					grupo = rs.getInt("grupo");
					materia = rs.getString("materia");
					calificacion = rs.getFloat("calificacion");
					alumno = new Alumno(matricula, nombre, apellido, grupo, materia, calificacion);
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumno;
	}
	
	public void newAlumno(int matricula, String nombre, String apellido, int grupo, String materia, float calificacion) {
		if(!alumnoExists(matricula)) {
			try {
				
				Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO alumno "
						+ "(matricula, nombre, apellido, grupo, materia, calificacion) "
						+ "VALUES (?, ?, ?, ?, ?, ?)"
						);
				ps.setInt(1, matricula);
				ps.setString(2, nombre);
				ps.setString(3, apellido);
				ps.setInt(4, grupo);
				ps.setString(5, materia);
				ps.setFloat(6, calificacion);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAlumno(int matricula) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"DELETE FROM alumno WHERE matricula = ?"
					);
			ps.setInt(1, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMatricula(int matricula, int matriculaNueva) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET matricula = ? "
					+ "WHERE matricula = ?"
					);
			ps.setInt(1, matriculaNueva);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateNombre(int matricula, String nombreNuevo) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET nombre = ? "
					+ "WHERE matricula = ?"
					);
			ps.setString(1, nombreNuevo);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateApellido(int matricula, String apellidoNuevo) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET apellido = ? "
					+ "WHERE matricula = ?"
					);
			ps.setString(1, apellidoNuevo);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateGrupo(int matricula, int grupoNuevo) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET grupo = ? "
					+ "WHERE matricula = ?"
					);
			ps.setInt(1, grupoNuevo);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void updateMateria(int matricula, String materiaNueva) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET materia = ? "
					+ "WHERE matricula = ?"
					);
			ps.setString(1, materiaNueva);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCalificacion(int matricula, float calificacionNueva) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE alumno "
					+ "SET calificacion = ? "
					+ "WHERE matricula = ?"
					);
			ps.setFloat(1, calificacionNueva);
			ps.setInt(2, matricula);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean alumnoExists(int matricula) {
		boolean existe = false;
		try {
			Connection con = DriverManager.getConnection(this.url, this.user,this. pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumno");
			while(rs.next()) {
				if(rs.getInt("matricula") == matricula) {
					existe = true;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public void printLista() {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumno");
			while(rs.next()) {
				System.out.println(
						"\nMatrícula: " + rs.getInt("matricula") +
						"\nNombre: " + rs.getString("nombre") +
						"\nApellido: " + rs.getString("apellido") +
						"\nGrupo: " + rs.getString("grupo") +
						"\nMateria: " + rs.getString("materia") + 
						"\nCalificación: " + rs.getString("calificacion")
						);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printAlumno(int matricula) {
		try {
			Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumno");
			while(rs.next()) {
				if(rs.getInt("matricula") == matricula) {
					System.out.println(
							"\nMatrícula: " + rs.getInt("matricula") +
							"\nNombre: " + rs.getString("nombre") +
							"\nApellido: " + rs.getString("apellido") +
							"\nGrupo: " + rs.getString("grupo") +
							"\nMateria: " + rs.getString("materia") + 
							"\nCalificación: " + rs.getString("calificacion")
							);
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DB() {
		this.url = "jdbc:mysql://localhost:3306/escuela?serverTimezone=America/Monterrey";
		this.user = "root";
		this.pass = "GF2FmE5R";
	}
}
