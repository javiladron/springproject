package com.example.springproject.daos;

import com.example.springproject.model.VehiculoJPAModel;
import com.example.springproject.model.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculosRepository extends JpaRepository<VehiculoJPAModel,Integer> {

}
