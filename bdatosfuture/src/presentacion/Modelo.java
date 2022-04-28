package presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Acudiente;
import logica.Jugadora;
import persistencia.DAOAcudiente;
import persistencia.DAOJugadora;

public class Modelo {
    private static Modelo instance;
    
    private final VistaMenu vistaMenu;
    private final VistaRegistrar vistaRegistrar;
    private final VistaBuscarJugadora vistaBuscarJugadora;
    private Jugadora nuevajug;
    private Acudiente nuevoacu;
    private DAOJugadora miDAO;
    private DAOAcudiente misegDAO;
    
    
    private Modelo() {
       vistaMenu = new VistaMenu();
       vistaRegistrar = new VistaRegistrar();
       vistaBuscarJugadora = new VistaBuscarJugadora();
    }
    
    public static Modelo getInstance(){
        if(instance == null)
            instance = new Modelo();
        return instance;
    }
    
    public void start(){
        vistaMenu.setVisible(true);
    }

    public VistaMenu getVistaMenu() {
        return vistaMenu;
    }

    public VistaRegistrar getVistaRegistrar() {
        return vistaRegistrar;
    }

    public VistaBuscarJugadora getVistaBuscarJugadora() {
        return vistaBuscarJugadora;
    }
    
    
    
    public void insertarJugadora() {
        try {

            nuevajug = new Jugadora(
                    Integer.parseInt(vistaRegistrar.txtDocj.getText()),
                    vistaRegistrar.txtNombresj.getText(),
                    vistaRegistrar.txtApellidosj.getText(),
                    vistaRegistrar.txtRHj.getText(),
                    vistaRegistrar.txtPosicionj.getText(),
                    vistaRegistrar.txtPiej.getText(),
                    Integer.parseInt(vistaRegistrar.txtCategoriaj.getText()),
                    Integer.parseInt(vistaRegistrar.txtDocumentoa.getText())
            );
            miDAO = new DAOJugadora();
            nuevajug.setEPS(vistaRegistrar.txtEPSj.getText());
            nuevajug.setTelfijo(vistaRegistrar.txtTelj.getText());
            nuevajug.setTelcel(vistaRegistrar.txtCelj.getText());
            this.miDAO.insertarDatos(nuevajug);
        } catch (Exception e) {
            System.out.println("NO SE PUDO INSERTAR LA JUGADORA");
        }

    }

    public void insertarAcudiente() {
        try {

            nuevoacu = new Acudiente(
                    Integer.parseInt(vistaRegistrar.txtDocumentoa.getText()),
                    vistaRegistrar.txtNombresa.getText(),
                    vistaRegistrar.txtApellidosa.getText(),
                    vistaRegistrar.txtCelulara.getText()
            );
            misegDAO = new DAOAcudiente();
            nuevoacu.setCorreo(vistaRegistrar.txtEPSj.getText());
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
        vistaBuscarJugadora.tablajugadoras.setModel(tjugadoras);
        vistaBuscarJugadora.setVisible(true);
    }

    public void eliminarRegistroJugadora() {
        miDAO = new DAOJugadora();
        String doc = vistaBuscarJugadora.tablajugadoras.getModel().getValueAt(vistaBuscarJugadora.tablajugadoras.getSelectedRow(), 0).toString();
        int numdoc = Integer.parseInt(doc);
        miDAO.eliminarJugadora(numdoc);

    }

}
