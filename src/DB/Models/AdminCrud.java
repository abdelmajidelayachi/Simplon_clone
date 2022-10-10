package DB.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminCrud {
    static Statement stmt = new ConnectionDB().statement;
    static String sql = "";

    public boolean createAdmin(String fName, String lName, String email){
        String password = "admin"+fName.toLowerCase();
        boolean isExecuted = false;
        try {
            sql = "INSERT INTO admins (FNAME,LNAME,EMAIL,PASSWORD) "
                    + "VALUES ( '"+fName+"', '"+lName+"', '"+email+"', '"+password+"' );";
            stmt.executeUpdate(sql);
            stmt.close();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static int checkAuthAdmin(String email, String password){
        int idAdmin = 0;
        try {
            sql = "SELECT id FROM admins WHERE email = '"+email+"' AND password = '"+password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idAdmin = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idAdmin;
    }
}
