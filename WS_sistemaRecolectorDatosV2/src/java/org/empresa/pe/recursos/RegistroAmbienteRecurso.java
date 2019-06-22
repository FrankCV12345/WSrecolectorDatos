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
import java.util.List;
import org.empresa.pe.modelo.medicion;
import org.empresa.pe.servicios.registroDatosAmbienteServicio;

/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("registroAmbiente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegistroAmbienteRecurso {
    registroDatosAmbienteServicio rgtambiente = new registroDatosAmbienteServicio();
    @GET
    public String getRegistrosAmbiente() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    public String AddRegistroAmbiente( String RegistroDatosAmbiente){
        if(RegistroDatosAmbiente.equals("") ||RegistroDatosAmbiente == null ){
            return "debe enviar  un json";
        }else{
            Gson jsonRegistro = new Gson();
            registroAmbiente rAmbiente = new registroAmbiente();
            rAmbiente = jsonRegistro.fromJson(RegistroDatosAmbiente,registroAmbiente.class );
            return rgtambiente.RegistraDatosAmbiente(rAmbiente);
        }
    }
    @PUT
    public void putJson(String content) {
    }
}
