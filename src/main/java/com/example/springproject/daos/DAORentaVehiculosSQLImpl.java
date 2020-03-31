package com.example.springproject.daos;

import com.example.springproject.exceptions.SpringprojectException;
import com.example.springproject.model.VehiculoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;



@Service
public class DAORentaVehiculosSQLImpl implements IDAORentaVehiculosSQL{

    @Autowired
    private DataSource dataSource;

    private Connection connection=null;

    @Override
    public List<VehiculoModel> getAllVehicles() throws SpringprojectException {
        List<VehiculoModel> lista=new ArrayList<VehiculoModel>();
        try{
            checkDriverMySQL();

            String query="select * from vehiculo order by idVehiculo desc";

            PreparedStatement pstmt=connection.prepareStatement(query);//SQL

            ResultSet rs=pstmt.executeQuery();//para select usamos este metodo

            while(rs.next()){
                VehiculoModel vehiculo=new VehiculoModel();
                vehiculo.setAnnioFab(rs.getInt(7));
                vehiculo.setDescripcion(rs.getString(3));
                vehiculo.setModelo(rs.getString(2));
                vehiculo.setMatricula(rs.getString(6));
                vehiculo.setPeso(rs.getDouble(8));
                vehiculo.setModoAlquiler(rs.getString(9));
                vehiculo.setCombustible(rs.getString(4));
                vehiculo.setTipo(rs.getString(5));
                lista.add(vehiculo);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            throw new SpringprojectException("Error en dao bbbdd: "+ex.getMessage());
        }
        return lista;
    }

    private void checkDriverMySQL() throws SQLException {

        if(connection==null){
            connection=dataSource.getConnection();
        }

    }
}
