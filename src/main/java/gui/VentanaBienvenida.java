package gui;

import controller.ProductoController;

import javax.swing.*;
import java.awt.event.*;

public class VentanaBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonAgregarProducto;
    private JButton botonBuscarProducto;
    private JButton botonMostrarProductos;
    private JButton botonEliminarProducto;
    private JButton botonSalida;

    public VentanaBienvenida(){
        super("Menu", 655, 640);
        inicializarBotonesVentana();
    }

    public void inicializarBotonesVentana(){
        generarMensajeMenu();
        generarBotonAgregarProducto();
        generarBotonBuscarProducto();
        generarBotonMostrarProductos();
        generarBotonEliminarProducto();
        generarBotonSalida();
    }

    public void generarMensajeMenu(){
        String mensajeBienvenida = "Bienvenid@ al Menu";
        super.generarJLabelEncabezado(this.textoMenu, mensajeBienvenida, 200,50,700,40);
    }

    private void generarBotonAgregarProducto() {
        String textoBoton = "Agregar Producto";
        this.botonAgregarProducto = super.generarBoton(textoBoton, 230, 100, 175, 40);
        this.add(this.botonAgregarProducto);
        this.botonAgregarProducto.addActionListener(this);
    }

    private void generarBotonBuscarProducto(){
        String textoBoton = "Buscar Producto";
        this.botonBuscarProducto = super.generarBoton(textoBoton, 230, 180, 175, 40);
        this.add(this.botonBuscarProducto);
        this.botonBuscarProducto.addActionListener(this);
    }

    private void generarBotonMostrarProductos(){
        String textoBoton = "Mostrar Productos";
        this.botonMostrarProductos = super.generarBoton(textoBoton, 230, 260, 175, 40);
        this.add(this.botonMostrarProductos);
        this.botonMostrarProductos.addActionListener(this);
    }

    public void generarBotonEliminarProducto(){
        String textoBoton = "Eliminar Producto";
        this.botonEliminarProducto = super.generarBoton(textoBoton, 230, 340, 175, 40);
        this.add(this.botonEliminarProducto);
        this.botonEliminarProducto.addActionListener(this);
    }

    public void generarBotonSalida(){
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 230, 480, 175, 40);
        this.add(botonSalida);
        this.botonSalida.addActionListener(this);
    }



    // ACCIONES DE LOS BOTONES

    public void actionPerformed(ActionEvent e){
        //ACCION BOTON AGREGAR PRODUCTO
        if (e.getSource() == this.botonAgregarProducto) {
            VentanaAgregarProducto agregarProducto = new VentanaAgregarProducto();
            this.dispose();
        }
        //ACCION BOTON BUSCAR PRODUCTO
        if(e.getSource() == this.botonBuscarProducto){
            try {
                VentanaBuscarProducto buscarProducto = new VentanaBuscarProducto();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        //ACCION BOTON MOSTRAR PRODUCTO
        if(e.getSource() == this.botonMostrarProductos){
            String[] nombreColumnas={"Nombre producto","Marca","ID"};
            try {
                String[][] exportarDatos = ProductoController.mostrarProductos();
                VentanaTabla ventanaTabla= new VentanaTabla(exportarDatos,nombreColumnas);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        //ACCION BOTON ELIMINAR PRODUCTO
        if(e.getSource() == this.botonEliminarProducto){
            try {
                VentanaEliminarProducto eliminarProducto = new VentanaEliminarProducto();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }   
            this.dispose();
        }
        // ACCION BOTON SALIDA
        if(e.getSource() == this.botonSalida){
            this.dispose();
            System.exit(0);
        }
    }




}
