package modelo;

public class Producto {
    private String nombre, marca;
    private int id;

    public Producto (String nombre, String marca, int id){
        this.nombre = nombre;
        this.marca = marca;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public int getId() {
        return id;
    }
}
