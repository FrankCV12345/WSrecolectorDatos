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
import org.empresa.pe.modelo.luxometro;
/**
 *
 * @author FCV
 */
public class luxometroServicio {
    public List<luxometro> listaLuxometro(){
        List<luxometro> lstlux = new ArrayList<>();
        if(!estadoConectado()){
            conectar();
        }
        try{
            CallableStatement cst = cadenaConexion.prepareCall("{call lstLuxometros}");
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                lstlux.add(new luxometro(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        }catch(SQLException e){
            msg = e.getMessage();
            System.out.println(msg);
        }
        
        return lstlux;
    }
}
