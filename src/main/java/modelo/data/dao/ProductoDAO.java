package modelo.data.dao;

import controller.ProductoController;
import modelo.Producto;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ProductoDAO {

    public static void agregarProducto(DSLContext query, Producto producto){
        Table tablaProductos = table(name("Productos"));
        Field[] columnas = tablaProductos.fields("nombre","marca","ID");
        query.insertInto(tablaProductos, columnas[0], columnas[1],columnas[2])
                .values(producto.getNombre(),producto.getMarca(),producto.getId())
                .execute();
    }

    public static boolean validarExistenciaProducto(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Productos")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }

    public static Object[] getIDProducto(DSLContext query){
        Table productos= DSL.table("Productos");
        Result resultados = query.select(productos.field("ID")).from(productos).fetch();
        if(resultados.size()==0){
            return new String[]{"Error no existen productos"};
        }
        else {
            return resultados.getValues("ID").toArray();
        }
    }
    public static String[][] obtenerProductosNombre(DSLContext query, String nombre) {
        Table productos = DSL.table("Productos");
        Result resultados = query.select().from(productos).where(DSL.field("nombre_producto").eq(nombre)).fetch();
        return exportardatos(resultados);
    }
    private static String[][] exportardatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][3];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"nombre_producto");
            datosResultado[registro][1] = (String) resultados.getValue(registro,"Marca");
            datosResultado[registro][2] = (String) resultados.getValue(registro,"ID").toString();
        }
        return datosResultado;
    }
















}
