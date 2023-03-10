/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnosoft.facturacion;

import facade.Facturacion;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Factura;

/**
 * REST Web Service
 *
 * @author Jaimes Rodriguez
 */
@Path("facturacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturacionResource {

    private final Facturacion facturacion;

    public FacturacionResource() {
        facturacion = new Facturacion();
    }

    @GET
    @Path(value = "/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factura> listarFacturas() {
        List<Factura> facturas = this.facturacion.ListarFacturas();
        return facturas;
    }

    @POST
    @Path(value = "/factura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Factura registrarFactura(Factura factura) {
        Factura fact = facturacion.crearFactura(factura);
        return fact;
    }

    @GET
    @Path(value = "/factura/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Factura obtenerFactura(@PathParam("id") int id) {
        Factura fact = this.facturacion.obtenerFactura(id);
        return fact;
    }

    @DELETE
    @Path(value = "/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletFactura(@PathParam("id") int id) {
        boolean isDelete = this.facturacion.eliminarFactura(id);
        return (isDelete)? Response.ok().build():Response.serverError().build();
    }

    @PUT
    @Path(value = "/updatefactura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletFactura(Factura fact) {
        boolean  isUpdate = this.facturacion.actualizarFact(fact);
        return  (isUpdate)? Response.ok().build():Response.serverError().build();
    }
}
