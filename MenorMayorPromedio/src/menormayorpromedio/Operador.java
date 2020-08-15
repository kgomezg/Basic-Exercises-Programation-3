/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menormayorpromedio;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.12
 * @desc
 */
public class Operador {

    private List<Integer> numeros = new ArrayList<>();
    private int limiteUsuario = 0, menor = 0, mayor = 0;
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {
        imprimir("");
        imprimir("Escriba la cantidad de números para leer.");
        limiteUsuario = _entrada.nextInt();

        _procesar();
    }

    private void _procesar() {

        imprimir("");

        for (int i = 0; i < limiteUsuario; i++) {
            imprimir("Escriba el número deseado.");
            numeros.add(_entrada.nextInt());
        }

        imprimir("Termino de registrar los " + limiteUsuario + " números deseados.");

        Collections.sort(numeros);

        int suma = 0;

        menor = numeros.get(0);
        mayor = numeros.get(limiteUsuario - 1);

        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i);
        }

        imprimir("");
        imprimir("Menor: " + menor + " y Mayor: " + mayor);
        imprimir("Promedio de todos los números: " + suma / numeros.size());
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
