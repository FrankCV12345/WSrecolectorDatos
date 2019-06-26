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
public class IntegerConPosicion {
     private int valor;
        private int posision;

        public IntegerConPosicion(int valor, int posision) {
            this.valor = valor;
            this.posision = posision;
        }

            
        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public int getPosision() {
            return posision;
        }

        public void setPosision(int posision) {
            this.posision = posision;
        }
       
}
