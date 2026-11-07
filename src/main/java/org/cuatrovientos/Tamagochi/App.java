package org.cuatrovientos.Tamagochi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int opcion;
    	
    	Tamagochi tamago = new Tamagochi("Pedro", (byte) 1);

    	do {
    	    System.out.println("|-- MENÚ TAMAGOCHI --|");
    	    System.out.println("| 1 -- Ver tamagochis");
    	    System.out.println("| 2 -- Dar de comer");
    	    System.out.println("| 3 -- Jugar");
    	    System.out.println("| 4 -- Limpiar");
    	    System.out.println("| 5 -- ASESINAR");
    	    System.out.println("| 0 -- Salir");

    	    System.out.print("Elige una opción: ");
    	    opcion = Integer.parseInt(scanner.nextLine());

    	    switch (opcion) {
    	        case 1:
    	            System.out.println("Ver tamagochis");
    	            break;

    	        case 2:
    	            System.out.println("Dar de comer");
    	            break;

    	        case 3:
    	            System.out.println("Jugar");
    	            break;

    	        case 4:
    	            System.out.println("Limpiar");
    	            break;

    	        case 5:
    	            System.out.println("Has asesinado al tamagochi 💀");
    	            break;

    	        case 0:
    	            System.out.println("Saliendo...");
    	            break;

    	        default:
    	            System.out.println("Opción no válida.");
    	    }

    	} while (opcion != 0);
    }
}
