import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
    Statement statement;
    public ConnectionDB(){
        String url = "jdbc:mysql://localhost:3306/gameSpace";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            System.out.println("connected successfully");
        }catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}
