package org.fcuevas.carro.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://localhost:3306/jakarta_bd?serverTimezone=America/Santiago";
    private static String usuario = "root";
    private static String clave = "admin";
    private static Connection c;

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexión = " + e.getMessage());
        }
        return c;
    }
}
