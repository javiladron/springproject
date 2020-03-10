package com.example.springproject.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springproject.model.VehiculoModel;

/**
 * Clase repositorio que permite gestionar un garaje de vehiculos en memoria. No hay persistencia, no hay base de datos
 * @author jladron
 *
 */
public class VentaVehiculosRepository {
	
	private Map<String,VehiculoModel> garaje=new HashMap<String,VehiculoModel>();

	private static VentaVehiculosRepository instance=null;
	
	private VentaVehiculosRepository() {};
	
	public static VentaVehiculosRepository getInstance() {
		if(instance==null) {
			instance=new VentaVehiculosRepository();
		}
		return instance;
	}
	
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
