/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import org.empresa.pe.modelo.registroAmbiente;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.empresa.pe.modelo.User;
import org.empresa.pe.modelo.medicion;
import org.empresa.pe.modelo.respuesta;
import org.empresa.pe.servicios.registroDatosAmbienteServicio;

/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("registroAmbiente")
public class RegistroAmbienteRecurso {
    registroDatosAmbienteServicio rgtambiente = new registroDatosAmbienteServicio();
    @GET
    public String getRegistrosAmbiente() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public respuesta AddRegistroAmbiente( String RegistroDatosAmbiente){
         respuesta rpta = new respuesta();
        if(RegistroDatosAmbiente.equals("") ||RegistroDatosAmbiente == null ){
           rpta.setEstado("400");
           rpta.setRespuesta("debe ingresar  un json");
        }else{
            Gson jsonRegistro = new Gson();
            registroAmbiente rAmbiente = new registroAmbiente();
            rAmbiente = jsonRegistro.fromJson(RegistroDatosAmbiente,registroAmbiente.class );
            rpta.setEstado("200");
           rpta.setRespuesta(rgtambiente.RegistraDatosAmbiente(rAmbiente));   
        }
        
        return rpta;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{idambiente}")
    public Response getAmbiente(@PathParam("idambiente") int idAmbiente){
       registroAmbiente rg = rgtambiente.BuscaAnbiente(idAmbiente);
       if(rg != null){
           rg.setStatuusHttp(200);
           return Response.status(Response.Status.OK).entity(rg).build();
       }else{
           registroAmbiente rgA = new registroAmbiente();
           rgA.setStatuusHttp(404);
           return Response.status(Response.Status.OK).entity(rgA).build();
       }
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public respuesta putJson(String RegistroDatosAmbiente) {
        respuesta rpta = new respuesta();
            if(RegistroDatosAmbiente.equals("") ||RegistroDatosAmbiente == null ){
               rpta.setEstado("400");
               rpta.setRespuesta("debe ingresar  un json");
            }else{
                Gson jsonRegistro = new Gson();
                registroAmbiente rAmbiente = new registroAmbiente();
                rAmbiente = jsonRegistro.fromJson(RegistroDatosAmbiente,registroAmbiente.class );
                rpta.setEstado("200");
               rpta.setRespuesta(rgtambiente.ActualizaDatosAmbiente(rAmbiente));   
            }
        return rpta;

    }
}
