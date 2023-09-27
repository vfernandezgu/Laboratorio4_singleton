/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio4_singleton.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentina Fernández y Andres Collazos
 */
public class DBConnection {

    private Connection conn;
    private static DBConnection dbc;

    private DBConnection() {

    }

    public static DBConnection getDBConnection() {
        if (dbc == null) {
            dbc = new DBConnection();
        }
        return dbc;
    }

    public void comprobarIntancia(DBConnection inst) {
        System.out.println("Codigo de Instancia: " + inst.hashCode());
    }

    public void connect(String url) {

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + url + ".db");

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
