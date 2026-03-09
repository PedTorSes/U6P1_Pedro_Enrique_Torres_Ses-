package com.ieschabas;

import java.io.*;
import java.util.Scanner;

public class Ejercicio03_AppMain {

        public static void main(String[] args) {

            //Atributos de la clase
            Scanner sc = new Scanner(System.in);
            String dni;
            //Instanciamos la clase Ejercicio03_Tarjeta para crear un objeto vacío
            Ejercicio03_Tarjeta tarjeta = null;

            //Solicitamos al usuario sus datos
            System.out.print("Introduce tu DNI: ");
            dni = sc.nextLine();
            //Comprobamos que el DNI se encuentra en la base de datos
            //Si no se encuentra, lo escribiremos
            try {
                //Leemos el fichero "bd_banco.txt"
                FileInputStream fis = new FileInputStream("bd_banco.txt");
                Scanner lector = new Scanner(fis);
                //Bucle para leer todo el archivo "bd_banco.txt"
                while (lector.hasNextLine()) {
                    //Leemos una línea
                    String linea = lector.nextLine();
                    //Separamos la línea mediante conforme encuentre una coma
                    String[] datos = linea.split(",");
                    //Comprobamos que el DNI se encuentra en la base de datos
                    if (datos[0].equals(dni)) {
                        tarjeta = new Ejercicio03_Tarjeta(datos[0], datos[1], Double.parseDouble(datos[2]));
                        break;
                    }
                }
                fis.close();
            //Cazamos la excepción
            } catch (IOException e) {
                System.out.println("Error al leer el fichero");
            }
            //Código para crear un usuario el cual no tenemos registrado
            if (tarjeta == null) {

                System.out.println("No existe tarjeta para ese DNI.");
                System.out.print("¿Deseas crear una tarjeta? (s/n): ");

                String resp = sc.nextLine();
                //Respondiendo "s" creamos el usuario
                if (resp.equalsIgnoreCase("s")) {

                    System.out.print("Introduce número de tarjeta: ");
                    String numero = sc.nextLine();

                    tarjeta = new Ejercicio03_Tarjeta(dni, numero, 0);

                    try {
                        //Abrimos el fichero para poder escribir en él
                        FileOutputStream fos = new FileOutputStream("bd_banco.txt", true);
                        PrintStream ps = new PrintStream(fos);
                        //Escribimos en el fichero
                        String linea = tarjeta.toString() + "\n";
                        fos.write(linea.getBytes());

                        ps.close();
                        fos.close();

                    } catch (IOException e) {
                        System.out.println("Error al escribir en el fichero");
                    }

                    mostrarMenu(tarjeta);

                } else {
                    System.out.println("Saliendo del programa...");
                }

            } else {

                System.out.println("Tarjeta encontrada.");
                mostrarMenu(tarjeta);
            }
        }
        //Creamos el menú del programa
        public static void mostrarMenu(Ejercicio03_Tarjeta tarjeta) {

            Scanner sc = new Scanner(System.in);
            int opcion;

            do {

                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Ver saldo");
                System.out.println("2. Ingresar dinero");
                System.out.println("3. Salir");

                opcion = sc.nextInt();

                switch (opcion) {

                    case 1:
                        System.out.println("Saldo: " + tarjeta.getSaldo());
                        break;

                    case 2:
                        System.out.print("Cantidad a ingresar: ");
                        double cantidad = sc.nextDouble();
                        tarjeta.setSaldo(tarjeta.getSaldo() + cantidad);
                        break;

                }

            } while (opcion != 3);

        }
    }
