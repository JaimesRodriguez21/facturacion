/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.IFacturaDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import model.Factura;
import utils.Conexion;

/**
 *
 * @author Jaimes Rodriguez
 */
public class FacturaDao implements IFacturaDao<Factura, Integer> {

    private final Conexion con;
    private static final String INSERT_FACT = "INSERT INTO fact( fact_nombre, fact_fecha, fact_subtotal, fact_iva, fact_total) VALUES (?,?,?,?,?);";
    private static final String SELECT_FACT = "SELECT * FROM fact WHERE fact_id = ?;";
    private static final String SELECT_ALL_FACT = "SELECT * FROM fact;";
    private static final String DELETE_FACT = "DELETE FROM fact WHERE fact_id = ?;";
    private static final String UPDATE_FACT = "UPDATE fact SET fact_nombre = ?, fact_fecha = ?, fact_subtotal = ?, fact_iva = ?, fact_total= ? WHERE fact_id = ?;";

    public FacturaDao(Conexion con) {
        this.con = con;
    }

    @Override
    public boolean insert(Factura factura) {
        boolean insert = false;
        try {
            PreparedStatement ps = con.preparedStatement(INSERT_FACT);
            ps.setString(1, factura.getNombreCliente());
            ps.setDate(2, (Date) factura.getFecha());
            ps.setDouble(3, factura.getSubTotal());
            ps.setDouble(4, factura.getIva());
            ps.setDouble(5, factura.getTotal());
            insert = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return insert;
    }

    @Override
    public Factura getId(Integer id) {
        Factura fact = null;
        try {
            PreparedStatement ps = con.preparedStatement(SELECT_FACT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fact = new Factura();
                fact.setNumerofactura(rs.getInt("fact_id"));
                fact.setNombreCliente(rs.getString("fact_nombre"));
                fact.setFecha(rs.getDate("fact_fecha"));
                fact.setSubTotal(rs.getDouble("fact_subtotal"));
                fact.setIva(rs.getDouble("fact_iva"));
                fact.setTotal(rs.getDouble("fact_total"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return fact;
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> listFact = new ArrayList<>();
        try {
            PreparedStatement ps = this.con.preparedStatement(SELECT_ALL_FACT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Factura fact = new Factura();
                fact.setNumerofactura(rs.getInt("fact_id"));
                fact.setNombreCliente(rs.getString("fact_nombre"));
                fact.setFecha(rs.getDate("fact_fecha"));
                fact.setSubTotal(rs.getDouble("fact_subtotal"));
                fact.setIva(rs.getDouble("fact_iva"));
                fact.setTotal(rs.getDouble("fact_total"));
                listFact.add(fact);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listFact;
    }

    @Override
    public boolean delete(Integer id) {
        boolean delete = false;
        try {
            PreparedStatement ps = this.con.preparedStatement(DELETE_FACT);
            ps.setInt(1, id);
            delete = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return delete;
    }

    @Override
    public boolean update(Factura factura) {
        boolean update = false;
        try {
            PreparedStatement ps = this.con.preparedStatement(UPDATE_FACT);
            ps.setString(1, factura.getNombreCliente());
            ps.setDate(2, (Date) factura.getFecha());
            ps.setDouble(3, factura.getSubTotal());
            ps.setDouble(4, factura.getIva());
            ps.setDouble(5, factura.getTotal());
            ps.setInt(6, factura.getNumerofactura());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return update;
    }

}
