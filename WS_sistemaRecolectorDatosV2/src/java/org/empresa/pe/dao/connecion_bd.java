/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.dao;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author FCV
 */
public class connecion_bd {
    public static Connection cadenaConexion =null;
    public static String msg = "no se lleno";

    public connecion_bd() {
    }
    
    public static String conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cadenaConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-EP8TESE:1433;databaseName=bd_srd;user=frank;password=entrada38;");
            msg = "conectado";
        }catch(Exception e){
            msg = e.getMessage();
        }
        return msg;
    }
    public static boolean estadoConectado(){
        if(cadenaConexion != null){
            return true;
        }else{
            return false;
        }
    }
    
}
