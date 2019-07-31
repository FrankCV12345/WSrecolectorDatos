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
public class medicion {
    private int nroMedicionl,idMedicion,idRegistro;
    private Double resultado;
    private String descripcion;

    public medicion() {
    }
    /*
    public medicion(int nroMedicionl, Double resultado, String descripcion) {
        this.nroMedicionl = nroMedicionl;
        this.resultado = resultado;
        this.descripcion = descripcion;
    }*/

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public int getNroMedicionl() {
        return nroMedicionl;
    }

    public void setNroMedicionl(int nroMedicionl) {
        this.nroMedicionl = nroMedicionl;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
