/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.empresa.pe.modelo.User;
import org.empresa.pe.servicios.UserServicio;
import org.empresa.pe.dao.connecion_bd;
import static org.empresa.pe.dao.connecion_bd.cadenaConexion;
import static org.empresa.pe.dao.connecion_bd.msg;

/**
 *
 * @author FCV
 */
@Path("/user")
public class UserRecurso {
    private UserServicio servicioUser = new UserServicio();
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<User> getUsuarios(){
       return servicioUser.listaUsers();
   }
    
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public User Login(@QueryParam("nombre")String nombre,@QueryParam("password")String password){
      return servicioUser.LoginUser(nombre, password);
   }
}
