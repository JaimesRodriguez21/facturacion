/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jaimes Rodriguez
 */
public class Conexion {
    private static Connection con = null;
    private static Conexion db;
    private String url = "jdbc:postgresql://localhost:5432/";
    private String dbName = "facturacion_gnosoft";
    private String driver = "org.postgresql.Driver";
    private String user = "postgres";
    private String pass = "admin";

    public Conexion() {
        try {
            Class.forName(this.driver).newInstance();
            con = DriverManager.getConnection(this.url + this.dbName, this.user, this.pass);
        } catch (IllegalAccessException | ClassNotFoundException | SQLException | InstantiationException e) {
            System.err.println("Fallo en Conexion: " + e.getMessage());
        }

    }

    public static Conexion getConexion() {
        if (db == null) {
            db = new Conexion();
        }

        return db;
    }

    public PreparedStatement preparedStatement(String sql) throws SQLException {
        return con.prepareStatement(sql);
    }


    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Fallo de cerrado " + e.getMessage());
        }

    }
}
