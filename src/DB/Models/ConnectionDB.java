package DB.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
    public Statement statement;
        final String url = "jdbc:postgresql://localhost:5050/simplon_clone";
        final String user = "postgres";
        final String password = "admin";
    public ConnectionDB(){
        try{
//            Class.forName("DB.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
//            System.out.println("connected successfully");
        }catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}
