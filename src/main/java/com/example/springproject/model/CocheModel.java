package com.example.springproject.model;

public class CocheModel extends VehiculoModel{
	
	private String modelo;
	private String descripcion;
	private String tipo;//gasolina, diesel etc
	
	public String getModelo() {
		return modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
