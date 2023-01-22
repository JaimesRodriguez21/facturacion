/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Jaimes Rodriguez
 */
public interface IFacturaDao<Factura, Integer> {

    Factura getId(Integer id);

    boolean insert(Factura factura);

    boolean update(Factura factura);

    boolean delete(Integer id);

    List<Factura> getAll();
}
