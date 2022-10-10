package DB.Features;

import DB.Helpers.Helper;
import DB.Models.LearnerCrud;

import java.util.ArrayList;
import java.util.Scanner;

public class Learner  {

    static Scanner scanner = new Scanner(System.in);


    public static boolean learnerMenu(int idLearner){
        System.out.println("Select the next operation : Press ");
        System.out.println("1 : View all my brief.");
        System.out.println("2 : View my recent brief.");
        System.out.println("3 : Logout.");
        int selectedOption = Helper.handleException(scanner.nextLine());
        switch (selectedOption){
            case 1 ->{
                while (true) {
                    boolean isLearnerViewBrief = false;
                    String[] promo = LearnerCrud.getLearner(idLearner);
                    if (promo != null){
                        int promoId = Integer.parseInt(promo[0]);
                        isLearnerViewBrief = Print.printBriefForLearner(promoId,"All");
                    }
                    if (isLearnerViewBrief)
                        break;
                    else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 2 ->{
                while (true) {
                    boolean isLearnerViewBrief = false;
                    String[] promo = LearnerCrud.getLearner(idLearner);
                    if (promo != null){
                        int promoId = Integer.parseInt(promo[0]);
                        isLearnerViewBrief = Print.printBriefForLearner(promoId,"Recent");
                    }
                    if (isLearnerViewBrief)
                        break;
                    else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 3->{
                System.out.println("Bye ✌️");
                return false;
            }
        }
        return true;
    }

}
