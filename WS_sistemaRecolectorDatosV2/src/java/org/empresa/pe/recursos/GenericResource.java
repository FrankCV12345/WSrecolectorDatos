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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.empresa.pe.modelo.Anbiente;

/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("anbiente")
public class GenericResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnbientes() {
        return Response.ok().build();
    }
}
