/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.empresa.pe.modelo.Anbiente;
import org.empresa.pe.servicios.AnbienteServicio;
/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("/ambiente")
public class ambienteRecurso {
    AnbienteServicio AnbienteServicio = new AnbienteServicio();
    public ambienteRecurso() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anbiente> getAmbientes() {
        return AnbienteServicio.listaAmbientes();
    }
    @GET
    @Path ("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anbiente getAmbiente(@PathParam("id") int id) {
        return AnbienteServicio.BuscaAmbiente(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String RegAmbiente(String jsonAmbiente){
        Gson  gson = new Gson();
        
        Anbiente am = gson.fromJson(jsonAmbiente, Anbiente.class);
        
        return AnbienteServicio.inserAnbiente(am);
        
    }
    @DELETE
    @Path ("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAmbiente(@PathParam("id") int id){
        return AnbienteServicio.eliminaAmbiente(id);
        
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String AlteraAmbiente(String anbiente){
        Gson gson = new Gson();
        Anbiente anbien = gson.fromJson(anbiente,Anbiente.class);
        return AnbienteServicio.AlteraAmbiente(anbien);
    }
    /**
     * PUT method for updating or creating an instance of ambienteRecurso
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
