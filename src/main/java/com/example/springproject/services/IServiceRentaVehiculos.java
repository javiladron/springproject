package com.example.springproject.services;

import java.util.List;

import com.example.springproject.model.VehiculoJPAModel;
import com.example.springproject.model.VehiculoModel;

public interface IServiceRentaVehiculos {
	
	public VehiculoModel getVehiculoByMatricula(String matricula);
	
	public List<VehiculoModel> getAllVehiculos();
	
	public VehiculoModel setVehiculo(VehiculoModel vehiculo);

	public List<VehiculoJPAModel> getAllVehiculosJPA();
	
	
}
