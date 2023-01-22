/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import Dao.IDetalleDao;
import Dao.IFacturaDao;
import Dao.impl.DetalleDao;
import Dao.impl.FacturaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Detalle;
import model.Factura;
import utils.Conexion;

/**
 *Fact = Factura
 * @author Jaimes Rodriguez
 */
public class Facturacion {

    public Factura crearFact(Factura fact) {
        Conexion con = new Conexion();
        IFacturaDao factDao = new FacturaDao(con);
        IDetalleDao detalleDao = new DetalleDao(con);
        try {
            fact.calcularSubtotal();
            fact.calcularTotal();
            fact.setFecha(new Date());
            factDao.insert(fact);
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
        }

        return fact;
    }

    public boolean modificarFact(Factura fact) {
        boolean update = false;
        Conexion con = new Conexion();
        IFacturaDao factDao = new FacturaDao(con);
        IDetalleDao detaDao = new DetalleDao(con);

        try {
            if (fact.getListDeta() != null) {
                fact.getListDeta().stream().forEach((info) -> {
                    detaDao.update(info);
                });
            }

            fact.calcularSubtotal();
            fact.calcularTotal();
            fact.setFecha(new Date());
            update = factDao.update(fact);

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
        }

        return update;
    }

    public boolean eliminarFact(int numFactura) {
        boolean delete = false;
        Conexion con = new Conexion();
        IFacturaDao factDao = new FacturaDao(con);
        try {
            delete = factDao.delete(numFactura);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return delete;
    }

    public List<Factura> listarFacts() {
        List<Factura> listFact = null;
        Conexion con = new Conexion();
        IFacturaDao facturaDao = new FacturaDao(con);
        try {
            listFact = facturaDao.getAll();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return listFact;
    }

    public Factura obtenerFact(int id) {
        Factura fact = null;
        Conexion con = new Conexion();
        IFacturaDao factDao = new FacturaDao(con);
        IDetalleDao detaDao = new DetalleDao(con);
        try {
            fact = (Factura) factDao.getId(id);
            if (fact != null) {
                fact.setListDeta((ArrayList<Detalle>) detaDao.getIdFactura(fact.getNumerofactura()));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return fact;
    }
}
