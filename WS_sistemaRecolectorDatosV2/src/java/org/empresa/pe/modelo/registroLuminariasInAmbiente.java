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
public class registroLuminariasInAmbiente {
    private int idLum , cantidad,idRegistroLum,idregistroAnbien;
    private boolean estado;

    public registroLuminariasInAmbiente() {
    }

    public int getIdRegistroLum() {
        return idRegistroLum;
    }

    public void setIdRegistroLum(int idRegistroLum) {
        this.idRegistroLum = idRegistroLum;
    }

    public int getIdregistroAnbien() {
        return idregistroAnbien;
    }

    public void setIdregistroAnbien(int idregistroAnbien) {
        this.idregistroAnbien = idregistroAnbien;
    }
    

    public int getIdLum() {
        return idLum;
    }

    public void setIdLum(int idLum) {
        this.idLum = idLum;
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
