/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.IFacturaDao;
import java.util.ArrayList;
import java.util.List;
import model.Factura;

/**
 *
 * @author Jaimes Rodriguez
 */
public class FacturaDao implements IFacturaDao<Factura, Integer> {

    @Override
    public Factura getId(Integer id) {
        Factura fact = null;
        try {

        } catch (Exception e) {
        }
        return fact;
    }

    @Override
    public boolean insert(Factura factura) {
        boolean insert = false;
        try {

        } catch (Exception e) {
        }
        return insert;
    }

    @Override
    public boolean update(Factura factura) {
        boolean update = false;
        try {

        } catch (Exception e) {
        }
        return update;
    }

    @Override
    public boolean delete(Integer id) {
        boolean delete = false;
        try {

        } catch (Exception e) {
        }
        return delete;
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> listFact= new ArrayList<>();
        try {

        } catch (Exception e) {
        }
        return listFact;
    }

}
