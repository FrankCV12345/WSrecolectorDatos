/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.servicios;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;
import static org.empresa.pe.dao.connecion_bd.conectar;
import static org.empresa.pe.dao.connecion_bd.estadoConectado;
import static org.empresa.pe.dao.connecion_bd.msg;
import org.empresa.pe.modelo.sensor;
/**
 *
 * @author FCV
 */
public class sensorServicio {
    public List<sensor> lstSensor(){
        List<sensor> lstsensor = new ArrayList<>();
        sensor sen ;
        if(!estadoConectado()){
            conectar();
        }
        
        try{
            CallableStatement cst = cadenaConexion.prepareCall("{call lstSensores}");
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
               sen = new sensor();
               
               sen.setIdsensor(rs.getInt(1));
               sen.setNombreSensor(rs.getString(2));
               sen.setDescripcion(rs.getString(3));
               sen.setUrlImg(rs.getString(4));
               
               lstsensor.add(sen);
            }
            
        }catch(SQLException e){
            msg = e.getMessage();
            System.out.println(msg);
        }
        
        return lstsensor;
    }
}
