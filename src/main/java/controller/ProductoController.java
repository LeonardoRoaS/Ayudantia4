package controller;

import modelo.Producto;
import modelo.data.DBConnector;
import modelo.data.DBGenerator;
import modelo.data.dao.ProductoDAO;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.List;

public class ProductoController {

    public static boolean agregarProducto(String nombre, String marca, int id) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        if (!ProductoDAO.validarExistenciaProducto(query, "ID", id)) {
            Producto producto = new Producto(nombre, marca, id);
            ProductoDAO.agregarProducto(query, producto);
            DBConnector.closeConnection();
            return true;
        }
        else
            return false;
    }
    public static Object[] getIDProducto() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        Object[] productos = ProductoDAO.getIDProducto(query);
        DBConnector.closeConnection();
        return productos;
    }
    public static String[][] mostrarProductosNombre(String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        String[][] datosProductos = ProductoDAO.obtenerProductosNombre(query,nombre);
        DBConnector.closeConnection();
        return datosProductos;
    }
    public static String[][] mostrarProductos() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        String[][] datosProductos = ProductoDAO.obtenerProductos(query);
        DBConnector.closeConnection();
        return datosProductos;
    }
    public static Object[] getNombreProducto() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        Object[] productos = ProductoDAO.getNombreProducto(query);
        DBConnector.closeConnection();
        return productos;
    }











    public static void eliminarProducto(String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Tienda");
        ProductoDAO.eliminarProducto(query, nombre);
        DBConnector.closeConnection();
    }





}
