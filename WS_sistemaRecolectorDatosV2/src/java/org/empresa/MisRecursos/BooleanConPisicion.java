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
public class BooleanConPisicion {
     private boolean valor;
        private int posicion;

        public BooleanConPisicion(boolean valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public boolean isValor() {
            return valor;
        }

        public void setValor(boolean valor) {
            this.valor = valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
}
