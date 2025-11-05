package com.ecommerce.app;

import com.ecommerce.dao.CategoriaDAO;
import com.ecommerce.modelo.Categoria;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA DE CRUD CON POSTGRESQL (JDBC) ---");
        CategoriaDAO dao = new CategoriaDAO(); // Instancia de la clase DAO

        try {
            // --- 1. INSERTAR (CREATE) ---
            Categoria nuevaCat = new Categoria();
            nuevaCat.setNombre("Electrodomésticos");
            nuevaCat.setDescripcion("Equipos para el hogar y la cocina");
            
            if (dao.insertarCategoria(nuevaCat)) {
                System.out.println("✅ CREADO: Categoría insertada con éxito.");
            } else {
                System.out.println("⚠️ No se pudo insertar la categoría.");
            }
            
            // --- 2. CONSULTAR (READ) ---
            System.out.println("\n--- LISTADO DE CATEGORÍAS ---");
            dao.listarCategorias().forEach(c -> 
                System.out.println("ID: " + c.getIdCategoria() + " | Nombre: " + c.getNombre())
            );

            // --- 3. ACTUALIZAR (UPDATE) ---
            // Asumiendo que la última insertada tiene ID 1 (o el ID que vea en su BD)
            Categoria catActualizar = new Categoria();
            catActualizar.setIdCategoria(1); // <<-- Cambie este 1 por un ID que exista en su BD
            catActualizar.setNombre("Electrodomésticos GRANDES");
            if (dao.actualizarCategoria(catActualizar)) {
                System.out.println("\n🔄 ACTUALIZADO: Categoría ID 1 modificada.");
            }
            
            // --- 4. ELIMINAR (DELETE) ---
            // Si quiere probar la eliminación, descomente la siguiente línea y ponga un ID.
            // if (dao.eliminarCategoria(1)) {
            //     System.out.println("\n❌ ELIMINADO: Categoría ID 1 eliminada.");
            // }

        } catch (SQLException e) {
            // Este mensaje se muestra si la conexión o la consulta falla.
            System.err.println("❌ ERROR: Falló la operación SQL. Verifique la tabla y la BD.");
            e.printStackTrace(); // Muestra el error completo
        }
    }
}