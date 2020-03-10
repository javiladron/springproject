package com.example.springproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.model.VehiculoModel;
import com.example.springproject.services.IServiceRentaVehiculos;

@RestController
@RequestMapping("/api")
public class RentaVehiculosController {
	
	@Autowired
	private IServiceRentaVehiculos serviceRentaVehiculos;
	
	
	@GetMapping("/vehicle/{matricula}")
	public ResponseEntity<?> getVehiculoByMatricula(HttpServletRequest request,@PathVariable String matricula){
		ResponseEntity<?> res=null;
		res=new ResponseEntity<VehiculoModel>(serviceRentaVehiculos.getVehiculoByMatricula(matricula),HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/vehicles")
	public ResponseEntity<?> getVehiculoByMatricula(HttpServletRequest request){
		ResponseEntity<?> res=null;
		res=new ResponseEntity<List<VehiculoModel>>(serviceRentaVehiculos.getAllVehiculos(),HttpStatus.OK);
		return res;
	}
}
