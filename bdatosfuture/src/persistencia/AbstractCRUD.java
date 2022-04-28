package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public abstract class AbstractCRUD<T, PARAM> implements InterfaceCRUD<T, PARAM> {

    @Override
    public void eliminarObjeto(PARAM parametro) {
        Connection con = null;
        Statement st = null;
        try {
            con = Conexion.getConection();
            String consulta = "DELETE FROM " + getNameTabla() + " WHERE Documento=" + parametro + "";
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
