/*
AUTOR: Diego Breeze.
CLASE: 1°IH

Teorico:

1) Defina variable y que la compone
2) Mencione estructuras condicionales que conozca
3) Mencione estructuras iterativas que conozca
4) Como puedo sortear un número al azar

1) Una variable es un espacio de memoria reservado y esta compuesta por un nombre (identificacion), tipo de dato
(ya sea entero (int), flotante (float), etc, y un valor (generalmente al declarar una variable sin asignar, el valor es
0).

El orden es:

1) Tipo de dato
2) Nombre / Identificación
3) Valor
-------------
2) if, else, else if.
-------------
3) while, do while, for. (bucles/estructuras iterativas).
-------------
4) Se puede sortear un número al azar usando varios métodos, en mi caso yo use bucles para crear un sorteo.
 */

// PRÁCTICO:

package Programacion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ejercicios {
    static Random rn = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("[~]: Autor: Diego Breeze." + "\n\n" + "[#]: 1) Pedir números enteros." + "\n" + "[#]: 2) Pedir 10 enteros.");
        System.out.println("[#]: 3) Sortear del 1 al 81." + "\n" + "[#]: 4) Sortear 4 números.");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" + "\n");
        System.out.print("[*]: ¿Qué deseas hacer?: ");
        op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1: {
                ejercicio1();
                break;
            }
            case 2: {
                ejercicio2();
                break;
            }
            case 3: {
                ejercicio3();
                break;
            }
            case 4: {
                ejercicio4();
                break;
            }
            default: {
                System.out.println("[!]: ERROR, RANGO 1 A 4.");
                break;
            }
        }
    }

    public static void ejercicio2() { // Terminado
        int[] arr = new int[10];
        int indice = 0;
        float promedio = 0;

        System.out.println("\n" + "[~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~]");
        System.out.print("[#] Introduzca 10 números enteros: " + "\n");
        System.out.println("[~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            promedio += arr[i];

            if (arr[i] > arr[indice]) {
                indice = i;
            }

        }
        System.out.print("[-------------------------------------]");
        System.out.println("\n[#]: Números introducidos: " + Arrays.toString(arr));
        System.out.println("[-------------------------------------]" + "\n");

        int mayor = arr[indice];
        System.out.println("[-------------------------------------]");
        System.out.println("[#]: El número mayor es: " + mayor + "\n" + "[#]: Su indice es: " + indice);
        System.out.println("[-------------------------------------]" + "\n");

        promedio /= arr.length;
        System.out.println("[-------------------------------------]");
        System.out.println("[#]: El promedio del array es: " + promedio);
        System.out.println("[-------------------------------------]");
    }

    public static void ejercicio1() { // Terminado.
        System.out.println("[*********************************************************]");
        System.out.println("[~]: Recuerda que al introducir 0 el programa se cierra.");
        System.out.println("[~]: Introduzca números: ");
        System.out.println("[*********************************************************]");
        int cantidadPares = 0;
        int sumaImpares = 0;
        while(true){

            int numero = sc.nextInt();;

            if (numero == 0) {
                break;
            }

            if (numero % 2 == 0) {
                cantidadPares++;
            } else {
                sumaImpares += numero;
            }
        }
        System.out.println("[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-]");
        System.out.println("[#]: Cantidad de números pares: " + cantidadPares + "\n" + "[#]: Suma de los impares: " + sumaImpares);
        System.out.println("[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-]");
    }

    public static void ejercicio3() { // Terminado.
        int numero, aleatorio, contador = 0;

        aleatorio = (int) (Math.random() * 81 + 1);

        System.out.print("[#]: Adivina el número, va del 1 al 81: ");

        do {
            numero = sc.nextInt();

            if (aleatorio > numero) {
                System.out.print("[#]: El número es mayor: ");
            } else {
                System.out.print("[#]: El número es menor: ");
            }
            contador++;
        } while (numero != aleatorio);
        System.out.println("\n" + "[#]: ¡Adivinaste!, el número era: " + numero + " y tuviste " + contador + " intentos.");
    }

    public static void ejercicio4() { // Terminado.
        int numInicio = 10, numFin = 45;

        int[] numerosRandom = new int[4];
        int k = 0;
        while (k < numerosRandom.length) {
            int n = numInicio + rn.nextInt((numFin + 1) - numInicio);
            numerosRandom[k] = n;
            k++;
        }

        System.out.println("[#]: ¡BIENVENIDO AL SORTEO!");
        int aciertos = 0;
        int cantidad = 4;
        int numeroJugador;
        System.out.println("\n[~]: Intenta adivinar cuatro numero del 10 al 45");
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        for (int indice = 0; indice < cantidad; indice++) {
            System.out.print("[*]: Ingrese numero [" + (indice + 1) + "]: ");
            numeroJugador = sc.nextInt();
            for (int j = 0; j < numerosRandom.length; j++) {
                if (numerosRandom[j] == numeroJugador) {
                    aciertos++;
                    break;
                }
            }
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("[~]: Fin del Juego");
        System.out.println("\n[#]: Has acertado: " + aciertos + " veces");
        System.out.println("\n----------------------");
        System.out.println("[#]: LOS NUMEROS ALEATORIOS SON");
        System.out.println(Arrays.toString(numerosRandom));
        System.out.println("----------------------");
    }
}