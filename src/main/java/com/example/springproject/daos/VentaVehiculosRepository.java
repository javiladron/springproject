package com.example.springproject.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.springproject.model.VehiculoModel;

/**
 * Clase repositorio que permite gestionar un garaje de vehiculos en memoria. No hay persistencia, no hay base de datos
 * @author jladron
 *
 */

@Component
public class VentaVehiculosRepository {
	
	private Map<String,VehiculoModel> garaje=new HashMap<String,VehiculoModel>();

	
	private VentaVehiculosRepository() {
		VehiculoModel coche=new VehiculoModel();
		coche.setAnnioFab(Integer.valueOf(2012));
		coche.setDescripcion("Coche diesel gama baja de Volkswagen");
		coche.setModelo("Volkswagen Polo");
		coche.setMatricula("4538GYT");
		coche.setPeso(Double.valueOf(1450));
		coche.setModoAlquiler("basico");
		coche.setCombustible("diesel");
		coche.setTipo("C");
		insertaNuevo(coche);
		coche=new VehiculoModel();
		coche.setAnnioFab(Integer.valueOf(2010));
		coche.setDescripcion("Coche gasolina de peugeot");
		coche.setModelo("Peugeout 407");
		coche.setMatricula("8831HUQ");
		coche.setPeso(Double.valueOf(975));
		coche.setModoAlquiler("todo riesgo");
		coche.setCombustible("gasolina");
		coche.setTipo("C");
		insertaNuevo(coche);
		VehiculoModel moto=new VehiculoModel();
		moto.setAnnioFab(Integer.valueOf(2015));
		moto.setDescripcion("Moto eléctrica de BMW");
		moto.setMatricula("1399AOT");
		moto.setModelo("BMW 360T");
		moto.setModoAlquiler("todo riesgo");
		moto.setPeso(Double.valueOf(159));
		coche.setTipo("M");
		insertaNuevo(moto);
		
	};
	
	
	public void insertaNuevo(VehiculoModel vehiculo) {
		garaje.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public VehiculoModel dameVehiculo(String matricula) {
		return garaje.get(matricula);
	}
	
	public List<VehiculoModel> dameTodos(){
		
		return new ArrayList<VehiculoModel>(garaje.values());
	}
	
	
	
	

}
