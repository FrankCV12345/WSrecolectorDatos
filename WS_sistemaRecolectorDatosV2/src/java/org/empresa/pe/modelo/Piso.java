/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FCV
 */
@XmlRootElement
public class Piso {
 private String nombrePiso;
 private int idPiso;

    public Piso(String nombrePiso, int idPiso) {
        this.nombrePiso = nombrePiso;
        this.idPiso = idPiso;
    }

    public Piso() {
    }

    public String getNombrePiso() {
        return nombrePiso;
    }

    public void setNombrePiso(String nombrePiso) {
        this.nombrePiso = nombrePiso;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }
 
 
}
