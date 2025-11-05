package com.ecommerce.dao;

import com.ecommerce.modelo.Categoria;
import com.ecommerce.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// CLASE: Estándar PascalCase
public class CategoriaDAO {

    // 1. INSERCIÓN (CREATE)
    // METODO: Estándar camelCase
    public boolean insertarCategoria(Categoria categoria) throws SQLException {
        // Uso de ? para prevenir Inyección SQL (Buenas prácticas)
        String sql = "INSERT INTO Categoria (nombre_categoria, descripcion) VALUES (?, ?)";
        
        // Uso de try-with-resources para cerrar Connection y PreparedStatement automáticamente
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            
            return ps.executeUpdate() > 0; // Devuelve true si se insertó 1 fila o más
        }
    }

    // 2. CONSULTA (READ)
    // METODO: Estándar camelCase
    public List<Categoria> listarCategorias() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id_categoria, nombre_categoria, descripcion FROM Categoria";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { // rs contiene los resultados de la BD
            
            while (rs.next()) {
                Categoria cat = new Categoria();
                // Nombramiento: Las variables de la BD se mapean a las variables Java
                cat.setIdCategoria(rs.getInt("id_categoria"));
                cat.setNombre(rs.getString("nombre_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
                lista.add(cat);
            }
        }
        return lista;
    }

    // 3. ACTUALIZACIÓN (UPDATE)
    // METODO: Estándar camelCase
    public boolean actualizarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categoria SET nombre_categoria = ?, descripcion = ? WHERE id_categoria = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCategoria());
            
            return ps.executeUpdate() > 0;
        }
    }

    // 4. ELIMINACIÓN (DELETE)
    // METODO: Estándar camelCase
    public boolean eliminarCategoria(int idCategoria) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE id_categoria = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idCategoria);
            
            return ps.executeUpdate() > 0;
        }
    }
}