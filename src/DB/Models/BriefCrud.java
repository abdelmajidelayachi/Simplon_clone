package DB.Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BriefCrud {


    static String sql = "";

    public static boolean createBrief(String name, String context, String details,String sDate , String eDate , int promoId){
        boolean isExecuted = false;
        try {
            sql = "INSERT INTO briefs (name,context,body,start_date,deadline, promo_id) "
                    + "VALUES ( ?,?, ?,?,? );";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setString(2,context);
            stmt.setString(3,details);
            stmt.setString(4,sDate);
            stmt.setString(5,eDate);
            stmt.setInt(1,promoId);
            stmt.executeUpdate();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static ArrayList<String[]> getAllPromoBriefs(int promoId){
        ArrayList<String[]> briefs = new ArrayList<>();
        try {
            sql = "SELECT * FROM briefs WHERE promo_id = ? ORDER BY start_date DESC ;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            stmt.setInt(1,promoId);
            ResultSet rsBriefs = stmt.executeQuery();
            while (rsBriefs.next()){
                briefs.add(new String[]{rsBriefs.getString("id"), rsBriefs.getString("name"),rsBriefs.getString("context"),rsBriefs.getString("body"),rsBriefs.getString("start_date"),rsBriefs.getString("deadline")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return briefs;
    }
    public static ArrayList<String[]> getRecentBrief(int promoId){
        ArrayList<String[]> briefs = new ArrayList<>();
        try {
            sql = "SELECT * FROM briefs WHERE promo_id = "+promoId+" ORDER  BY  start_date DESC;";

            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            ResultSet rsBriefs = stmt.executeQuery();
            while (rsBriefs.next()){
                briefs.add(new String[]{rsBriefs.getString("id"), rsBriefs.getString("name"),rsBriefs.getString("context"),rsBriefs.getString("body"),rsBriefs.getString("start_date"),rsBriefs.getString("deadline")});
                break;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return briefs;
    }
}
