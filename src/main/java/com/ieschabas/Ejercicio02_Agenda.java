package com.ieschabas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02_Agenda {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Agenda.txt"))) {

            while (true) {
                System.out.println("Introduce nombre (Salir = intro con nombre vacío): ");
                String nombre = scanner.next();

                if (nombre.isEmpty()) {
                    break;
                }
                System.out.println("Introduce su número de teléfono: ");
                String telefono = scanner.next();

                bw.write(nombre + " - " + telefono);
                bw.newLine();
                System.out.println("Contacto: " + nombre);
            }
            System.out.println("Creación correcta");

        } catch (IOException e) {
            System.out.println("Ha habido un error en la cración de contacto: " + e.getMessage());;
        }
        scanner.close();
    }
}
