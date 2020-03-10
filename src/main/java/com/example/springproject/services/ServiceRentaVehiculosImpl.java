package com.example.springproject.services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.springproject.daos.VentaVehiculosRepository;
import com.example.springproject.model.CocheModel;
import com.example.springproject.model.MotoModel;
import com.example.springproject.model.VehiculoModel;

@Service
public class ServiceRentaVehiculosImpl implements IServiceRentaVehiculos{
	
	VentaVehiculosRepository repoVehiculos=null;
	
	private ServiceRentaVehiculosImpl() {
		repoVehiculos=VentaVehiculosRepository.getInstance();
		
		List<VehiculoModel> listadoFlota=repoVehiculos.dameTodos();
		
		if(CollectionUtils.isEmpty(listadoFlota)) {
			CocheModel coche=new CocheModel();
			coche.setAnnioFab(Integer.valueOf(2012));
			coche.setDescripcion("Coche diesel gama baja de Volkswagen");
			coche.setModelo("Volkswagen Polo");
			coche.setMatricula("4538GYT");
			coche.setPeso(Double.valueOf(1450));
			coche.setModoAlquiler("basico");
			coche.setTipo("diesel");
			repoVehiculos.insertaNuevo(coche);
			coche=new CocheModel();
			coche.setAnnioFab(Integer.valueOf(2010));
			coche.setDescripcion("Coche gasolina de peugeot");
			coche.setModelo("Peugeout 407");
			coche.setMatricula("8831HUQ");
			coche.setPeso(Double.valueOf(975));
			coche.setModoAlquiler("todo riesgo");
			coche.setTipo("gasolina");
			repoVehiculos.insertaNuevo(coche);
			MotoModel moto=new MotoModel();
			moto.setAnnioFab(Integer.valueOf(2015));
			moto.setDescripcion("Moto eléctrica de BMW");
			moto.setMatricula("1399AOT");
			moto.setModelo("BMW 360T");
			moto.setModoAlquiler("todo riesgo");
			moto.setPeso(Double.valueOf(159));
			repoVehiculos.insertaNuevo(moto);
			
			
		}
	}

	@Override
	public VehiculoModel getVehiculoByMatricula(String matricula) {
		repoVehiculos=VentaVehiculosRepository.getInstance();
		if(StringUtils.isNotBlank(matricula)) {
			return repoVehiculos.dameVehiculo(matricula);
		}
		return null;
	}

	@Override
	public List<VehiculoModel> getAllVehiculos() {
		repoVehiculos=VentaVehiculosRepository.getInstance();
		return repoVehiculos.dameTodos();
	}
	
	
	
	

}
