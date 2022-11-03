package DB.Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminCrud {

    static String sql = "";

    public boolean createAdmin(String fName, String lName, String email){
        String password = "admin"+fName.toLowerCase();
        boolean isExecuted = false;
        try {
            sql = "INSERT INTO admins (FNAME,LNAME,EMAIL,PASSWORD) "
                    + "VALUES ( '"+fName+"', '"+lName+"', '"+email+"', '"+password+"' );";
           PreparedStatement statement = ConnectionDB.getConnectionDB().getConnection().prepareStatement("insert into admins  (FNAME,LNAME,EMAIL,PASSWORD) values (?,?,?,?)");
           statement.setString(1,fName);
           statement.setString(2,lName);
           statement.setString(3,email);
           statement.setString(4,password);
           statement.executeQuery();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static int checkAuthAdmin(String email, String password){
        int idAdmin = 0;
        try {
            sql = "SELECT id FROM admins WHERE email = ? AND password = ?;";
            PreparedStatement statement = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                idAdmin = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idAdmin;
    }
}
