package com.example.springproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String showListado(HttpServletRequest request,Model model){
		//Objeto Model para pasar variables a la vista JSP que devolvemos
		model.addAttribute("nombreEmpresa",NOMBRE_NEGOCIO);
		
		//obtenmos el listado de los vehiculos del garaje a trevaes del service
		//List<VehiculoModel> flota=serviceRentaVehiculos.getAllVehiculos();
		//model.addAttribute("flotaListado",flota);
		//model.addAttribute("flotaListado",serviceRentaVehiculos.getAllVehiculos());
		
		return "listado";
		//return "/WEB-INF/views/listado.jsp";
	}
	
	//CREAR NUEVO VEHICULO
	
	@GetMapping("/pages/nuevo")
	public String crearNuevoVehiculo(HttpServletRequest request,Model model){
		//para formulario de spring le metemos el modelo vehiculomodel vacio
		//model.addAttribute("vehiculo",new VehiculoModel());
		return "detalle";
		
	}
	
	@PostMapping("/pages/set/form/vehicle")
	public String formHtmlSetVehiculo(HttpServletRequest request,Model model) {
		VehiculoModel vehiculo=new VehiculoModel();
		vehiculo.setAnnioFab(Integer.valueOf(request.getParameter("annioFab")));
		vehiculo.setDescripcion(request.getParameter("descripcion"));
		vehiculo.setModelo(request.getParameter("modelo"));
		vehiculo.setMatricula(request.getParameter("matricula"));
		vehiculo.setPeso(Double.valueOf(request.getParameter("peso")));
		vehiculo.setModoAlquiler(request.getParameter("modoAlquiler"));
		vehiculo.setCombustible(request.getParameter("combustible"));
		vehiculo.setTipo(request.getParameter("tipo"));
		serviceRentaVehiculos.setVehiculo(vehiculo);
		return showListado(request, model);
	}
	
	@PostMapping("/pages/set/formspring/vehicle")
	public String formSpringHtmlSetVehiculo(HttpServletRequest request,Model model,@ModelAttribute("vehiculo") VehiculoModel vehiculo) {
		serviceRentaVehiculos.setVehiculo(vehiculo);
		return showListado(request, model);
	}
	
	//DETALLE Y MODIFICACION DE VEHICULO
	@GetMapping("/pages/detalle")
	public String detalleVehilo(HttpServletRequest request,Model model){
		//extraemos datos del vehiculo
		String matricula=request.getParameter("mat");
		VehiculoModel vehiculo=serviceRentaVehiculos.getVehiculoByMatricula(matricula);
		model.addAttribute("veh",vehiculo);
		return "detalle";
		
	}
	

}
