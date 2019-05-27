/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.servicios;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.empresa.pe.dao.connecion_bd;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;
import static org.empresa.pe.dao.connecion_bd.msg;
import static org.empresa.pe.dao.connecion_bd.conectar;
import static org.empresa.pe.dao.connecion_bd.estadoConectado;

import org.empresa.pe.modelo.User;
/**         
 *
 * @author FCV
 */                 
public class UserServicio {
    public User LoginUser(String nombre,String Password){
        User u = new User();
        if(nombre.equals("") && Password.equals("")){
            u.setNombreUser("none");
            u.setIduser(-1);
        }else{
            if(!estadoConectado()){
                conectar();
            }
            try{
                CallableStatement  cst = cadenaConexion.prepareCall("{call loginUser(?,?)}");
                cst.setString(1,nombre);
                cst.setString(2, Password);
                ResultSet rs = cst.executeQuery();
                if(rs.next()){
                    u.setNombreUser(rs.getString("nombreUser"));
                    u.setIduser(rs.getInt("UsuarioID"));
                    u.setApellidosUser(rs.getString("apellidosUser"));
                }else{
                    u.setNombreUser("none");
                    u.setIduser(-1);
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState()+"/"+e.getMessage();
                System.out.println(msg);
            }   
        }
        return u;
    }
    
    public List<User> listaUsers(){
        List<User> listaUsers = new ArrayList<>();
            if(!estadoConectado()){
                conectar();
            }
            try{
                
                Statement st = cadenaConexion.createStatement();
                ResultSet rs =  st.executeQuery("select * from usuario");
                while(rs.next()){
                    User user =  new User();
                    user.setIduser(Integer.parseInt( rs.getString(1)));
                    listaUsers.add(user);
                    System.out.println(user.getIduser());
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState();
            }
        return listaUsers;
    }
}
