package com.example.springproject.model;


import javax.persistence.*;

public class VehiculoModel {
	
	private Integer idVehiculo;
	private String modelo;
	private String descripcion;
	private String combustible;//gasolina, diesel etc
	private String tipo;
	private String matricula;
	private Integer annioFab;
	private Double peso;
	private String modoAlquiler;
	private ClienteModel cliente;
	
	public String getModelo() {
		return modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getCombustible() {
		return combustible;
	}
	public String getTipo() {
		return tipo;
	}
	public String getMatricula() {
		return matricula;
	}
	public Integer getAnnioFab() {
		return annioFab;
	}
	public Double getPeso() {
		return peso;
	}
	public String getModoAlquiler() {
		return modoAlquiler;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setAnnioFab(Integer annioFab) {
		this.annioFab = annioFab;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setModoAlquiler(String modoAlquiler) {
		this.modoAlquiler = modoAlquiler;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
}
