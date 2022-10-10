package DB.Features;

import DB.Helpers.Helper;
import DB.Models.FormerCrud;
import DB.Models.LearnerCrud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    static Scanner scanner = new Scanner(System.in);

    public static boolean createUser(String user){
        System.out.println("____________________________________________ Create "+user+" _______________________________________");
        System.out.print("Enter the first Name of the new "+user+" : ");
        String fName = scanner.nextLine();
        System.out.print("Enter the last Name of the new " + user + " : ");
        String lName = scanner.nextLine();
        System.out.print("Enter the email address of the new " + user + " : ");
        String mail = scanner.nextLine();
        if(!fName.trim().equals("") && !lName.trim().equals("") && !mail.trim().equals("")){
            if(user.equals("Learner")){
                LearnerCrud.createLearner(fName,lName,mail);
            }
            if(user.equals("Former")){
                FormerCrud.createFormer(fName,lName,mail);
            }
            System.out.println( user + " Created successfully 👏👏👏👏");
            return true;
        }else{
            System.out.println("Please enter the information of user correctly");
            return false;
        }
    }
    public static boolean adminMenu() throws SQLException {
        System.out.println("Select the next operation :\n Press");
        System.out.println("\t1 : Create Former.");
        System.out.println("\t2 : Create Learner.");
        System.out.println("\t3 : Create promo.");
        System.out.println("\t4 : Assign former to promo.");
        System.out.println("\t5 : View all Formers");
        System.out.println("\t6 : View all Learners");
        System.out.println("\t7 : Logout.");
        String selectedOption = scanner.nextLine();
        int selectedNumOfOption=0;
        try{
            selectedNumOfOption = Integer.parseInt(selectedOption);
        }catch (Exception e){
            System.out.println("Something went wrong!!!!"+ e);
        }
        switch (selectedNumOfOption) {
            case 1 -> {
                while (true) {
                    boolean isFormerCreated = Admin.createUser("Former");
                    if (isFormerCreated) {
//                        Print.printUsers(Former.formers);
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }
                }
            }
            case 2 -> {
                while (true) {
                    boolean isLearnerCreated = Admin.createUser("Learner");
                    if (isLearnerCreated) {
//                        Print.printUsers(Former.formers);
//                        System.out.println("Here to add Former");
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }

                }
            }
            case 3 -> {
                while (true) {
                    boolean isPromoCreated = Promo.createPromo();
                    if (isPromoCreated) {
//                        Print.printUsers(Former.formers);
//                        System.out.println("Here to add Former");
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }
                }
            }case 4-> {
                while (true) {
                    boolean formerIsAssign = Promo.assignFormerToPromo();
                    if (formerIsAssign) {
//                        Print.printUsers(Former.formers);
//                        System.out.println("Here to add Former");
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }
                }
            }case 5-> {
                while (true) {
                    ArrayList<String[]> formers = FormerCrud.getAllFormers();
                    boolean isViewFormers = Print.printUsers(formers);
                    if (isViewFormers) {
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }
                }
            }case 6-> {
                while (true) {
                    ArrayList<String[]> learners = LearnerCrud.getAllLearners();
                    boolean isViewLearners = Print.printUsers(learners);
                    if (isViewLearners) {
                        break;
                    } else {
                        if (Helper.breakOrContinueProcess()) {
                            break;
                        }
                    }
                }
            }case 7->{
                System.out.println("Bye ✌️");
                return false;
            }
        }

        return true;
    }
}
