/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Faby
 */
public class Conexionbase {
    
    private static final String base = "gestormusica";
    private static String user = "root";
    private static String password = "fabycabrera09";
    private static String url = "jdbc:mysql://localhost:3306/" + base + "?serverTimezone=UTC";
    Connection con = null;

    //Creamos el método de conexión
    public Connection Conectar() {
        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                //return true;
            }
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error al conectar" + e.getMessage());
        }
        return con;
    }
}
