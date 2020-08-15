/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguros;

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

    private List<Vendedor> vendedoresLista = new ArrayList<Vendedor>();
    private static final double SUELDOBASE = 877803;
    private int vendedores = 0;
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {
        imprimir("");
        imprimir("Digite la cantidad de vendedores.");
        vendedores = _entrada.nextInt();

        _procesar();
    }

    private void _procesar() {

        imprimir("");
        imprimir("Se procesara la información");
        imprimir("");

        for (int i = 0; i < vendedores; i++) {

            int ventas = (int) (Math.random() * 20) + 1; // Variable aleatoria

            Vendedor v = new Vendedor(SUELDOBASE);

            for (int j = 0; j < ventas; j++) {
                int valorVenta = (int) (Math.random() * 1000000) + 1; // Variable aleatoria
                v.valorVentas.add(valorVenta);
            }

            vendedoresLista.add(v);
        }

        for (int i = 0; i < vendedoresLista.size(); i++) {
            imprimir("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            double valorTotal = vendedoresLista.get(i).sueldo, comision = 0;

            for (int j = 0; j < vendedoresLista.get(i).valorVentas.size(); j++) {
                valorTotal += ((vendedoresLista.get(i).valorVentas.get(j) * 10) / 100);
                comision += ((vendedoresLista.get(i).valorVentas.get(j) * 10) / 100);
            }

            imprimir("Vendedor #" + (i + 1) + ".");
            imprimir("Sueldo: $" + vendedoresLista.get(i).sueldo);
            imprimir("Ventas Realizadas: " + vendedoresLista.get(i).valorVentas.size() + ".");
            imprimir("Comisión Generada: $" + comision);
            imprimir("Valor Total a Pagar: $" + valorTotal);

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
