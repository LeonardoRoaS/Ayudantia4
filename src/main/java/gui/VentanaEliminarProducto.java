package gui;

import controller.ProductoController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaEliminarProducto extends Ventana{
    private JButton botonEliminar, botonRegresar;
    private JLabel textoEncabezado, textoID, textoNombre;
    private JComboBox campoID;

    public VentanaEliminarProducto() throws ClassNotFoundException {
        super("Eliminar Producto", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() throws ClassNotFoundException {
        generarBotonEliminarProducto();
        generarBotonCancelar();
        generarListaID();
    }
    private void generarListaID() throws ClassNotFoundException {
        super.generarJLabel(this.textoID,"Nombre del Producto:",20,100,150,20);
        this.campoID=super.generarListaDesplegable(ProductoController.getNombreProducto(),200,100, 250, 20);
        this.add(this.campoID);
    }
    private void generarBotonEliminarProducto() {
        String textoBoton= "Eliminar Producto";
        this.botonEliminar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonEliminar);
        this.botonEliminar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }

    //ACCION DE LOS BOTONES
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonEliminar) {
            try {ProductoController.eliminarProducto(this.campoID.getSelectedItem().toString());
                JOptionPane.showMessageDialog(this,"Producto eliminado correctamente");
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonRegresar){
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }

    }




}
