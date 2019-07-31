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
public class Anbiente {
        private int idPisoDeAmbiente, idAnbiente,idUsu;
    private String nombreAmbiente;

    public Anbiente(int idPisoDeAmbiente, int idAnbiente, String nombreAmbiente) {
        this.idPisoDeAmbiente = idPisoDeAmbiente;
        this.idAnbiente = idAnbiente;
        this.nombreAmbiente = nombreAmbiente;
    }

    public Anbiente() {
    }

    public int getIdUsu() {
        return idUsu;
    }
    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdPisoDeAmbiente() {
        return idPisoDeAmbiente;
    }

    public void setIdPisoDeAmbiente(int idPisoDeAmbiente) {
        this.idPisoDeAmbiente = idPisoDeAmbiente;
    }

    public int getIdAnbiente() {
        return idAnbiente;
    }

    public void setIdAnbiente(int idAnbiente) {
        this.idAnbiente = idAnbiente;
    }

    public String getNombreAmbiente() {
        return nombreAmbiente;
    }

    public void setNombreAmbiente(String nombreAmbiente) {
        this.nombreAmbiente = nombreAmbiente;
    }
    
}
