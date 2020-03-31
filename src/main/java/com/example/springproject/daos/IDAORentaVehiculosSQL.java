package com.example.springproject.daos;

import com.example.springproject.exceptions.SpringprojectException;
import com.example.springproject.model.VehiculoModel;

import java.util.List;

public interface IDAORentaVehiculosSQL {

    public List<VehiculoModel> getAllVehicles() throws SpringprojectException;
}
