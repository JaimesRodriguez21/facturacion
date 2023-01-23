/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import facade.Facturacion;
import java.sql.Date;
import java.util.List;
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
        Facturacion facturacion = new Facturacion();
        Conexion con = new Conexion();
        fact.setNombreCliente("Maria Fernando");
        fact.setIva(0.19);
        //    fact.setNumerofactura(1);
        fact.setSubTotal(0.0);
        fact.setTotal(1.0);
        fact.setFecha(new Date(0));

        facturacion.crearFactura(fact);
        //facturacion.eliminarFactura(4);

//          List datos = facturacion.ListarFacturas();
//          datos.stream().forEach((info) -> {
//          System.out.println(info.toString()); });
        // facturacion.actualizarFact(fact);
    }

}
