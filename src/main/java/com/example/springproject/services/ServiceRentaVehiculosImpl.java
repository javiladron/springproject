package com.example.springproject.services;

import org.springframework.stereotype.Service;

import com.example.springproject.model.CocheModel;
import com.example.springproject.model.VehiculoModel;

@Service
public class ServiceRentaVehiculosImpl implements IServiceRentaVehiculos{

	@Override
	public VehiculoModel getVehiculoByMatricula(String matricula) {
		CocheModel coche=new CocheModel();
		coche.setAnnioFab(Integer.valueOf(2012));
		coche.setDescripcion("Coche diesel gama baja de Volkswagen");
		coche.setModelo("Volkswagen Polo");
		coche.setMatricula("4538GYT");
		coche.setPeso(Double.valueOf(1450));
		coche.setModoAlquiler("basico");
		coche.setTipo("diesel");
		return coche;
	}
	
	
	
	

}
