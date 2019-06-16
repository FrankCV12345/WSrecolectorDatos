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
public class sensor {
    private int idsensor,idUsuRegistro;
    private String nombreSensor,descripcion,abreviasion,urlImg;

    public sensor() {
    }
     public sensor(int idsensor, String nombreSensor, String abreviasion, String urlImg) {
        this.idsensor = idsensor;
        this.nombreSensor = nombreSensor;
        this.abreviasion = abreviasion;
        this.urlImg = urlImg;
    }
    public sensor(int idsensor, int idUsuRegistro, String nombreSensor, String descripcion, String abreviasion, String urlImg) {
        this.idsensor = idsensor;
        this.idUsuRegistro = idUsuRegistro;
        this.nombreSensor = nombreSensor;
        this.descripcion = descripcion;
        this.abreviasion = abreviasion;
        this.urlImg = urlImg;
    }

   

    public sensor(int idUsuRegistro, String nombreSensor, String descripcion, String abreviasion, String urlImg) {
        this.idUsuRegistro = idUsuRegistro;
        this.nombreSensor = nombreSensor;
        this.descripcion = descripcion;
        this.abreviasion = abreviasion;
        this.urlImg = urlImg;
    }

    public int getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(int idsensor) {
        this.idsensor = idsensor;
    }

    public int getIdUsuRegistro() {
        return idUsuRegistro;
    }

    public void setIdUsuRegistro(int idUsuRegistro) {
        this.idUsuRegistro = idUsuRegistro;
    }

    public String getNombreSensor() {
        return nombreSensor;
    }

    public void setNombreSensor(String nombreSensor) {
        this.nombreSensor = nombreSensor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviasion() {
        return abreviasion;
    }

    public void setAbreviasion(String abreviasion) {
        this.abreviasion = abreviasion;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    
}
