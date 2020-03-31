
CREATE TABLE vehiculo(
	idVehiculo			int(5) AUTO_INCREMENT PRIMARY KEY,
	modelo			    varchar(75) NOT NULL,
	descripcion			varchar(150),
	combustible			varchar(10),
	tipo			    varchar(10),
	matricula			varchar(15) NOT NULL,
	annioFab			int(5),
	peso			    float(7,2),
    modoAlquiler		varchar(10)
);


