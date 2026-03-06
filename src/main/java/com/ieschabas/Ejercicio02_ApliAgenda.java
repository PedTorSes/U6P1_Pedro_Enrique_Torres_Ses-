package com.ieschabas;
/**
 * Clase "ApliAgenda" que nos permitirá establecer contacto con los datos introducidos por el usuario
 * @author Pedro Enrique Torres Sesé
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio02_ApliAgenda {
    static void main(String[] args) {
        //Creamos el header del programa
        System.out.println("Nombre - Teléfono");
        System.out.println("===================");

        //Leemos el archivo "agenda.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("Agenda.txt"))) {
            String linea;

            //Establecemos
            while ((linea = br.readLine()) !=null) {
                String[] separado = linea.split(" - ");
                if (separado.length == 2) {
                    System.out.println(separado[0] + " " + separado[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo 'Agenda.txt'");
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero: " + e.getMessage());
        }
    }
}
