/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratorio4_singleton;

import com.mycompany.laboratorio4_singleton.connection.DBConnection;

/**
 *
 * @author Valentina Fernández y Andres Collazos
 */
public class Laboratorio4_singleton {

    public static void main(String[] args) {
        DBConnection conn = DBConnection.getDBConnection();
        conn.connect("empleados");
        conn.comprobarIntancia(conn);
        conn.disconnect();
        DBConnection conn2 = DBConnection.getDBConnection();
        conn2.connect("nomina");
        conn2.comprobarIntancia(conn2);
        conn2.disconnect();
    }
}
