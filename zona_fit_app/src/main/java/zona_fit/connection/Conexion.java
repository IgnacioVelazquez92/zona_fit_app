package zona_fit.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection connection = null;
        var baseDeDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/"+ baseDeDatos;
        var user = "root";
        var password = "admin";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

        }
        catch (Exception e) {
            System.out.println("Error al conectarse a la DB = " + e);
            e.printStackTrace();
        }
        return connection;
    }


    public static void main(String[] args) {
        var conexion = Conexion.getConexion();

        if (conexion != null) {
            System.out.println("Conectados a la DB = " + conexion);
        }else {
            System.out.println("Error al conectarse a la DB");
        }
    }
}
