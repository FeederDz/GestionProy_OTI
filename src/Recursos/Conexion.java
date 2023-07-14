
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
        
        String conexionUrl = "jdbc:sqlserver://localhost:1433;" 
                + "database=ProyectosOTI;" 
                + "user=sa;"
                + "password=PinkyPanky2023;"
                + "TrustServerCertificate = True";
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch(SQLException ex){   
            System.out.println(ex.toString());
            return null;
        }
        
    }
}

