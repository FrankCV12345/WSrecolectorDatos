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
import org.empresa.pe.dao.connecion_bd;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;
import static org.empresa.pe.dao.connecion_bd.conectar;
import static org.empresa.pe.dao.connecion_bd.estadoConectado;
import static org.empresa.pe.dao.connecion_bd.msg;
import org.empresa.pe.modelo.Piso;
/**
 *
 * @author FCV
 */
public class PisoServicio {
    public List<Piso> listaPisos(){
        List<Piso> listaPisos = new ArrayList<>();
        if(!estadoConectado()){
            conectar();
        }
            try{
                CallableStatement  cst = cadenaConexion.prepareCall("{call lstPisos}");
                ResultSet rs = cst.executeQuery();
                while(rs.next()){
                    Piso nPiso = new Piso(rs.getString(2),rs.getShort(1));
                    listaPisos.add(nPiso);
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState()+"/"+e.getMessage();
                System.out.println(msg);
            }
        return listaPisos;
    }
    
    
}
