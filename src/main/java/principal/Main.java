package principal;

import controller.ProductoController;
import gui.VentanaBienvenida;
import modelo.Producto;
import modelo.data.DBConnector;
import modelo.data.DBGenerator;
import modelo.data.dao.ProductoDAO;
import org.jooq.DSLContext;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
        DBGenerator.iniciarBD("Tienda");

        VentanaBienvenida ventana = new VentanaBienvenida();
    }
}
