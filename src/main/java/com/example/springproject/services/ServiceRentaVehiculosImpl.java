package com.example.springproject.services;

import java.util.List;


import com.example.springproject.daos.IDAORentaVehiculosSQL;
import com.example.springproject.daos.VehiculosRepository;
import com.example.springproject.model.ClienteModel;
import com.example.springproject.model.VehiculoJPAModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.daos.VentaVehiculosRepository;
import com.example.springproject.model.VehiculoModel;

/**
 * Componente service encapsular la logica de las operaciones basicas de la aplicacion SpringProject
 * @author jladron
 *
 */
@Service
public class ServiceRentaVehiculosImpl implements IServiceRentaVehiculos{
	
	/**
	 * Inyectamos DAO, nuestro repo
	 */
	@Autowired
	VentaVehiculosRepository repoVehiculos;

	/**
	 * Inyectamos DAO, contra base de datos de forma nativa
	 */
	@Autowired
	IDAORentaVehiculosSQL daoRentaVehiculosSQL;

	@Autowired
	VehiculosRepository daoVehiculosRepository;
	
	/**
	 * Devuelve vehiculo que coindice con la matricula pasada
	 */
	@Override
	public VehiculoModel getVehiculoByMatricula(String matricula) {
		
		if(StringUtils.isNotBlank(matricula)) {
			//return repoVehiculos.dameVehiculo(matricula);
			return daoRentaVehiculosSQL.getVehiculoByMatricula(matricula);
		}
		return null;
	}

	/**
	 * Devuelve todos los vehiculos que tenemos en el garaje
	 */
	@Override
	public List<VehiculoModel> getAllVehiculos() {

		//return repoVehiculos.dameTodos();
		return daoRentaVehiculosSQL.getAllVehicles();
	}

	@Override
	public VehiculoModel setVehiculo(VehiculoModel vehiculo) {
		//repoVehiculos.insertaNuevo(vehiculo);
		daoRentaVehiculosSQL.setVehiculo(vehiculo);
		return vehiculo;
	}

	@Override
	public List<VehiculoJPAModel> getAllVehiculosJPA() {

		return daoVehiculosRepository.findAll();
	}

	@Override
	public List<ClienteModel> getAllAvailableCustomers() {
		return daoRentaVehiculosSQL.getAllAvailableCustomers();
	}


}
