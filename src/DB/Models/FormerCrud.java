package DB.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FormerCrud {
    static String sql = "";

    public static boolean createFormer(String fName, String lName, String email){
        String password = "former"+fName.toLowerCase();
        boolean isExecuted = false;
        try {
              Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "INSERT INTO formers (FNAME,LNAME,EMAIL,PASSWORD) "
                    + "VALUES ( '"+fName+"', '"+lName+"', '"+email+"', '"+password+"' );";
            stmt.executeUpdate(sql);
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }



    public static ArrayList<String[]> getNoAssignedFormer(){
        ArrayList<String[]> formers = new ArrayList<>();
        try {
            Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM formers WHERE ishavepromo = FALSE;";
            ResultSet rsFormers = stmt.executeQuery(sql);
            while (rsFormers.next()){
                formers.add(new String[]{rsFormers.getString("id"), rsFormers.getString("fname"),rsFormers.getString("lname"),rsFormers.getString("email")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return formers;
    }
    public static ArrayList<String[]> getAllFormers(){
        ArrayList<String[]> formers = new ArrayList<>();
        try {
            Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM formers;";
            ResultSet rsFormers = stmt.executeQuery(sql);
            while (rsFormers.next()){
                formers.add(new String[]{rsFormers.getString("id"), rsFormers.getString("fname"),rsFormers.getString("lname"),rsFormers.getString("email")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return formers;
    }
}
