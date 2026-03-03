package com.ieschabas;
/**
 * Clase Agenda en la cual creamos el archivo "agenda.txt" y escribimos los datos introducidos por el usuario
 * @author Pedro Enrique Torres Sesé
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02_Agenda {
    static void main(String[] args) {
        //Creamos el scanner para aceptar la introducción de datos
        Scanner scanner = new Scanner(System.in);

        //Creamos el archivo "agenda.txt"
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Agenda.txt"))) {

            //Establecemos la condición por la cual el usuario saldrá de la pantalla
            //Guardamos el nombre
            while (true) {
                System.out.println("Introduce nombre (Salir = intro con nombre vacío): ");
                String nombre = scanner.next();
                if (nombre.isEmpty()) {
                    break;
                }

                //Guardamos el número de teléfono
                System.out.println("Introduce su número de teléfono: ");
                String telefono = scanner.next();

                //Establecemos el formato con el cual guardaremos los contactos y teléfonos
                bw.write(nombre + " - " + telefono);
                bw.newLine();
                System.out.println("Contacto: " + nombre);
            }
            System.out.println("Creación correcta");

            //Creamos el mensaje de error en caso de no poder crearse el contacto
        } catch (IOException e) {
            System.out.println("Ha habido un error en la cración de contacto: " + e.getMessage());;
        }
        scanner.close();
    }
}
