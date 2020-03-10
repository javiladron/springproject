package com.example.springproject.model;

public class VehiculoModel {
	
	private String matricula;
	private Integer annioFab;
	private Double peso;
	private String modoAlquiler;
	
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
	
	

}
