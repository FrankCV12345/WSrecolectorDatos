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
import org.empresa.pe.modelo.luminaria;
import org.empresa.pe.modelo.Piso;
/**
 *
 * @author FCV
 */
public class luminariaService {
    public List<luminaria> listaLuminarias(){
        List<luminaria> lstLum  = new ArrayList<>();
     if(!estadoConectado()){
            conectar();
        }
     try{
         CallableStatement cst = cadenaConexion.prepareCall("{call lstluminarias}");
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
               luminaria lum = new luminaria();
               lum.setIdluminaria(rs.getInt(1));
               lum.setNombreLum(rs.getString(2));
               lum.setAbrebiasion(rs.getString(3));
               lum.setUrlimg(rs.getString(4));
                lstLum.add(lum);
            }
     }catch(SQLException e){
        msg = e.getMessage();
            System.out.println(msg);
     }
     return lstLum;
    }
    
    
  
}
