
CREATE TABLE cliente(
	idCliente			int(5) AUTO_INCREMENT PRIMARY KEY,
	nombre			    varchar(75),
	apellidos			varchar(150),
	edad			    int(4),
	dni			        varchar(15) NOT NULL
);

CREATE TABLE vehiculo(
	idVehiculo			int(5) AUTO_INCREMENT PRIMARY KEY,
	modelo			    varchar(75) NOT NULL,
	descripcion			varchar(150),
	combustible			varchar(10),
	tipo			    varchar(10),
	matricula			varchar(15) NOT NULL,
	annioFab			int(5),
	peso			    float(7,2),
    modoAlquiler		varchar(10),
    idCliente           int(5),
    FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)
);

ALTER TABLE vehiculo ADD CONSTRAINT fk_foreign_cliente_vehiculo FOREIGN KEY (idCliente) REFERENCES cliente(idCliente);





