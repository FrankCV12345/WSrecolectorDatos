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
public class luxometro {
   private int idluxometro;
   private String nombreluxometro, urlimgLuxometro;

    public luxometro(int idluxometro, String nombreluxometro, String urlimgLuxometro) {
        this.idluxometro = idluxometro;
        this.nombreluxometro = nombreluxometro;
        this.urlimgLuxometro = urlimgLuxometro;
    }

    public luxometro() {
    }

    public int getIdluxometro() {
        return idluxometro;
    }

    public void setIdluxometro(int idluxometro) {
        this.idluxometro = idluxometro;
    }

    public String getNombreluxometro() {
        return nombreluxometro;
    }

    public void setNombreluxometro(String nombreluxometro) {
        this.nombreluxometro = nombreluxometro;
    }

    public String getUrlimgLuxometro() {
        return urlimgLuxometro;
    }

    public void setUrlimgLuxometro(String urlimgLuxometro) {
        this.urlimgLuxometro = urlimgLuxometro;
    }
   
}
