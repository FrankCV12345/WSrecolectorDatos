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
import static org.empresa.pe.dao.connecion_bd.*;
import org.empresa.pe.modelo.AmbienteNoAprobado;
import org.empresa.MisRecursos.llamaCallable;
/**
 *
 * @author FCV
 */
public class lstaPisosDesaprobadosServicio {
    llamaCallable callable = new llamaCallable();
    public List<AmbienteNoAprobado> listaAmbientesDesaprobados(){
        List<AmbienteNoAprobado> lsta = new ArrayList<>();
        if(!estadoConectado()){
            conectar();
        }
        try{
            ResultSet rs = callable.llamaCallableConRespuesta("lstambienteDesaprobados", 0, null, null, null, null);
            while(rs.next()){
                AmbienteNoAprobado ambNoAp = new AmbienteNoAprobado();
                ambNoAp.setIdRegistroAmbiente(rs.getInt(1));
                ambNoAp.setIdAmbiente(rs.getInt(2));
                ambNoAp.setNombreAmbiente(rs.getString(3));
                ambNoAp.setNombrePiso(rs.getString(4));
                lsta.add(ambNoAp);
            }
        }catch(SQLException e){
            msg = e.getMessage();
        }
        
        return lsta;
    }
}
