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
import org.empresa.MisRecursos.IntegerConPosicion;
import org.empresa.MisRecursos.StringConPosicion;
import org.empresa.MisRecursos.llamaCallable;
import org.empresa.MisRecursos.llamaCallableSinRetorno;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;
import static org.empresa.pe.dao.connecion_bd.conectar;
import static org.empresa.pe.dao.connecion_bd.estadoConectado;
import static org.empresa.pe.dao.connecion_bd.msg;
import org.empresa.pe.modelo.Anbiente;
import org.empresa.pe.modelo.registroAmbiente;
/**
 *
 * @author FCV
 */
public class AnbienteServicio {
    llamaCallableSinRetorno callable = new llamaCallableSinRetorno();
    llamaCallable callableConRetorno = new llamaCallable();
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
                    Anbiente nAnbiente = new Anbiente(rs.getInt(2),rs.getInt(3),rs.getString(1));
                    listAnbienteEnPiso.add(nAnbiente);
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState()+"/"+e.getMessage();
                System.out.println(msg);
            }
        return listAnbienteEnPiso;
    }
    
    
    public List<Anbiente> listaAmbientes(){
        List<Anbiente> listAnbienteEnPiso = new ArrayList<>();
            if(!estadoConectado()){
            conectar();
            }
            try{
                CallableStatement  cst = cadenaConexion.prepareCall("{call lstAmbientes}");
                ResultSet rs = cst.executeQuery();
                while(rs.next()){
                    Anbiente nAnbiente = new Anbiente(rs.getInt(2),rs.getInt(3),rs.getString(1));
                    listAnbienteEnPiso.add(nAnbiente);
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState()+"/"+e.getMessage();
                System.out.println(msg);
            }
        return listAnbienteEnPiso;
    }
    
    
    
    public String inserAnbiente(Anbiente anbiente){
    try{
            List<IntegerConPosicion> lstInt = new ArrayList<>();
            lstInt.add(new IntegerConPosicion(anbiente.getIdPisoDeAmbiente(),2 ));
            lstInt.add(new IntegerConPosicion(anbiente.getIdUsu(),3 ));
            List<StringConPosicion> lstString = new ArrayList<>();
            lstString.add(new StringConPosicion(anbiente.getNombreAmbiente(),1) );
            callable.llamaCallableSinRetornoNada("insertAmbiente", 3, lstInt, lstString, null, null);  
        }catch(SQLException e){
            return e.getMessage();
        }
        return "REGISTRADO CORRECTAMENTE";
    
    }
    
    public String eliminaAmbiente( int id){
           
        try{
            List<IntegerConPosicion> lstInt = new ArrayList<>();
            lstInt.add(new IntegerConPosicion(id,1 ));
            callable.llamaCallableSinRetornoNada("EliminaAnbiente", 1, lstInt, null, null, null);  
        }catch(SQLException e){
            return e.getMessage();
        }
        return "EL REGISTRO CON ID "+id+" ELIMINADO CORRECTAMENTE";
    }
    
    
    
    public Anbiente BuscaAmbiente( int id){
           Anbiente anbi = null;
        try{
            List<IntegerConPosicion> lstInt = new ArrayList<>();
            lstInt.add(new IntegerConPosicion(id,1));
            ResultSet rs =  callableConRetorno.llamaCallableConRespuesta("buscaAmbiente", 1, lstInt, null, null, null);  
            if(rs.next()){
                anbi = new Anbiente();
                anbi.setIdAnbiente(rs.getInt(1));
                anbi.setIdPisoDeAmbiente(rs.getInt(2));
                anbi.setIdUsu(rs.getInt(3));
                anbi.setNombreAmbiente(rs.getString(4));
            }
        }catch(SQLException e){
            return anbi;
        }
        return anbi;
    }
    
    public String AlteraAmbiente(Anbiente  anbiente){
     Anbiente anbi = null;
        try{
            List<IntegerConPosicion> lstInt = new ArrayList<>();
            lstInt.add(new IntegerConPosicion(anbiente.getIdAnbiente(),1));
            List<StringConPosicion> lstaString = new ArrayList<>();
            lstaString.add(new StringConPosicion(anbiente.getNombreAmbiente(),2));
           callable.llamaCallableSinRetornoNada("AlteraAmbiente", 2, lstInt, lstaString, null, null);  
          
        }catch(SQLException e){
            return e.getMessage();
        }
        return "ACTUALIZADO CORRECTAMENTE ";
    }
}
