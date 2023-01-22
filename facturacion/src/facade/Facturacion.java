/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import mediator.MediatorFacturacion;
import model.Factura;

/**
 *
 * @author Jaimes Rodriguez
 */
public class Facturacion {

    private final MediatorFacturacion mediFact;

    public Facturacion() {
        this.mediFact = new MediatorFacturacion();
    }
    /**
     *Metodo que recibe un objecto Factura y lo guarda en la base de datos
     * @param fact
     * @return Factura
     */
    public Factura crearFactura(Factura fact){
        return mediFact.crearFact(fact);
    }
    
    /**
     * Metodo que Obtiene una Factura por su id
     * @param id
     * @return Factura
     */
    public Factura obtenerFactura(int id){
         return mediFact.obtenerFact(id);
    }
    
    /**
     * Metodo que Lista todas las Facturas
     * @return List<Factura>
     */
    public List<Factura> ListarFacturas(){
        return mediFact.listarFacts();
    }
    
    /**
     * Metodo que Elimina una factura por su id
     * @param id
     * @return boolean
     */
    public boolean eliminarFactura(int id){
        return mediFact.eliminarFact(id);
    }
    
    /**
     * Metodo que actualiza una factura
     * @param factura
     * @return boolean
     */
    public boolean actualizarFact(Factura factura){
        return mediFact.modificarFact(factura);
    }
}
