package DB.Features;

import DB.Helpers.Helper;
import DB.Models.LearnerCrud;
import DB.Models.PromoCrud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static DB.Helpers.Helper.handleException;

public class Promo {

    static Scanner scanner = new Scanner(System.in);
    public static boolean createPromo (){
        System.out.println("------------------------------ Create Promotion ----------------------------");
        System.out.print("Enter promotion Name : ");
        String nPromo = scanner.nextLine();
        if(!nPromo.isEmpty()){
            if(PromoCrud.createPromo(nPromo)){
                System.out.println("Promo created successfully 🙂");
            }else{
                System.out.println("Promo Failed to create please try again!!");
            }
            Print.printPromos();
            return true;
        }
        return false;
    }

    public static boolean assignFormerToPromo() throws SQLException {
        System.out.println("Select the promo : ");
        Print.printPromos();
        int promoId = handleException(scanner.nextLine());
        System.out.println("Select id former for the promo : ");
        Print.printFormerRest();
        int formerId = handleException(scanner.nextLine());
        if(PromoCrud.assignFormerToPromo(formerId,promoId)){
            System.out.println("Former assigned successfully");
            return true;
        }else{
            System.out.println("Something went wrong!!");
        }
        return true;
    }

    public static boolean addLearner(int idFormer){
        ArrayList<String[]> learners = LearnerCrud.getLearnerWithNoPromo();
        ArrayList<String[]> promo = PromoCrud.getPromoByFormer(idFormer);
        int idPromo = Integer.parseInt(promo.get(0)[0]);
        System.out.println("|------------------------- Your Promo "+promo.get(0)[1]+"------------------------|");
        System.out.println("Select Your learner for your promo : ");
        System.out.println("|-----------------------------------------------------------------------------------------|");
        System.out.println("|   Select      |      First Name      |     Last Name      |               email         |");
        System.out.println("|-----------------------------------------------------------------------------------------|");
        for (String[] learner : learners) {
                System.out.println("|   Enter " + learner[0] + "  |    " + learner[1] + "     |   " + learner[1] + "   |   " + learner[2] + "    |");
                System.out.println("|-----------------------------------------------------------------------------------------|");
        }
        int idLearner = Helper.handleException(scanner.nextLine());
        if( idLearner < learners.size() || idLearner > 0) {
            return LearnerCrud.assignPromoToLearner(idPromo, idLearner);
        }
        return false;

    }


}
