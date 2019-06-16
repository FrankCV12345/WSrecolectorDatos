/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.empresa.pe.modelo.Anbiente;
import org.empresa.pe.modelo.Piso;
import org.empresa.pe.servicios.AnbienteServicio;
import org.empresa.pe.servicios.PisoServicio;
/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("/piso")
@Produces(MediaType.APPLICATION_JSON)
public class PisoRecurso {
    private PisoServicio servicioPiso = new PisoServicio();
    @GET
    public Response getPisos() {
        List<Piso> pisos = servicioPiso.listaPisos();
        GenericEntity<List<Piso>> list = new GenericEntity<List<Piso>>(pisos) {};
        return Response.status(Response.Status.OK).entity(list).build();
    }
    
    
    
}
