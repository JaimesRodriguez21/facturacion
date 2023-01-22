/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jaimes Rodriguez
 */
public class Detalle {
    private int id;
    private String articulo;
    private int cantidad;
    private double valor;
    private int id_fact;

    public Detalle() {
    }

    public Detalle(int id, String articulo, int cantidad, double valor, int id_fact) {
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.valor = valor;
        this.id_fact = id_fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    @Override
    public String toString() {
        return "Detalle{" + "id=" + id + ", articulo=" + articulo + ", cantidad=" + cantidad + ", valor=" + valor + ", id_fact=" + id_fact + '}';
    }
    
    
    
}
