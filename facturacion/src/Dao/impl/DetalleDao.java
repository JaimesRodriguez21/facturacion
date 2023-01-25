/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.IDetalleDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Detalle;
import utils.Conexion;

/**
 *
 * @author Jaimes Rodriguez
 */
public class DetalleDao implements IDetalleDao<Detalle, Integer>{
    
    private final Conexion con;
    private static final String INSERT_DETA = "INSERT INTO deta (deta_articulo, deta_cantidad, deta_valor, deta_fact_fk) VALUES (?, ?, ?, ?);";
    private static final String SELECT_DETA = "SELECT * FROM deta WHERE deta_id = ?;";
    private static final String SELECT_ALL_DETA = "SELECT * FROM deta";
    private static final String DELETE_DETA = "DELETE FROM deta WHERE deta_id = ?;";
    private static final String UPDATE_DETA = "UPDATE deta SET deta_articulo = ?, deta_cantidad = ?, deta_valor = ?, deta_fact_fk = ? WHERE deta_id = ?;";
    private static final String SELECT_ALL_DETA_ID_FACT = "SELECT * FROM deta WHERE deta_fact_fk = ?; ";

    public DetalleDao(Conexion con) {
        this.con = con;
    }
    
    @Override
    public boolean insert(Detalle detalle) {
        boolean insert = false;

        try {
            PreparedStatement ps = this.con.preparedStatement(INSERT_DETA);
            ps.setString(1, detalle.getArticulo());
            ps.setInt(2, detalle.getCantidad());
            ps.setDouble(3, detalle.getValor());
            ps.setInt(4, detalle.getId_fact());
            insert = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return insert;
    }
    @Override
    public Detalle getId(Integer id) {
        Detalle detalle = null;

        try {
            PreparedStatement ps = this.con.preparedStatement(SELECT_DETA);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                detalle = new Detalle();
                detalle.setId(rs.getInt("deta_id"));
                detalle.setArticulo(rs.getString("deta_articulo"));
                detalle.setCantidad(rs.getInt("deta_cantidad"));
                detalle.setValor(rs.getDouble("deta_valor"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return detalle;
    }

    @Override
    public List<Detalle> getAll() {
        List<Detalle> listDeta = new ArrayList();

        try {
            PreparedStatement ps = this.con.preparedStatement(SELECT_ALL_DETA);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setArticulo(rs.getString("deta_articulo"));
                detalle.setCantidad(rs.getInt("deta_cantidad"));
                detalle.setValor(rs.getDouble("deta_valor"));
                detalle.setId_fact(rs.getInt("deta_fact_fk"));
                listDeta.add(detalle);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listDeta;
    }

    @Override
    public boolean delete(Integer id) {
        boolean delete = false;

        try {
            PreparedStatement ps = this.con.preparedStatement(DELETE_DETA);
            ps.setInt(1, id);
            delete = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return delete;
    }

    @Override
    public boolean update(Detalle detalle) {
        boolean update = false;

        try {
            PreparedStatement ps = this.con.preparedStatement(UPDATE_DETA);
            ps.setString(1, detalle.getArticulo());
            ps.setInt(2, detalle.getCantidad());
            ps.setDouble(3, detalle.getValor());
            ps.setInt(4, detalle.getId_fact());
            ps.setInt(5, detalle.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e);
            return update;
        }
    }

    @Override
    public List<Detalle> getIdFactura(Integer facturaId) {
        List<Detalle> listDeta = new ArrayList();

        try {
            PreparedStatement ps = this.con.preparedStatement(SELECT_ALL_DETA_ID_FACT);
            ps.setInt(1, facturaId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setId(rs.getInt("deta_id"));
                detalle.setArticulo(rs.getString("deta_articulo"));
                detalle.setCantidad(rs.getInt("deta_cantidad"));
                detalle.setValor(rs.getDouble("deta_valor"));
                detalle.setId_fact(rs.getInt("deta_fact_fk"));
                listDeta.add(detalle);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listDeta;
    }
}
