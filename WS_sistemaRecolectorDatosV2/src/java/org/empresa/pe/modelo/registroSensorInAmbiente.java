/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.modelo;

/**
 *
 * @author FCV
 */
public class registroSensorInAmbiente {
    private int idSensor,cantidad,idRegSensorInAmbiente,idRegistro;
    private boolean estado;

    public registroSensorInAmbiente() {
    }

    public int getIdRegSensorInAmbiente() {
        return idRegSensorInAmbiente;
    }

    public void setIdRegSensorInAmbiente(int idRegSensorInAmbiente) {
        this.idRegSensorInAmbiente = idRegSensorInAmbiente;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
