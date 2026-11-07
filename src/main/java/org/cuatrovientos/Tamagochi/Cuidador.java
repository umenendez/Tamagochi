package org.cuatrovientos.Tamagochi;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cuidador {

    private List<Tamagochi> tamagochis;
    private Scanner scanner;
    private int siguienteId;
    
    
    public Cuidador() {
        this.tamagochis = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.siguienteId = 1;
    }

    public void iniciar() {

        System.out.println("¡BIENVENIDO AL TAMAGOCHI!");

        crearTamagochis();

        mostrarMenu();

        scanner.close();
    }

    private void crearTamagochis() {

        int cantidad = leerEntero(
            "¿Cuántos Tamagotchis quieres crear? ", 1
        );

        for (int i = 0; i < cantidad; i++) {

            String nombre = "";

            while (nombre.isBlank()) {

                System.out.print(
                    "Introduce el nombre del Tamagochi "
                    + (i + 1) + ": "
                );

                nombre = scanner.nextLine().trim();

                if (nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            }

            Tamagochi tamagochi = new Tamagochi(nombre, siguienteId);

            tamagochis.add(tamagochi);

            Thread hilo = new Thread(tamagochi);
            hilo.start();

            System.out.println(
                "Tamagochi creado: " + nombre
                + " (ID: " + siguienteId + ")"
            );

            siguienteId++;
        }
    }

    private void mostrarMenu() {

        int opcion;

        do {
        		
            System.out.println("\n|-- MENÚ TAMAGOCHI --|");
            System.out.println("| 1 -- Ver tamagochis");
            System.out.println("| 2 -- Dar de comer");
            System.out.println("| 3 -- Jugar");
            System.out.println("| 4 -- Limpiar");
            System.out.println("| 5 -- ASESINAR");
            System.out.println("| 0 -- Salir");

            opcion = leerEntero("Elige una opción: ", 0, 5);

            switch (opcion) {

                case 1:
                    verTamagochis();
                    break;

                case 2:
                    darDeComer();
                    break;

                case 3:
                    jugar();
                    break;

                case 4:
                    limpiar();
                    break;

                case 5:
                    asesinar();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

            }

        } while (opcion != 0);
    }

    private void verTamagochis() {

        System.out.println("--- LISTA DE TAMAGOCHIS ---");

        for (Tamagochi t : tamagochis) {

            System.out.println(
                "ID: " + t.getId()
                + " | Nombre: " + t.getNombre()
                + " | Tiempo de vida: " + t.getTiempoVida().get()
            );
        }
    }

    private Tamagochi buscarTamagochi() {

        int id = leerEntero("Introduce el ID del Tamagochi: ", 1);

        for (Tamagochi t : tamagochis) {

            if (t.getId() == id) {
                return t;
            }
        }

        System.out.println("No existe ningún Tamagochi con ese ID.");

        return null;
    }

    private void darDeComer() {

        Tamagochi t = buscarTamagochi();

        if (t != null && t.estaVivo()) {
            t.comer();
        }
    }

    private void jugar() {

        Tamagochi t = buscarTamagochi();

        if (t != null && t.estaVivo()) {
            t.jugar();
        }
    }

    private void limpiar() {

        Tamagochi t = buscarTamagochi();

        if (t != null && t.estaVivo()) {
            t.limpiar();
        }
    }

    private void asesinar() {

        Tamagochi t = buscarTamagochi();

        if (t != null && t.estaVivo()) {
            t.asesinar();
        }
    }

    private int leerEntero(String mensaje, int minimo) {

        int numero;

        while (true) {

            try {

                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());

                if (numero < minimo) {
                    System.out.println(
                        "Debes introducir un número mayor o igual que "
                        + minimo
                    );
                    continue;
                }

                return numero;

            } catch (NumberFormatException e) {

                System.out.println("Error: introduce un número entero válido.");
            }
        }
    }

    private int leerEntero(String mensaje, int minimo, int maximo) {

        int numero;

        while (true) {

            numero = leerEntero(mensaje, minimo);

            if (numero <= maximo) {
                return numero;
            }

            System.out.println(
                "Debes introducir un número entre "
                + minimo + " y " + maximo + "."
            );
        }
    }
}