function callServiceREST(urlReq,metodo,datos){
	var res=null;
	if(metodo==="POST"){
		$.ajax({
            method : metodo,
            contentType : 'application/json',
            url : urlReq,
            dataType : 'json',
            data : JSON.stringify(datos),
			async: false,
			timeout: 30000,
			success: function(result){
				res=result;
			},
			error: function (jqXHR, exception) {
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500]: '+jqXHR.responseText;
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        $.MessageBox("Error de servidor: "+msg);
		        
		        
		    }
        });
	}
	else{
		$.ajax({
            method : metodo,
            url : urlReq,
            data : datos,
			async: false,
			timeout: 30000,
			success: function(result){
				res=result;
			},
			error: function (jqXHR, exception) {
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		        	msg = 'Internal Server Error [500]: '+jqXHR.responseText;
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        $.MessageBox("Error de servidor: "+msg);
		      
		    }
        });
	}
	
	return res;
}

function callAsyncREST(urlReq,metodo,datos,context){
	if(metodo==="POST"){
		$.ajax({
            method : metodo,
            contentType : 'application/json',
            url : urlReq,
            dataType : 'json',
            data : JSON.stringify(datos),
			timeout: 30000,
			beforeSend: function () { 
				
			},
			success: function(result){
				
				var resJson=result;
				/*if(resJson==="OK"){//respuesta sincrona del login
					alert(resJson["bien logado"]);
					var urlAux="pages/search";
					redirectPage(context,urlAux);
				}*/
				
			},
			error: function (jqXHR, exception) {
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		        	msg = 'Internal Server Error [500]: '+jqXHR.responseText;
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        $.MessageBox("Error de servidor: "+msg);
		       
		    }
        });
	}
	else if(metodo==="GET"){
		$.ajax({
            method : metodo,
            contentType : 'application/json',
            url : urlReq,
            dataType : 'json',
            data : datos,
			timeout: 30000,
			beforeSend: function () { 
				showLoader();
			},
			success: function(result){
				var resJson=result;
			},
			error: function (jqXHR, exception) {
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		        	msg = 'Internal Server Error [500]: '+jqXHR.responseText;
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		       
		    }
        });
	}
}

function isNotEmpty(object){
	return object!==null && object!=="" && object!==undefined;
}

function isEmpty(object){
	return object===null || object==="" || object===undefined;
}

function redirectPage(context,endpoint){
	window.location.href=context+"/"+endpoint;
	
}

function serializeDate(fecha){
	
	//return fecha.getDate()+"/"+fecha.getMonth()+"/"+fecha.getFullYear();
	//se le suma 1 al mes porque el index es 0
	return ("0" + fecha.getDate()).slice(-2)+"/"+("0" + (fecha.getMonth()+1)).slice(-2)+"/"+("0" + fecha.getFullYear()).slice(-2)+" "+("0" + fecha.getHours()).slice(-2)+":"+("0" + fecha.getMinutes()).slice(-2)+":"+("0" + fecha.getSeconds()).slice(-2);
	
}



function getVehiculos(context){
	var flotaListado=callServiceREST(context+"/api/vehicles","GET",null);
	if(isNotEmpty(flotaListado)){
		var htmlBuffer='';
		$.each(flotaListado, function(i, vehiculo) {
			var colorTipo=vehiculo.tipo ==="C" ? "red" : "blue"; 
			//htmlBuffer=htmlBuffer+'<tr><td>'+vehiculo.matricula+'</td><td>'+vehiculo.modelo+'</td><td>'+vehiculo.modoAlquiler+'</td><td>'+vehiculo.combustible+'</td><td>'+vehiculo.annioFab+'</td></tr>';
			htmlBuffer+='<tr><td>'+vehiculo.matricula+'</td><td style="color:'+colorTipo+';">'+vehiculo.modelo+'</td><td>'+vehiculo.modoAlquiler+'</td><td>'+(isNotEmpty(vehiculo.combustible) ? vehiculo.combustible : "")+'</td><td>'+vehiculo.annioFab+'</td></tr>';
		});
		$("#tableListado").html(htmlBuffer);
	}
}



function setVehiculo(context){
	var datos={
		"modelo": $("#modelo").val(),
	    "descripcion": $("#descripcion").val(),
	    "combustible": $("#combustible").val(),
	    "tipo": $("#tipo").val(),
	    "matricula": $("#matricula").val(),
	    "annioFab": parseInt($("#annioFab").val()),
	    "peso": parseFloat($("#peso").val()),
	    "modoAlquiler": $("#modoAlquiler").val()
	};
	
	
	
	
	$.ajax({
        method : "POST",
        contentType : 'application/json',
        url :  context+'/api/set/vehicle',
        dataType : 'json',
        data : JSON.stringify(datos),
		timeout: 30000,
		success: function(result){
			//pinto resultados
			var cocheRes=result;
			alert("Vehículo "+cocheRes.modelo+" con matricula "+cocheRes.matricula+" dado de alta correctamente");
			redirectPage(context,"pages/listado");
			
		},
		error: function (jqXHR, exception) {
			
			var msg = '';
	        if (jqXHR.status === 0) {
	            msg = 'Not connect.\n Verify Network.';
	        } else if (jqXHR.status == 403) {
	            msg = 'Operacion no permitida';
	        } else if (jqXHR.status == 500) {
	        	msg = 'Error interno en la aplicacion: '+jqXHR.responseText;
	        } 
	        else if (jqXHR.status == 401) {
	        	msg = 'Acceso no autorizado: '+jqXHR.responseText;
	        }
	        else if (jqXHR.status == 400) {
	        	msg = 'Error: '+jqXHR.responseText;
	        }
	        alert("Error al dar valor a un vehiculo: "+msg);
	       
	    }
    });
		
}
	
	
	
