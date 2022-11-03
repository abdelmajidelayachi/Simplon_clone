package DB.Auth;

import DB.Models.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auth {


    static String sql = "";
    public static int checkAuthAdmin(String email, String password, String role){
        int isUser = 0;
        try {
            Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            if(role.equals("Admin"))
                sql = "SELECT id FROM admins WHERE email = '"+email+"' AND password = '"+password+"';";
            if (role.equals("Former"))
                sql = "SELECT id FROM formers WHERE email = '"+email+"' AND password = '"+password+"';";
            if(role.equals("Learner"))
                sql = "SELECT id FROM learners WHERE email = '"+email+"' AND password = '"+password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                isUser = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isUser;
    }
}
