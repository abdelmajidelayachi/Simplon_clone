package DB.Models;

import java.sql.SQLException;
import java.sql.Statement;

public class BriefCrud {

    static Statement stmt = new ConnectionDB().statement;
    static String sql = "";

    public static boolean createBrief(String name, String context, String details,String sDate , String eDate , int promoId){
        boolean isExecuted = false;
        try {
            sql = "INSERT INTO briefs (name,context,body,start_date,deadline, promo_id) "
                    + "VALUES ( '"+name+"', '"+context+"', '"+details+"', '"+sDate+"','"+eDate+"','"+promoId+"' );";
            stmt.executeUpdate(sql);
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }
}
