package DB.Features;

import DB.Helpers.Helper;
import DB.Models.PromoCrud;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Former  {
    static Scanner scanner = new Scanner(System.in);

    public static boolean formerMenu(int idFormer){
        System.out.println("Select the next operation : Press ");
        System.out.println("1 : Add Learner to my promo.");
        System.out.println("2 : Create brief.");
        System.out.println("3 : Logout.");
        String selectedOption = scanner.nextLine();
        int selectedNumOfOption = Helper.handleException(selectedOption);
        switch (selectedNumOfOption){
            case 1 ->{
                while (true) {
                    boolean isPromoLearnerAdded = Promo.addLearner(idFormer);
                    if (isPromoLearnerAdded)
                        break;
                    else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 2 ->{
                while (true){
                    boolean isBriefCreated = false;
                    String[] myPromo = PromoCrud.getPromoByFormer(idFormer).get(0);
                    if (myPromo!=null){
                        isBriefCreated = Brief.CreateBrief(myPromo);
                    }
                    if(isBriefCreated)
                        break;
                    else{
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
