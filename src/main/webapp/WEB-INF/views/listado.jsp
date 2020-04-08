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
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/pages/listado">Listado</a>
      </li>
      <li class="nav-item">
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
  		<h1>Listado de vehiculos <strong>${nombreEmpresa }</strong></h1>
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-12">
	   	<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Matricula</th>
		      <th scope="col">Modelo</th>
		      <th scope="col">Modo alquiler</th>
		      <th scope="col">Combustible</th>
		      <th scope="col">A&ntilde;o fabricacion</th>
		    </tr>
		  </thead>
		  <tbody id="tableListado">
		  
		  <c:forEach var="vehiculo" items="${flotaListado }">

              <c:set var="colorAlquilado" value="#84F361"/>

              <c:if test="${vehiculo.cliente.idCliente gt 0 }">
                <c:set var="colorAlquilado" value="#F8DCB1"/>
              </c:if>

		  	<tr style="background-color:${colorAlquilado};" onclick="redirectPage('${pageContext.request.contextPath}','pages/detalle?mat=${vehiculo.matricula }');">
		      
		      <td>${vehiculo.matricula }</td>
		       <%-- <c:choose>
		      	<c:when test="${vehiculo.tipo eq 'C' }">
		      		<td style="color:red;">${vehiculo.modelo }</td>
		      	</c:when>
		      	<c:otherwise>
		      		<td style="color:blue;">${vehiculo.modelo }</td>
		      	</c:otherwise>
		      </c:choose> --%>
		      
		      <c:set var="colorTipo" value="blue"/>
		      <c:if test="${vehiculo.tipo eq 'C' }">
		      	<c:set var="colorTipo" value="red"/>
		      </c:if>
		      
		      <td style="color:${colorTipo};">${vehiculo.modelo }</td>
		      <td>${vehiculo.modoAlquiler }</td>
		      <td>${vehiculo.combustible }</td>
		      <td>${vehiculo.annioFab }</td>
		    </tr>
		  </c:forEach>
		  
		  <!-- 
		  	ESTO ES UN COMENTIARIO HTML QUE SE VA A IMPRIMIR EN EL CODIGO FUENTE DE LA PAGINA
		  	<tr>
		      
		      <td>JAVI	</td>
		      <td>PABLO</td>
		      
		    </tr>
		   -->
		    <%-- <tr>
		      
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		     
		      <td>Jacob</td>
		      <td>Thornton</td>
		      <td>@fat</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      
		      <td>Larry</td>
		      <td>the Bird</td>
		      <td>@twitter</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		    </tr> --%>
		  </tbody>
		</table>
	  </div>
  </div>
  
</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/estaticos/js/bootstrap.bundle.min.js"/>"></script>
	<script src="<c:url value="/estaticos/js/custom.js"/>"></script>
	
	<script>
	    $( document ).ready(function() {
	    	
	    	//getVehiculos('${pageContext.request.contextPath}');

	    });
    </script>
</html>
