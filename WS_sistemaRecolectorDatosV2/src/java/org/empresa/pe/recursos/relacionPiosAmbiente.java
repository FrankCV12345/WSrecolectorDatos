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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.empresa.pe.servicios.AnbienteServicio;
import org.empresa.pe.modelo.Anbiente;
import static org.empresa.pe.dao.connecion_bd.msg;
/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("/piso")
@Produces(MediaType.APPLICATION_JSON)
public class relacionPiosAmbiente {
    AnbienteServicio ambienteServicio = new AnbienteServicio();

    @GET
    @Path ("{idpiso}/ambientes")
    public List<Anbiente> getAmbienteEnPiso(@PathParam("idpiso") int idpiso) {
        return ambienteServicio.listaPisoPorAmbiente(idpiso);
    }
    
    
}
