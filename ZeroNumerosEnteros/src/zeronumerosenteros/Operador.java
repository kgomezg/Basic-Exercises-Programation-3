/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeronumerosenteros;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.12
 * @desc
 */
public class Operador {
    private static final List<Integer> numerosPositivos = new ArrayList<>();
    private static final List<Integer> numerosNegativos = new ArrayList<>();
    private int numero = 0;
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {
        do {
            imprimir("Escriba el número deseado.");
            numero = _entrada.nextInt();

            if (numero != 0) {
                if (numero > 0) {
                    numerosPositivos.add(numero);
                } else if (numero < 0) {
                    numerosNegativos.add(numero);
                }
                _start();
            } else {
                break;
            }

        } while (numero == 0);

        _procesar();
    }

    private void _procesar() {
        imprimir("");
        imprimir("Se imprimiran los " + numerosPositivos.size() + " números positivo escritos.");

        if (numerosPositivos.size() > 0) {
            numerosPositivos.forEach(pos -> {
                imprimir("Número positivo: " + pos + " - Cubo: " + Math.pow(pos, 3));
            });
        }

        imprimir("");
        imprimir("Se imprimiran los " + numerosNegativos.size() + " números negativos escritos.");

        if (numerosNegativos.size() > 0) {
            numerosNegativos.forEach(neg -> {
                imprimir("Número negativo: " + neg + " - Cuadrado: " + Math.pow(neg, 2));
            });
        }
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
