package DB.Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PromoCrud {
    static String sql = "";

    public static ArrayList<String[]> getAllPromos(){
        ArrayList<String[]> promos = new ArrayList<>();
        try {
            sql = "SELECT * FROM promos;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            ResultSet rsPromos = stmt.executeQuery();
            while (rsPromos.next()){
                promos.add(new String[]{rsPromos.getString("id"), rsPromos.getString("name"),rsPromos.getString("former_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return promos;
    }
    public static ArrayList<String[]> getWithNoFormer(){
        ArrayList<String[]> promos = new ArrayList<>();
        try {
            sql = "SELECT * FROM promos WHERE former_id IS NULL ;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            ResultSet rsPromos = stmt.executeQuery();
            while (rsPromos.next()){
                promos.add(new String[]{rsPromos.getString("id"), rsPromos.getString("name"),rsPromos.getString("former_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return promos;
    }
    public static ArrayList<String[]> getPromoByFormer(int formerId){
        ArrayList<String[]> promos = new ArrayList<>();
        try {
            sql = "SELECT * FROM promos WHERE former_id = ? ;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            stmt.setInt(1, formerId);
            ResultSet rsPromos = stmt.executeQuery();
            while (rsPromos.next()){
                promos.add(new String[]{rsPromos.getString("id"), rsPromos.getString("name"),rsPromos.getString("former_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return promos;
    }


    public static boolean createPromo(String name){
        boolean isExecuted = false;
        try {
            sql = "INSERT INTO promos (name) "
                    + "VALUES ( ? );";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static boolean assignFormerToPromo(int former_id,int promo_id) throws SQLException {
        boolean isExecuted = false;
            sql = "UPDATE promos SET former_id = ? WHERE id = ?;";
            sql += "UPDATE formers SET ishaspromo = true WHERE id = ?;";
            PreparedStatement stmt = ConnectionDB.getConnectionDB().getConnection().prepareStatement(sql);
        try {
            stmt.setInt(1, former_id);
            stmt.setInt(2, promo_id);
            stmt.setInt(3, former_id);
            stmt.executeUpdate();
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            sql = "ROLLBACK ;";
            stmt.execute(sql);
        }
        return isExecuted;
    }

}
