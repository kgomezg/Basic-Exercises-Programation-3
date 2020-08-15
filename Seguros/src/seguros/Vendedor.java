/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguros;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.12
 * @desc 
 */
public class Vendedor {

    public double sueldo = 0;
    public List<Integer> valorVentas;

    public Vendedor(double _sueldo) {
        this.valorVentas = new ArrayList<>();
        this.sueldo = _sueldo;
    }

}
