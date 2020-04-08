package com.example.springproject.daos;

import com.example.springproject.exceptions.SpringprojectException;
import com.example.springproject.model.VehiculoModel;

import java.util.List;

public interface IDAORentaVehiculosSQL {

    public List<VehiculoModel> getAllVehicles() throws SpringprojectException;

    public VehiculoModel getVehiculoByMatricula(String matricula) throws SpringprojectException;

    public VehiculoModel setVehiculo(VehiculoModel vehiculo) throws SpringprojectException;

}
