
package Control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexion {
    
    private static Connection cn = null;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "juamila13";
    private static String URL = "jdbc:mysql://localhost:3306/futuresoccer";


    public static Connection getConection() throws SQLException{
        cn=null;
        try{
            cn= DriverManager.getConnection(URL,USUARIO,PASSWORD);
            JOptionPane.showMessageDialog(null,"Conexión Exitosa");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la Conexión "+ e);
        }
        return cn;
    }
     public static void desconectar(){
      cn = null;
   }
}
