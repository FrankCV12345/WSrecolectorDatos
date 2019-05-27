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
import org.empresa.pe.modelo.Anbiente;

/**
 *
 * @author FCV
 */
public class AnbienteServicio {
    public List<Anbiente> listaPisoPorAmbiente(int idAnbiente){
        List<Anbiente> listAnbienteEnPiso = new ArrayList<>();
            if(!estadoConectado()){
            conectar();
            }
            try{
                CallableStatement  cst = cadenaConexion.prepareCall("{call lstAmbientesPorPido(?)}");
                cst.setInt(1, idAnbiente);
                ResultSet rs = cst.executeQuery();
                while(rs.next()){
                    Anbiente nAnbiente = new Anbiente();
                    listAnbienteEnPiso.add(nAnbiente);
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState()+"/"+e.getMessage();
                System.out.println(msg);
            }
        return listAnbienteEnPiso;
    }
}
