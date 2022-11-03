package DB.Models;

import java.sql.PreparedStatement;
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
            sql = "INSERT INTO formers (FNAME,LNAME,EMAIL,PASSWORD) "
                    + "VALUES ( ?, ?, ?, ? );";
              PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
              stmt.setString(1,fName);
              stmt.setString(2,lName);
              stmt.setString(3,email);
              stmt.setString(4,password);
            stmt.executeUpdate();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }



    public static ArrayList<String[]> getNoAssignedFormer(){
        ArrayList<String[]> formers = new ArrayList<>();
        try {
            sql = "SELECT * FROM formers WHERE ishaspromo = FALSE;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            ResultSet rsFormers = stmt.executeQuery();
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
            sql = "SELECT * FROM formers;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            ResultSet rsFormers = stmt.executeQuery();
            while (rsFormers.next()){
                formers.add(new String[]{rsFormers.getString("id"), rsFormers.getString("fname"),rsFormers.getString("lname"),rsFormers.getString("email")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return formers;
    }
}
