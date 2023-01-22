/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jaimes Rodriguez
 */
public class Factura {

    private int numerofactura;
    private String nombreCliente;
    private Date fecha;
    private double subTotal;
    private double iva;
    private double total;
    private ArrayList<Detalle> listDeta = new ArrayList();

    public Factura() {
    }

    public Factura(int numerofactura, String nombreCliente, Date fecha, double subTotal, double iva, double total) {
        this.numerofactura = numerofactura;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public void calcularSubtotal() {
        this.subTotal = 0;
        if (listDeta != null) {
            listDeta.stream().forEach((info) -> {
                this.subTotal += info.getCantidad() * info.getValor();
            });
        }
    }

    public void calcularTotal() {
        this.total = this.subTotal + (this.subTotal * this.iva);
    }

    public int getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(int numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Detalle> getListDeta() {
        return listDeta;
    }

    public void setListDeta(ArrayList<Detalle> listDeta) {
        this.listDeta = listDeta;
    }

    @Override
    public String toString() {
        return "Factura{" + "numerofactura=" + numerofactura + ", nombreCliente=" + nombreCliente + ", fecha=" + fecha + ", subTotal=" + subTotal + ", iva=" + iva + ", total=" + total + ", ListDeta=" + listDeta + '}';
    }

}
