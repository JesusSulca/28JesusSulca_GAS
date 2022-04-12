package dao;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {

        try {
//            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            String url = "dbc:sqlserver://localhost:1433;databaseName=dbVinos";
//            String user = "sa";
//            String pwd = "70782063";
            
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/BDFarmacia";
            String user="root";
            String pwd="";

            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Error de Conexión" + "  " + e.getMessage() + "  " + e.getStackTrace());
        }
        return cnx;
    }
    
    
    public static void main(String[] args) throws Exception {
        try {
            Conexion.conectar();
            if (Conexion.cnx != null) {
                System.out.println("Estoy Conectado");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void cerrar() throws Exception {
        if (cnx != null) {
            cnx.close();
            System.out.println("Cerrado");
        }
    }

}
