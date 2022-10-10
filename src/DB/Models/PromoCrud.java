package DB.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class PromoCrud {
    static Statement stmt = new ConnectionDB().statement;
    static String sql = "";

    public static ArrayList<String[]> getAllPromos(){
        ArrayList<String[]> promos = new ArrayList<>();
        try {
            sql = "SELECT * FROM promos;";
            ResultSet rsPromos = stmt.executeQuery(sql);
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
            ResultSet rsPromos = stmt.executeQuery(sql);
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
            sql = "SELECT * FROM promos WHERE former_id = "+formerId+" ;";
            ResultSet rsPromos = stmt.executeQuery(sql);
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
                    + "VALUES ( '"+name+"' );";
            stmt.executeUpdate(sql);
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static boolean assignFormerToPromo(int former_id,int promo_id) throws SQLException {
        boolean isExecuted = false;
        try {
            sql = "UPDATE promos SET former_id = "+former_id+" WHERE id = "+promo_id+";";
            sql += "UPDATE formers SET ishaspromo = true WHERE id = "+former_id+";";
            stmt.executeUpdate(sql);
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            sql = "ROLLBACK ;";
            stmt.execute(sql);
        }
        return isExecuted;
    }

}
