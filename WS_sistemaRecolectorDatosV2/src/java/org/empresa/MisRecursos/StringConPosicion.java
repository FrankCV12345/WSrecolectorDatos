/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.MisRecursos;

/**
 *
 * @author FCV
 */
public class StringConPosicion {
    
        private String valor;
        private int posicion;

        public StringConPosicion(String valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
}
