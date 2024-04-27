package javaapplication17;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    public static Connection getConnection(){
        try {
            String url="jdbc:mysql://localhost:3306/busreservation2";
            String name="root";
            String pass="lenin";
            return DriverManager.getConnection(url, name, pass);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}
