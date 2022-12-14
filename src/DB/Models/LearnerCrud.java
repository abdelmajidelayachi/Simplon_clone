package DB.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LearnerCrud {

    static String sql = "";

    public static String[] getLearner(int learnerId){
            String[] learner = new String[5];
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM learners WHERE id = "+learnerId+" ;";
            ResultSet rsLearners = stmt.executeQuery(sql);
            while (rsLearners.next()){
                learner =new String[]{rsLearners.getString("id"), rsLearners.getString("fname"),rsLearners.getString("lname"),rsLearners.getString("email"),rsLearners.getString("promo_id")};
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return learner;
    }

    public static boolean createLearner(String fName, String lName, String email){
        String password = "learner"+fName.toLowerCase();
        boolean isExecuted = false;
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "INSERT INTO learners (FNAME,LNAME,EMAIL,PASSWORD) "
                    + "VALUES ( '"+fName+"', '"+lName+"', '"+email+"', '"+password+"' );";
            stmt.executeUpdate(sql);
            isExecuted = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }
    public static ArrayList<String[]> getLearnerWithNoPromo(){
        ArrayList<String[]> learners = new ArrayList<>();
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM learners WHERE promo_id is null ;";
            ResultSet rsLearners = stmt.executeQuery(sql);
            while (rsLearners.next()){
                learners.add(new String[]{rsLearners.getString("id"), rsLearners.getString("fname"),rsLearners.getString("lname"),rsLearners.getString("email"),rsLearners.getString("promo_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return learners;
    }
    public static ArrayList<String[]> getAllLearners(){
        ArrayList<String[]> learners = new ArrayList<>();
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM learners ;";
            ResultSet rsLearners = stmt.executeQuery(sql);
            while (rsLearners.next()){
                learners.add(new String[]{rsLearners.getString("id"), rsLearners.getString("fname"),rsLearners.getString("lname"),rsLearners.getString("email"),rsLearners.getString("promo_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return learners;
    }

    public static boolean assignPromoToLearner(int promoId,int learnerId){
        boolean isExecuted = false;
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "UPDATE learners SET promo_id = "+promoId+" WHERE id = "+learnerId+";";
            stmt.executeUpdate(sql);
            isExecuted = true;
            System.out.println("Learner assigned to promo successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isExecuted;
    }

    public static ArrayList<String[]> getAllLearnerInPromo(int promoId){
        ArrayList<String[]> learners = new ArrayList<>();
        try {
          Statement stmt = ConnectionDB.getConnectionDB().getConnection().createStatement();
            sql = "SELECT * FROM learners WHERE promo_id ="+promoId+" ;";
            ResultSet rsLearners = stmt.executeQuery(sql);
            while (rsLearners.next()){
                learners.add(new String[]{rsLearners.getString("id"), rsLearners.getString("fname"),rsLearners.getString("lname"),rsLearners.getString("email"),rsLearners.getString("promo_id")});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return learners;
    }
}
