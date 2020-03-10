package com.example.springproject.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springproject.model.VehiculoModel;

public class VentaVehiculosRepository {
	
	private Map<String,VehiculoModel> garage=new HashMap<String,VehiculoModel>();

	private static VentaVehiculosRepository instance=null;
	
	private VentaVehiculosRepository() {};
	
	public static VentaVehiculosRepository getInstance() {
		if(instance==null) {
			instance=new VentaVehiculosRepository();
		}
		return instance;
	}
	
	public void insertaNuevo(VehiculoModel vehiculo) {
		garage.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public VehiculoModel dameVehiculo(String matricula) {
		return garage.get(matricula);
	}
	
	public List<VehiculoModel> dameTodos(){
		
		return new ArrayList<VehiculoModel>(garage.values());
	}
	
	
	
	

}
