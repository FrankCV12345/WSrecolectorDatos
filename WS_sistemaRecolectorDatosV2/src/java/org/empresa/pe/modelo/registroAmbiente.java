/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.modelo;

import java.util.List;

/**
 *
 * @author FCV
 */
public class registroAmbiente {
   private int idAmbiente ,idUus;
   private String fecha;
   private Double alturaMedicion;
   private List<medicion> lstaMediciones ;
   private List<registroLuminariasInAmbiente> lstregluminariasInAmbiente;
   private List<registroSensorInAmbiente> lstregistroSensorInAmbiente;

    public registroAmbiente() {
    }
    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public int getIdUus() {
        return idUus;
    }

    public void setIdUus(int idUus) {
        this.idUus = idUus;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getAlturaMedicion() {
        return alturaMedicion;
    }

    public void setAlturaMedicion(Double alturaMedicion) {
        this.alturaMedicion = alturaMedicion;
    }

    public List<medicion> getLstaMediciones() {
        return lstaMediciones;
    }

    public void setLstaMediciones(List<medicion> lstaMediciones) {
        this.lstaMediciones = lstaMediciones;
    }

    public List<registroLuminariasInAmbiente> getLstregluminariasInAmbiente() {
        return lstregluminariasInAmbiente;
    }

    public void setLstregluminariasInAmbiente(List<registroLuminariasInAmbiente> lstregluminariasInAmbiente) {
        this.lstregluminariasInAmbiente = lstregluminariasInAmbiente;
    }

    public List<registroSensorInAmbiente> getLstregistroSensorInAmbiente() {
        return lstregistroSensorInAmbiente;
    }

    public void setLstregistroSensorInAmbiente(List<registroSensorInAmbiente> lstregistroSensorInAmbiente) {
        this.lstregistroSensorInAmbiente = lstregistroSensorInAmbiente;
    }
   
   
   
         
}
