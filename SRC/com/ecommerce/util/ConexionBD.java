package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // VARIABLES: Estándar camelCase (privadas y estáticas)
    // El puerto por defecto de PostgreSQL es 5432
    private static final String URL = "jdbc:postgresql://localhost:5432/E_COMMERCE"; 
    private static final String USUARIO = "postgres"; 
    private static final String CLAVE = "1992Carlos."; // ¡CAMBIE SU CLAVE AQUÍ!

    // METODO: Estándar camelCase
    public static Connection obtenerConexion() throws SQLException {
        try {
            // No es estrictamente necesario en Java 8+, pero no hace daño
            // Class.forName("org.postgresql.Driver"); 
            
            // Intenta establecer la conexión
            return DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            // Si hay un error (ej. credenciales incorrectas o BD apagada)
            System.err.println("❌ ERROR FATAL DE CONEXIÓN A POSTGRESQL:");
            System.err.println("Mensaje: " + e.getMessage());
            throw e; // Lanza la excepción para que el programa se detenga
        }
    }
}