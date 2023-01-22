/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;
import java.time.LocalDate;
import model.Factura;

/**
 *
 * @author Jaimes Rodriguez
 */
public class prueba {
     public prueba() {
    }

    public static void main(String[] args) {
        Factura fact = new Factura();
       Conexion con =  new Conexion();
        fact.setNombreCliente("Jose Gabriel");
        fact.setIva(0.19);
        fact.setNumerofactura(1);
        fact.setSubTotal(0.0);
        fact.setTotal(1.0);
        fact.setFecha(Date.valueOf(LocalDate.MAX));
        System.out.println(fact.toString());
    }
}
