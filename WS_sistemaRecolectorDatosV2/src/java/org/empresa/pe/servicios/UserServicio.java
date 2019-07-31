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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.empresa.MisRecursos.IntegerConPosicion;
import org.empresa.MisRecursos.StringConPosicion;
import org.empresa.MisRecursos.llamaCallable;
import org.empresa.MisRecursos.llamaCallableSinRetorno;
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
    llamaCallableSinRetorno callable = new llamaCallableSinRetorno();
    llamaCallable callableConRetorno = new llamaCallable();
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
                ResultSet rs =  st.executeQuery("select * from usuario where usuario.softDelete = 1");
                while(rs.next()){
                    User user =  new User();
                    user.setIduser(Integer.parseInt( rs.getString(1)));
                    user.setNombreUser(rs.getString(2));
                    listaUsers.add(user);
                    
                }
            }catch( SQLException e){
                msg = e.getErrorCode()+"/"+e.getSQLState();
            }
        return listaUsers;
    }
    
    public String registraUSer(User user){
        String rpta = null;
            List<StringConPosicion> lstaString = new ArrayList<>();
           
        try {
             if(user.getNombreUser().equals("") || user.getApellidosUser().equals("") || user.getContrasenaUser().equals("") ){
                rpta = "FALTA LLENAR ALGUNOS CAMPOS";
            }else{
                 lstaString.add(new StringConPosicion(user.getNombreUser(),1));
                 lstaString.add(new StringConPosicion(user.getApellidosUser(),2));
                 lstaString.add(new StringConPosicion(user.getContrasenaUser(),3)); 
                callable.llamaCallableSinRetornoNada("InsertUsuario",3, null, lstaString,null,null);
                rpta = "REGISTRADO CORRECTAMENTE";
             }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        return rpta ;
    }
    
     public String DeshabiltitaUSer(int id){
        String rpta = null;
            List<IntegerConPosicion> lstaInteger = new ArrayList<>();
           
        try {
            
                 lstaInteger.add(new IntegerConPosicion(id,1));
                 callable.llamaCallableSinRetornoNada("deshabilitaUser",1, lstaInteger, null,null,null);
                rpta = "DESHABLITADO CORRECTAMENTE";
             
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        return rpta ;
    }
    
    
    
    
}
