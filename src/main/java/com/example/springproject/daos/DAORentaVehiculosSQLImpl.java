package com.example.springproject.daos;

import com.example.springproject.exceptions.SpringprojectException;
import com.example.springproject.model.ClienteModel;
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

            String query="select * from vehiculo v left join cliente c on v.idCliente=c.idCliente order by idVehiculo desc";

            PreparedStatement pstmt=connection.prepareStatement(query);//SQL

            ResultSet rs=pstmt.executeQuery();//para select usamos este metodo

            while(rs.next()){
                VehiculoModel vehiculo=new VehiculoModel();
                vehiculo.setIdVehiculo(rs.getInt(1));
                vehiculo.setAnnioFab(rs.getInt(7));
                vehiculo.setDescripcion(rs.getString(3));
                vehiculo.setModelo(rs.getString(2));
                vehiculo.setMatricula(rs.getString(6));
                vehiculo.setPeso(rs.getDouble(8));
                vehiculo.setModoAlquiler(rs.getString(9));
                vehiculo.setCombustible(rs.getString(4));
                vehiculo.setTipo(rs.getString(5));
                ClienteModel clienteAux=new ClienteModel();
                clienteAux.setIdCliente(rs.getInt(10));
                vehiculo.setCliente(clienteAux);
                lista.add(vehiculo);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            throw new SpringprojectException("Error en dao getAllVehicles: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public VehiculoModel getVehiculoByMatricula(String matricula) throws SpringprojectException {
        VehiculoModel vehiculo=null;
        try{
            checkDriverMySQL();

            String query="select * from vehiculo where matricula=?";

            PreparedStatement pstmt=connection.prepareStatement(query);//SQL

            pstmt.setString(1,matricula);

            ResultSet rs=pstmt.executeQuery();//para select usamos este metodo

            if(rs.next()){
                vehiculo=new VehiculoModel();
                vehiculo.setIdVehiculo(rs.getInt(1));
                vehiculo.setAnnioFab(rs.getInt(7));
                vehiculo.setDescripcion(rs.getString(3));
                vehiculo.setModelo(rs.getString(2));
                vehiculo.setMatricula(rs.getString(6));
                vehiculo.setPeso(rs.getDouble(8));
                vehiculo.setModoAlquiler(rs.getString(9));
                vehiculo.setCombustible(rs.getString(4));
                vehiculo.setTipo(rs.getString(5));

            }

        }catch(Exception ex){
            ex.printStackTrace();
            throw new SpringprojectException("Error en dao getVehiculoByMatricula: "+ex.getMessage());
        }
        return vehiculo;
    }

    @Override
    public VehiculoModel setVehiculo(VehiculoModel vehiculo) throws SpringprojectException {
        VehiculoModel vehiculoModelBBDD=getVehiculoByMatricula(vehiculo.getMatricula());
        try{
            checkDriverMySQL();

            String insertUpdate="";
            if(vehiculoModelBBDD==null){
                insertUpdate="insert into vehiculo values(NULL,?,?,?,?,?,?,?,?,?)";
            }
            else {
                //TODO: PARA MAÑANA
                insertUpdate="update vehiculo set modelo=?,descripcion=?,combustible=?,tipo=?,matricula=?,annioFab=?,peso=?,modoAlquiler=? where idVehiculo=?";
            }


            PreparedStatement pstmt=connection.prepareStatement(insertUpdate);//SQL
            //
            pstmt.setString(1,vehiculo.getModelo());
            pstmt.setString(2,vehiculo.getDescripcion());
            pstmt.setString(3,vehiculo.getCombustible());
            pstmt.setString(4,vehiculo.getTipo());
            pstmt.setString(5,vehiculo.getMatricula());
            pstmt.setInt(6,vehiculo.getAnnioFab());
            pstmt.setDouble(7,vehiculo.getPeso());
            if(!"libre".equals(vehiculo.getModoAlquiler())){// //COMPARAR STRINGS: BIEN PROGRAMADO (esto NUNCA dara un nullpointerexception)
            //if(! vehiculo.getModoAlquiler().equals("libre")){ //COMPARAR STRINGS: MAL PROGRAMADO
                pstmt.setString(8,vehiculo.getModoAlquiler());
            }
            else{
                pstmt.setNull(8,Types.VARCHAR);
            }

            //ENTERO UNICAMENTE PARA LA OPERACION UPDATE
            if(vehiculoModelBBDD!=null){
                pstmt.setInt(9,vehiculoModelBBDD.getIdVehiculo());
            }
            else{//ESTOY EN INSERT
                pstmt.setNull(9,Types.INTEGER);
            }
            pstmt.executeUpdate();

            //UNICAMENTE PARA LA OPERACION UPDATE para indicar en el alert de JS que es una actualizacion
            if(vehiculoModelBBDD!=null){
                vehiculo.setIdVehiculo(vehiculoModelBBDD.getIdVehiculo());
            }




        }catch(Exception ex){
            ex.printStackTrace();
            throw new SpringprojectException("Error en dao setVehiculo: "+ex.getMessage());
        }
        return vehiculo;
    }

    @Override
    public List<ClienteModel> getAllAvailableCustomers() throws SpringprojectException {
        List<ClienteModel> lista=new ArrayList<ClienteModel>();
        try{
            checkDriverMySQL();

            String query="select * from cliente where idCliente not in (select DISTINCT idCliente from vehiculo where idCliente is not null)";

            PreparedStatement pstmt=connection.prepareStatement(query);//SQL

            ResultSet rs=pstmt.executeQuery();//para select usamos este metodo

            while(rs.next()){
                ClienteModel cliente=new ClienteModel();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setEdad(rs.getInt(4));
                cliente.setDni(rs.getString(5));
                lista.add(cliente);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            throw new SpringprojectException("Error en dao getAllAvailableCustomers: "+ex.getMessage());
        }
        return lista;
    }

    private void checkDriverMySQL() throws SQLException {

        if(connection==null){
            connection=dataSource.getConnection();
        }

    }
}
