/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.servicios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.empresa.MisRecursos.StringConPosicion;
import org.empresa.MisRecursos.llamaCallable;
import static org.empresa.pe.dao.connecion_bd.conectar;
import static org.empresa.pe.dao.connecion_bd.estadoConectado;
import org.empresa.pe.modelo.luminaria;
import org.empresa.pe.modelo.sensor;
/**
 *
 * @author FCV
 */
public class DicionarioService {
    
    public List<sensor> BuscaDetallesSensor(String abreviacion){
        
        List<sensor> lsta = new ArrayList<>();
        llamaCallable callable = new llamaCallable();
        List<StringConPosicion> lstString = new ArrayList<>();
        try{
            lstString.add(new StringConPosicion(abreviacion,1) );
            lstString.add(new StringConPosicion("S",2) );
            ResultSet rs =  callable.llamaCallableConRespuesta("buscaDetalles", 2, null, lstString,null,null);
            while(rs.next()){
                sensor sens = new sensor();
                sens.setNombreSensor(rs.getString(1));
                sens.setUrlImg(rs.getString(2));
                lsta.add(sens);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lsta;
    }
    
    public List<luminaria> BuscaDetallesLuminaria(String abreviacion){
        
        List<luminaria> lsta = new ArrayList<>();
        llamaCallable callable = new llamaCallable();
        List<StringConPosicion> lstString = new ArrayList<>();
        try{
            lstString.add(new StringConPosicion(abreviacion,1) );
            lstString.add(new StringConPosicion("L",2) );
            ResultSet rs =  callable.llamaCallableConRespuesta("buscaDetalles", 2, null, lstString,null,null);
            while(rs.next()){
                luminaria lumin = new luminaria();
                lumin.setNombreLum(rs.getString(1));
                lumin.setUrlimg(rs.getString(2));
                lsta.add(lumin);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lsta;
    }
    
    
}
