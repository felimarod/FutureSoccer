/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import logica.*;
import persistencia.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Controlador implements ActionListener {

    private VistaMenu menu;
    private VistaRegistrar reg;
    private Jugadora nuevajug;
    private Acudiente nuevoacu;
    private DAOJugadora miDAO;
    private DAOAcudiente misegDAO;
    private VistaBuscarJugadora buscar;

    public Controlador(VistaMenu menu, VistaRegistrar registrar, VistaBuscarJugadora buscar) {

        this.menu = menu;
        this.reg = registrar;
        this.buscar = buscar;
        this.menu.regboton.addActionListener(this);
        this.menu.busboton.addActionListener(this);
        this.reg.btnsalirmenu.addActionListener(this);
        this.reg.btnreg.addActionListener(this);
        this.menu.setVisible(true);
    }

    public void insertarJugadora() {
        try {

            nuevajug = new Jugadora(
                    Integer.parseInt(reg.txtDocj.getText()),
                    reg.txtNombresj.getText(),
                    reg.txtApellidosj.getText(),
                    reg.txtRHj.getText(),
                    reg.txtPosicionj.getText(),
                    reg.txtPiej.getText(),
                    Integer.parseInt(reg.txtCategoriaj.getText()),
                    Integer.parseInt(reg.txtDocumentoa.getText())
            );
            miDAO = new DAOJugadora();
            nuevajug.setEPS(reg.txtEPSj.getText());
            nuevajug.setTelfijo(reg.txtTelj.getText());
            nuevajug.setTelcel(reg.txtCelj.getText());
            this.miDAO.insertarDatos(nuevajug);
        } catch (Exception e) {
            System.out.println("NO SE PUDO INSERTAR LA JUGADORA");
        }

    }

    public void insertarAcudiente() {
        try {

            nuevoacu = new Acudiente(
                    Integer.parseInt(reg.txtDocumentoa.getText()),
                    reg.txtNombresa.getText(),
                    reg.txtApellidosa.getText(),
                    reg.txtCelulara.getText()
            );
            misegDAO = new DAOAcudiente();
            nuevoacu.setCorreo(reg.txtEPSj.getText());
            this.misegDAO.insertarDatos(nuevoacu);
        } catch (Exception e) {
            System.out.println("NO SE PUDO INSERTAR LA JUGADORA");
        }

    }

    public void buscarJugadoraporCategoria() {
        miDAO = new DAOJugadora();
        DefaultTableModel tjugadoras = new DefaultTableModel();
        tjugadoras.addColumn("DOCUMENTO");
        tjugadoras.addColumn("NOMBRES");
        tjugadoras.addColumn("APELLIDOS");
        tjugadoras.addColumn("RH");
        tjugadoras.addColumn("EPS");
        tjugadoras.addColumn("POSICIÓN");
        tjugadoras.addColumn("PIE DOMINANTE");
        tjugadoras.addColumn("TEL FIJO");
        tjugadoras.addColumn("TEL CELULAR");
        tjugadoras.addColumn("CATEGORIA");
        tjugadoras.addColumn("DOCUMENTO ACUDIENTE");
        int categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE LA CATEGORIA DE LAS JUGADORAS A BUSCAR"));
        for (Jugadora jugadora : miDAO.mostrarDatosporCategoria(categoria)) {
            tjugadoras.addRow(new Object[]{
                jugadora.getDocumento(),
                jugadora.getNombres(),
                jugadora.getApellidos(),
                jugadora.getRH(),
                jugadora.getEPS(),
                jugadora.getPosicion(),
                jugadora.getPiedom(),
                jugadora.getTelfijo(),
                jugadora.getTelcel(),
                jugadora.getCategoria(),
                jugadora.getDocAcudiente()
            });

        }
        buscar.tablajugadoras.setModel(tjugadoras);
    }

    public void eliminarRegistro() {
        miDAO = new DAOJugadora();
        String doc = buscar.tablajugadoras.getModel().getValueAt(buscar.tablajugadoras.getSelectedRow(), 0).toString();
        int numdoc = Integer.parseInt(doc);
        miDAO.eliminarJugadora(numdoc);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.reg.btnreg) {
            insertarAcudiente();
            insertarJugadora();

        }
        if (e.getSource() == this.menu.regboton) {

            menu.setVisible(false);
            reg.setVisible(true);
        }
        if (e.getSource() == this.menu.busboton) {

            menu.setVisible(false);
            reg.setVisible(false);
            buscarJugadoraporCategoria();
            buscar.setVisible(true);
        }
        if (e.getSource() == this.reg.btnsalirmenu) {

            menu.setVisible(true);
            reg.setVisible(false);
        }
        if (e.getSource() == this.buscar.btnelim) {

            eliminarRegistro();
        }
    }
}
