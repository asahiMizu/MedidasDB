package medicionesdb;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private static Connection conexion   = null; // contenida en el paquete SQL
    private static ConexionBD conexionBD = null; // instancia a utilizar

    public ConexionBD(String url, String user, String password) {
        try {
            //Clase usada para una conexion con Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //para MySQL : "com.mysql.jdbc.Driver"
            // investiga cual es para postgreSQL
            try {
                conexion = (Connection)DriverManager.getConnection(url, user, password);
            } catch (SQLException sqlex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, sqlex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexion(String url, String user, String password) {
            if(conexion == null) {
                conexionBD = new ConexionBD(url, user, password);
                System.out.println("Se conecto a la BD el usuario " + user);
            }
            return conexion;
    }
    public static boolean cerrarConexion() {
        try {
            conexion.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error XD : " + e.getMessage());
        }
        return false;
    }
}
