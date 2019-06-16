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
public class luminaria {
  private int idluminaria, idusuRegistro;
  private String nombreLum,descripcion,abrebiasion,urlimg;

    public luminaria() {
    }
    public luminaria(int idluminaria, int idusuRegistro, String nombreLum, String descripcion, String abrebiasion, String urlimg) {
        this.idluminaria = idluminaria;
        this.idusuRegistro = idusuRegistro;
        this.nombreLum = nombreLum;
        this.descripcion = descripcion;
        this.abrebiasion = abrebiasion;
        this.urlimg = urlimg;
    }

    public luminaria(int idluminaria, String nombreLum, String abrebiasion, String urlimg) {
        this.idluminaria = idluminaria;
        this.nombreLum = nombreLum;
        this.abrebiasion = abrebiasion;
        this.urlimg = urlimg;
    }

    public luminaria(int idusuRegistro, String nombreLum, String descripcion, String abrebiasion, String urlimg) {
        this.idusuRegistro = idusuRegistro;
        this.nombreLum = nombreLum;
        this.descripcion = descripcion;
        this.abrebiasion = abrebiasion;
        this.urlimg = urlimg;
    }

    public int getIdluminaria() {
        return idluminaria;
    }

    public void setIdluminaria(int idluminaria) {
        this.idluminaria = idluminaria;
    }

    public int getIdusuRegistro() {
        return idusuRegistro;
    }

    public void setIdusuRegistro(int idusuRegistro) {
        this.idusuRegistro = idusuRegistro;
    }

    public String getNombreLum() {
        return nombreLum;
    }

    public void setNombreLum(String nombreLum) {
        this.nombreLum = nombreLum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbrebiasion() {
        return abrebiasion;
    }

    public void setAbrebiasion(String abrebiasion) {
        this.abrebiasion = abrebiasion;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }
    
  
}
