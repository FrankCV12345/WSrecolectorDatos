/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.recursos;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.empresa.pe.modelo.luminaria;
import org.empresa.pe.modelo.sensor;
import org.empresa.pe.servicios.DicionarioService;
/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("buscaDetalles")
public class BuscaDetalles {
    private DicionarioService diccionarioServi = new DicionarioService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("abrebiacion") String abrebiacion , @QueryParam("definidor") String definidor) {
        List<luminaria> lstLumiaria =  new ArrayList<>();
        List<sensor> lstsensor =  new ArrayList<>();
        if(definidor != null){

            if(definidor.equals("L")){
                lstLumiaria = diccionarioServi.BuscaDetallesLuminaria(abrebiacion);
                GenericEntity<List<luminaria>> listlum = new GenericEntity<List<luminaria>>(lstLumiaria){};
                return Response.status(Response.Status.OK).entity(listlum).build();

            }else if(definidor.equals("S")){
               lstsensor = diccionarioServi.BuscaDetallesSensor(abrebiacion);
               GenericEntity<List<sensor>> listsensor = new GenericEntity<List<sensor>>(lstsensor){};
                return Response.status(Response.Status.OK).entity(listsensor).build();

            }else{
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }else{
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
