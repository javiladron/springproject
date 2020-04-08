package com.example.springproject.model;

public class ClienteModel {

	private Integer idCliente;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private String dni;
	
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public String getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
