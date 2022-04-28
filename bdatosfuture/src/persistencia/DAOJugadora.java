/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import logica.Jugadora;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOJugadora {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    public DAOJugadora() {
        con = null;
        st = null;
        rs = null;
    }

    public void insertarDatos(Jugadora jugadora) {
        try {

            con = Conexion.getConection();
            ps = con.prepareStatement("INSERT INTO jugadoras(Documento,Nombres,Apellidos,TipodeSangre,EPS,Posición,Piedominante,TelFijoJugadora,TelCelularJugadora,NumCategoria,DocAcudiente) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, jugadora.getDocumento());
            ps.setString(2, jugadora.getNombres());
            ps.setString(3, jugadora.getApellidos());
            ps.setString(4, jugadora.getRH());
            ps.setString(5, jugadora.getEPS());
            ps.setString(6, jugadora.getPosicion());
            ps.setString(7, jugadora.getPiedom());
            ps.setString(8, jugadora.getTelfijo());
            ps.setString(9, jugadora.getTelcel());
            ps.setInt(10, jugadora.getCategoria());
            ps.setInt(11, jugadora.getDocAcudiente());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS INSERTADO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO INSERTAR LOS DATOS");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CERRAR LA CONEXIÓN");
            }
        }
    }

    public ArrayList<Jugadora> mostrarDatosporCategoria(int Categoria) {
        ArrayList<Jugadora> jugadoras = new ArrayList<>();

        try {
            con = Conexion.getConection();
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM jugadoras WHERE NumCategoria=" + Categoria + "");
            while (resultado.next()) {
                Jugadora jugadora = new Jugadora();
                jugadora.setDocumento(Integer.parseInt(resultado.getString(1)));
                jugadora.setNombres(resultado.getString(2));
                jugadora.setApellidos(resultado.getString(3));
                jugadora.setRH(resultado.getString(4));
                jugadora.setEPS(resultado.getString(5));
                jugadora.setPosicion(resultado.getString(6));
                jugadora.setPiedom(resultado.getString(7));
                jugadora.setTelfijo(resultado.getString(8));
                jugadora.setTelcel(resultado.getString(9));
                jugadora.setCategoria(Integer.parseInt(resultado.getString(10)));
                jugadora.setDocAcudiente(Integer.parseInt(resultado.getString(11)));
                jugadoras.add(jugadora);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL RECIBIR JUGADORAS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTARSE CON LA BASE DE DATOS");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CERRAR LA CONEXIÓN");
            }
        }
        return jugadoras;

    }

    public void eliminarJugadora(int numdoc) {
        try {
            con = Conexion.getConection();
            String consulta = "DELETE FROM jugadoras WHERE Documento=" + numdoc + "";
            st = con.createStatement();
            st.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "JUGADORA ELIMINADA CORRECTAMENTE");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LA JUGADORA");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CERRAR LA CONEXIÓN");
            }

        }

    }
}
