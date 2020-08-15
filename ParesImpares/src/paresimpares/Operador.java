/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paresimpares;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.15
 * @desc
 */
public class Operador {

    private List<Integer> numerosPares = new ArrayList<>();
    private List<Integer> numerosImpares = new ArrayList<>();

    private int numero = 0;
    private String condicion = "";
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {
        imprimir("");

        do {
            imprimir("Escriba el número para leer.");
            numero = _entrada.nextInt();

            if (numero % 2 == 0) {
                numerosPares.add(numero);
            } else {
                numerosImpares.add(numero);
            }

            imprimir("Si desea continuar escriba 'Y' de lo contrario escriba 'N'.");
            condicion = _entrada.next().toUpperCase();

        } while (condicion.equals("Y"));

        _procesar();
    }

    private void _procesar() {

        imprimir("");
        imprimir("Se registraron " + numerosPares.size() + " pares.");
        Collections.sort(numerosPares);
        imprimir("Se registraron " + numerosImpares.size() + " impares.");

        Collections.sort(numerosImpares);

        int suma = 0;

        for (int i = 0; i < numerosPares.size(); i++) {
            suma += numerosPares.get(i);
        }
        imprimir("Suma de Pares: " + suma);

        suma = 0;

        for (int i = 0; i < numerosImpares.size(); i++) {
            suma += numerosImpares.get(i);
        }
        imprimir("Suma de Impares: " + suma);
    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje + "\r");
    }

    public static void limpiar() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException e) {
            imprimir(e.getMessage());
        }
    }
}
