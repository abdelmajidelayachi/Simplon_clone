package DB.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConnectionDB {

    private static ConnectionDB connectionDB;
    private Connection connection;

        final String url = "jdbc:postgresql://localhost:5433/simplon_clone";
        final String user = "postgres";
        final String password = "admin";

    private ConnectionDB(){
        init();
    }

    private void init()
        {
        if (connection == null)
        {
            try{
//            Class.forName("DB.jdbc.Driver");
                Class.forName("org.postgresql.Driver");
                 connection = DriverManager.getConnection(url,user,password);
//            System.out.println("connected successfully");
            }catch (Exception e){
                System.out.println("Error "+e);
            }
        }
    }

    public static ConnectionDB getConnectionDB() {
        if(connectionDB == null)
        {
            connectionDB = new ConnectionDB();
        }
        return connectionDB;
    }

    public  Connection getConnection()
    {
        return connection;
    }


}
