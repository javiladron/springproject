package com.example.springproject.services;

import com.example.springproject.model.VehiculoModel;

public interface IServiceRentaVehiculos {
	
	public VehiculoModel getVehiculoByMatricula(String matricula);
}
