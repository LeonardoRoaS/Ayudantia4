package gui;

import controller.ProductoController;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class VentanaBuscarProducto extends Ventana {

    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoID, textoNombre;
    private JComboBox campoID;
    private JTextField campoNombre;

    public VentanaBuscarProducto() throws ClassNotFoundException {
        super("Búsqueda de Productos", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() throws ClassNotFoundException {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre del producto:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarListaID() throws ClassNotFoundException {
        super.generarJLabel(this.textoID,"ID:",20,100,150,20);
        this.campoID=super.generarListaDesplegable(ProductoController.getIDProducto(),200,100, 250, 20);
        this.add(this.campoID);
    }
    private void generarBotonBuscarVehiculo() {
        String textoBoton= "Buscar Producto";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] exportarDatos() throws ClassNotFoundException {
        if(this.campoNombre.getText().length()==0 ){
            JOptionPane.showMessageDialog(this,"Ingrese datos validos");
            return new String[0][0];
        }
        else{
            return ProductoController.mostrarProductosNombre(this.campoNombre.getText());
        }
    }



    //ACCIONES DE LOS BOTONES
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Nombre producto","Marca","ID"};
            try {
                VentanaTabla ventanaTabla= new VentanaTabla(exportarDatos(),nombreColumnas);
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
