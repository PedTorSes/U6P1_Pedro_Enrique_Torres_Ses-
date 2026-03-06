package com.ieschabas;

/**
 * Clase tarjeta en la cual creamos una tarjeta y le asignamos los atributos con los que vamos a trabajar
 * @author Pedro Enrique Torres Sesé
 * @version 1.0
 */

public class Ejercicio03_Tarjeta {

        //Atributos
        private String numTarjeta;
        private String dni;
        private double saldo;

        //Constructor vacío
        public Ejercicio03_Tarjeta() {
        }
        //Constructor sobrecargado
        public Ejercicio03_Tarjeta(String numTarjeta, String dni,double saldo) {
            this.numTarjeta = numTarjeta;
            this.saldo = saldo;
            this.dni = dni;
        }

        //Getters y setters
        public String getDni () {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getNumTarjeta() {
            return numTarjeta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setNumTarjeta(String numTarjeta) {
            this.numTarjeta = numTarjeta;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
        //toString
        @Override
        public String toString() {
            return "Tarjeta{" +
                    "numTarjeta='" + numTarjeta + '\'' +
                    ", saldo=" + saldo +
                    ", dni='" + dni + '\'' +
                    '}';
        }
    }
