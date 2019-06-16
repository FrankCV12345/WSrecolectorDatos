/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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

    /**
     * PUT method for updating or creating an instance of ambienteRecurso
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
