<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Listado de vehiculos</title>

    

    <!-- Bootstrap core CSS -->
	
	<link href="<c:url value="/estaticos/css/bootstrap.min.css" />" rel="stylesheet">
	   
   
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
  <a class="navbar-brand" href="#">Spring project</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/pages/listado">Listado</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/pages/nuevo">Crear</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Salir</a>
      </li>
   </ul>
  </div>
</nav>

<div role="main" class="container">
  <div class="row">
  	<div class="col-md-12">
  		<h1>Nuevo vehiculo</h1>
  	</div>
  </div>
  <%-- FORMULARIO HTML BASICO --%>
  <%-- <form action="${pageContext.request.contextPath}/pages/set/form/vehicle" method="POST">
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="matricula">Matricula</label>
    	<input type="text" class="form-control" id="matricula" name="matricula" />
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modelo">Modelo</label>
    	<input type="text" class="form-control" id="modelo" name="modelo"/>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="descripcion">Descripcion</label>
    	<input type="text" class="form-control" id="descripcion" name="descripcion"/>
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="combustible">Combustible</label>
    	<select class="form-control" id="combustible"  name="combustible">
    		<option value="diesel">Diesel</option>
    		<option value="gasolina">Gasolina</option>
    	</select>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="tipo">Tipo vehiculo</label>
    	<select class="form-control" id="tipo" name="tipo">
    		<option value="C">Coche</option>
    		<option value="M">Moto</option>
    	</select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="annioFab">A&ntildeo fabricacion</label>
    	<input type="text" class="form-control" id="annioFab" name="annioFab"/>
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="peso">Peso</label>
    	<input type="text" class="form-control" id="peso" name="peso"/>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modoAlquiler">Modo alquiler</label>
    	<select class="form-control" id="modoAlquiler" name="modoAlquiler">
    		<option value="basico">Basico</option>
    		<option value="todoRiesgo">Todo riesgo</option>
    	</select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	 	<br/>
	   	<input type="submit" class="btn btn-primary form-control" value="CREAR" />
	 </div>
  </div>
  </form>
  --%>
  
  <%-- FORMULARIO TAGS DE SPRING --%>
  <%-- <form:form method="POST" action="${pageContext.request.contextPath}/pages/set/formspring/vehicle" modelAttribute="vehiculo">
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="matricula">Matricula</label>
    	<form:input cssClass="form-control" path="matricula" />
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modelo">Modelo</label>
    	<form:input cssClass="form-control" path="modelo" />
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="descripcion">Descripcion</label>
    	<form:input cssClass="form-control" path="descripcion" />
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="combustible">Combustible</label>
	   	<form:select cssClass="form-control" path="combustible">
	   		<form:option value="diesel">Diesel</form:option>
	   		<form:option value="gasolina">Gasolina</form:option>
	   	</form:select>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="tipo">Tipo vehiculo</label>
	   	<form:select cssClass="form-control" path="tipo">
	   		<form:option value="C">Coche</form:option>
	   		<form:option value="M">Moto</form:option>
	   	</form:select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="annioFab">A&ntildeo fabricacion</label>
	   	<form:input cssClass="form-control" path="annioFab" />
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="peso">Peso</label>
    	<form:input cssClass="form-control" path="peso" />
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modoAlquiler">Modo alquiler</label>
	   	<form:select cssClass="form-control" path="modoAlquiler">
	   		<form:option value="basico">Basico</form:option>
	   		<form:option value="todoRiesgo">Todo riesgo</form:option>
	   	</form:select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	 	<br/>
	   	<input type="submit" class="btn btn-primary form-control" value="CREAR" />
	 </div>
  </div>
  </form:form> --%>
  
  
  <%-- 3ª forma: llamada AJAX POST por JAVASCRIPT --%>
  
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="matricula">Matricula</label>
    	<input type="text" class="form-control" id="matricula" name="matricula" />
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modelo">Modelo</label>
    	<input type="text" class="form-control" id="modelo" name="modelo"/>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="descripcion">Descripcion</label>
    	<input type="text" class="form-control" id="descripcion" name="descripcion"/>
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="combustible">Combustible</label>
    	<select class="form-control" id="combustible"  name="combustible">
    		<option value="diesel">Diesel</option>
    		<option value="gasolina">Gasolina</option>
    	</select>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="tipo">Tipo vehiculo</label>
    	<select class="form-control" id="tipo" name="tipo">
    		<option value="C">Coche</option>
    		<option value="M">Moto</option>
    	</select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="annioFab">A&ntildeo fabricacion</label>
    	<input type="text" class="form-control" id="annioFab" name="annioFab"/>
	 </div>
  </div>
  <div class="row">
  	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="peso">Peso</label>
    	<input type="text" class="form-control" id="peso" name="peso"/>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
	   	<label for="modoAlquiler">Modo alquiler</label>
    	<select class="form-control" id="modoAlquiler" name="modoAlquiler">
    		<option value="basico">Basico</option>
    		<option value="todoRiesgo">Todo riesgo</option>
    	</select>
	 </div>
	 <div class="col-md-4 col-sm-4 col-xs-12">
	 	<br/>
	   	<button onclick="setVehiculo('${pageContext.request.contextPath}')" class="btn btn-primary form-control">CREAR</button>
	 </div>
  </div>
 
  
  
  
  
</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/estaticos/js/bootstrap.bundle.min.js"/>"></script>
	<script src="<c:url value="/estaticos/js/custom.js"/>"></script>
	
</html>
