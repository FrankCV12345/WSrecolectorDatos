/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.MisRecursos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;

/**
 *
 * @author FCV
 */
public class llamaCallableSinRetorno {
    public void llamaCallableSinRetornoNada(String procedure,int cantidadParametros, List<IntegerConPosicion> lstInt, List<StringConPosicion> lstString,List<BooleanConPisicion> lstboolean,List<DoubleConPosicion> lstDouble) throws SQLException{
        String cadenaProcedure = "";
        if(cantidadParametros > 0){   
            String paramSimbolo ="";
            for(int  i = 0 ; i< cantidadParametros ; i++){
                if(i == 0){
                    paramSimbolo +="?";
                }else{
                    paramSimbolo +=",?";
                }
            }
            cadenaProcedure = "{call "+procedure+"("+paramSimbolo+")}";
        }
        else{
            cadenaProcedure = "{call "+procedure+"}";
        }
        CallableStatement  cst = cadenaConexion.prepareCall(cadenaProcedure);
        if(lstInt != null){
            for(int i =0 ; i<lstInt.size();i++ ){
                cst.setInt(lstInt.get(i).getPosision(),lstInt.get(i).getValor());   
            }
        }
        if(lstString != null){
            for(int i =0 ; i<lstString.size();i++ ){
                cst.setString(lstString.get(i).getPosicion(),lstString.get(i).getValor());   
            }
        }
        if(lstboolean != null){
            for(int i =0 ; i<lstboolean.size();i++ ){
                cst.setBoolean(lstboolean.get(i).getPosicion(),lstboolean.get(i).isValor());   
            }
        }
        
        if(lstDouble != null){
            for(int i =0 ; i<lstDouble.size();i++ ){
                cst.setDouble(lstDouble.get(i).getPosicion(),lstDouble.get(i).getValor());   
            }
        }
         cst.execute();
        
    
    }
}
