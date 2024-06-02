package org.acarmona.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "0000";
    //private static Connection conexion;

    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection(url, username, password);

    }

}