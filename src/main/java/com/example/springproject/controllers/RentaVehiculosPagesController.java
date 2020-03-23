package com.example.springproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springproject.model.VehiculoModel;
import com.example.springproject.services.IServiceRentaVehiculos;

@Controller
public class RentaVehiculosPagesController {
	
	private static final String NOMBRE_NEGOCIO="Pablo renting";
	
	@Autowired
	IServiceRentaVehiculos serviceRentaVehiculos;
	
	//@RequestMapping(value="/pages/listado",method = RequestMethod.GET)
	@GetMapping("/pages/listado")
	public String showDefaultIndex(HttpServletRequest request,Model model){
		//Objeto Model para pasar variables a la vista JSP que devolvemos
		model.addAttribute("nombreEmpresa",NOMBRE_NEGOCIO);
		
		//obtenmos el listado de los vehiculos del garaje a trevaes del service
		//List<VehiculoModel> flota=serviceRentaVehiculos.getAllVehiculos();
		//model.addAttribute("flotaListado",flota);
		//model.addAttribute("flotaListado",serviceRentaVehiculos.getAllVehiculos());
		
		return "listado";
		//return "/WEB-INF/views/listado.jsp";
	}

}
