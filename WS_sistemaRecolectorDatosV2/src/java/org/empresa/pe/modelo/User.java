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
public class User {
    private String nombreUser,contrasenaUser,apellidosUser;
    private int iduser;

    public User(String nombreUser, String contrasenaUser, String apellidosUser, int iduser) {
        this.nombreUser = nombreUser;
        this.contrasenaUser = contrasenaUser;
        this.apellidosUser = apellidosUser;
        this.iduser = iduser;
    }
    
    public User(String nombreUser, String contrasenaUser, int iduser) {
        this.nombreUser = nombreUser;
        this.contrasenaUser = contrasenaUser;
        this.iduser = iduser;
    }

    public User() {
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getContrasenaUser() {
        return contrasenaUser;
    }

    public void setContrasenaUser(String contrasenaUser) {
        this.contrasenaUser = contrasenaUser;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getApellidosUser() {
        return apellidosUser;
    }

    public void setApellidosUser(String apellidosUser) {
        this.apellidosUser = apellidosUser;
    }
    
    
}
