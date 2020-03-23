package com.example.springproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.model.VehiculoModel;
import com.example.springproject.services.IServiceRentaVehiculos;

/**
 * Controlador REST Spring project
 * @author jladron
 *
 */
@RestController
@RequestMapping("/api")
public class RentaVehiculosController {
	
	//Inyectamos dependencia del servicio
	@Autowired
	private IServiceRentaVehiculos serviceRentaVehiculos;
	
	
	/**
	 * Endpoint que devuelve datos de un vehiculo unico a partir de su matricula
	 * @param request
	 * @param matricula
	 * @return
	 */
	@GetMapping("/vehicle/{matricula}")
	public ResponseEntity<?> getVehiculoByMatricula(HttpServletRequest request,@PathVariable String matricula){
		ResponseEntity<?> res=null;
		res=new ResponseEntity<VehiculoModel>(serviceRentaVehiculos.getVehiculoByMatricula(matricula),HttpStatus.OK);
		return res;
	}
	
	/**
	 * Devuelve todos los vehiculos guardados en el garaje
	 * @param request
	 * @return
	 */
	@GetMapping("/vehicles")
	public ResponseEntity<?> getVehiculoByMatricula(HttpServletRequest request){
		ResponseEntity<?> res=null;
		res=new ResponseEntity<List<VehiculoModel>>(serviceRentaVehiculos.getAllVehiculos(),HttpStatus.OK);
		return res;
	}
	
	
	//@RequestMapping(value="vehicles",method = RequestMethod.POST)
	@PostMapping("/set/vehicle")
	public ResponseEntity<?> setVehiculo(HttpServletRequest request,@RequestBody VehiculoModel vehiculo){
		ResponseEntity<?> res=null;
		res=new ResponseEntity<VehiculoModel>(serviceRentaVehiculos.setVehiculo(vehiculo),HttpStatus.OK);
		return res;
	}
}
