
package Recursos;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public static ResultSet rs;
    public static Statement st;
    public static PreparedStatement pps;
    public static Connection getConexion(){
        
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ProyectosOTI";
        String usuario = "sa";
        String contraseña = "PinkyPanky2023";
        try{
            Connection connexion = DriverManager.getConnection(url,usuario,contraseña);
            return connexion;
        } catch(SQLException ex){   
            System.out.println(ex.toString());
            return null;
        }
        
    }
}

