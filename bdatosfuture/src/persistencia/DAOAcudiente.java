/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import logica.Acudiente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DAOAcudiente {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    public DAOAcudiente() {
        con = null;
        st = null;
        rs = null;
    }

    public void insertarDatos(Acudiente acudiente) {
        try {

            con = Conexion.getConection();
            ps = con.prepareStatement("INSERT INTO acudiente(DocAcudiente,NombresAcu,ApellidosAcu,TelCelularAcu,CorreoAcu) VALUES (?,?,?,?,?)");
            ps.setInt(1, acudiente.getDocumento());
            ps.setString(2, acudiente.getNombres());
            ps.setString(3, acudiente.getApellidos());
            ps.setString(4, acudiente.getTelcel());
            ps.setString(5, acudiente.getCorreo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS INSERTADOS");
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
}
