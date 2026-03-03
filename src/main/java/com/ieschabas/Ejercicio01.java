package com.ieschabas;

/**
 * Ejercicio 1 de la práctica 1 del ejercicio de lectura y escritura de archivos
 * @author Pedro Enrique Torres Sesé
 * @version 1.0
 */

import java.io.*;

public class Ejercicio01 {
    public static void main(String[] args) {
        /**
         * Creamos el documento y establecemos los datos que va a tener
         */
        try {
            // Crear el documento
            BufferedWriter bw = new BufferedWriter(new FileWriter("Del1al50.txt"));
            // Datos que vamos a introducir en él
            for (int i = 1; i <= 50; i++) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error, no se ha podido escribir el archivo: " + e.getMessage());;
        }
        /**
         * Creamos la variable "total" para guardar el amonto numérico que debe almacenar el programa
         */
        int total = 0;

        /**
         * Leemos el documento para poder realizar las operaciones pertinentes
         */
        try(BufferedReader br = new BufferedReader(new FileReader("Del1al50.txt"))) {
            String linea;
            while ((linea = br.readLine()) !=null) {
                total += Integer.parseInt(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //Mostramos por pantalla el total de la suma
        System.out.println("La suma total es: " + total);
    }
}