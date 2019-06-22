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
import org.empresa.pe.modelo.sensor;
import org.empresa.pe.servicios.sensorServicio;
/**
 * REST Web Service
 *
 * @author FCV
 */
@Path("sensor")
public class SensorRecurso {
    sensorServicio servicioSensor = new sensorServicio();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SensorRecurso
     */
    public SensorRecurso() {
    }

    /**
     * Retrieves representation of an instance of org.empresa.pe.recursos.SensorRecurso
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<sensor> getSensores() {
       return servicioSensor.lstSensor();
    }
    /**
     * PUT method for updating or creating an instance of SensorRecurso
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
