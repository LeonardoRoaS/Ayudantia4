package gui;

import controller.ProductoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
public class VentanaAgregarProducto extends Ventana{

    private JLabel textoEncabezado, textoMarca, textoNombre, textoID;
    private JTextField campoNombre, campoMarca;
    private JFormattedTextField campoID;
    private JButton botonRegistrar, botonCancelar;


    public VentanaAgregarProducto(){
        super("Agregar Producto", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombre();
        generarCampoMarca();
        generarCampoID();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de Productos";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 100, 10, 290, 50);

    }
    // BOTONES YA HECHOS
    private void generarBotonRegistrar() {
        String textoBoton= "Agregar Producto";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }


    // CAMPOS
    private void generarCampoNombre(){
        String textoNombre= "Nombre del Producto:";
        super.generarJLabel(this.textoNombre,textoNombre,20,80,150,20);
        this.campoNombre= super.generarJTextField(200,80,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoMarca(){
        String textoMarca= "Marca :";
        super.generarJLabel(this.textoMarca,textoMarca,20,130,150,20);
        this.campoMarca = super.generarJTextField(200,130,250,20);
        this.add(this.campoMarca);
    }
    private void generarCampoID(){
        String textoID = "ID :";
        super.generarJLabel(this.textoID,textoID,20,180,150,20);
        this.campoID = super.generarJFormattedTextField(super.generarFormato(0),200,180,250,20);
        this.add(this.campoID);
    }

    private boolean agregarProducto() throws ClassNotFoundException {
        if(this.campoID.getText().length()==0 || this.campoNombre.getText().length()==0 || this.campoMarca.getText().length()==0){
            return false;
        }
        else{
            return ProductoController.agregarProducto(this.campoNombre.getText(),this.campoMarca.getText(),Integer.parseInt(this.campoID.getText()));
        }
    }





    //ACCIONES DE LOS BOTONES
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == this.botonRegistrar) {
            try {
                if(agregarProducto()) {
                    JOptionPane.showMessageDialog(this,"Producto registrado correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Producto ya ingresado o datos incorrectos");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == this.botonCancelar){
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }
    }
}
