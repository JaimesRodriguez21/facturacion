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
public interface IDetalleDao<Detalle, Integer> {

    Detalle getId(Integer id);

    boolean insert(Detalle detalle);

    boolean update(Detalle detalle);

    boolean delete(Integer id);

    List<Detalle> getAll();

    List<Detalle> getIdFactura(Integer id);

}
