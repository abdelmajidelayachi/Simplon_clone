import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String loggedInUserRef ="";
    private static int checkEmailIsExists(String property,ArrayList<Person> users){
        for (int i = 0; i < users.size() ; i++) {
            if(property.equals(users.get(i).email)){
                return i;
            }
        }
        return -1;
    }

    private static boolean checkEmailWithPassword(ArrayList<Person> users){
        String email;
        String password;
        while(true){
            System.out.print("Please Enter your email : ");
            email = scanner.nextLine();
            System.out.print("Please Enter your password : ");
            password = scanner.nextLine();

            int indexOfUser = checkEmailIsExists(email,users);
            if(indexOfUser != -1){
                if(users.get(indexOfUser).password.equals(password)){
                    loggedInUserRef =users.get(indexOfUser).reference;
                    return true;
                }else{
                    System.out.println("To continue : Press 1");
                    System.out.println("To back     : Press 0");
                    if(Integer.parseInt(scanner.nextLine())==0){
                        return false;
                    }
                }
            }else{
                System.out.println("To continue : Press 1");
                System.out.println("To back     : Press 0");
                if(Integer.parseInt(scanner.nextLine())==0){
                    return false;
                }
            }
        }
    }
    private static String authantification(){
        String role;
        boolean isLogin = false;
        while (true) {
            System.out.println("Please select your Role : ");
            System.out.println("1 : Admin");
            System.out.println("2 : Former");
            System.out.println("3 : Learner\n\t:");
            String inRole = scanner.nextLine();
            int roleNumber = Integer.parseInt(inRole);
            ArrayList<Person> admins = Admin.getAdmins();
            ArrayList<Person> formers = Former.getFormers();
            ArrayList<Person> learners = Learner.getLearners();
            switch (roleNumber) {
                case 1 -> {
                    role = "Admin";
                    isLogin = checkEmailWithPassword(admins);
                }
                case 2 -> {
                    role = "Former";
                    isLogin = checkEmailWithPassword(formers);
                }
                case 3 -> {
                    role = "Learner";
                    isLogin = checkEmailWithPassword(learners);
                }
                default -> {
                    role = "INVALID";
                    System.out.println("Invalid Role!!");
                }
            }
            if(!role.equals("INVALID") && isLogin){
                return role;
            }
        }
    }

    public static void main(String[] args) {
        Admin.createAdmin("admin","El Ayachi","admin");
        Former.createFormer("Former","El Ayachi","former");
        Learner.createLearner("learner1","El Ayachi","learner11");
        Learner.createLearner("learner1","El Ayachi","learner12");
        Learner.createLearner("learner1","El Ayachi","learner13");
      /*   Former.createFormer("Mohammed","El Ayachi","elayachiabdel@gmail.com");*/
//        System.out.println("-------------------learners-----------------------");
//        ArrayList<Person> learners = Learner.getLearners();
//         for (int i = 0; i < Learner.getLearners().size(); i++) {
//            System.out.println("user "+i);
//            System.out.println("firstName : "+Learner.getLearners().get(i).firstName);
//            System.out.println("lastName : "+Learner.getLearners().get(i).lastName);
//            System.out.println("email : "+Learner.getLearners().get(i).email);
//            System.out.println("password : "+Learner.getLearners().get(i).password);
//        }
//        System.out.println("-------------------------------formers---------------------------------------------");
//         ArrayList<Person> formers = Former.getFormers();
//         for (int i = 0; i < formers.size(); i++) {
//            System.out.println("user "+i);
//            System.out.println("firstName : "+formers.get(i).firstName);
//            System.out.println("lastName : "+formers.get(i).lastName);
//            System.out.println("email : "+formers.get(i).email);
//            System.out.println("password : "+formers.get(i).password);
//        }
//        System.out.println("----------------------admins---------------------");
         ArrayList<Person> admins = Admin.getAdmins();
         for (int i = 0; i < admins.size(); i++) {
            System.out.println("user "+i);
            System.out.println("firstName : "+admins.get(i).firstName);
            System.out.println("lastName : "+admins.get(i).lastName);
            System.out.println("email : "+admins.get(i).reference);
        }
        while (true) {
            String role = authantification();
            switch (role) {
                case "Admin" -> {
                    System.out.println("welcome to Administration Home page 🤩🤩🤩🤩");
                    while (true) {
                        boolean isLoggin = Admin.adminMenu();
                        if (!isLoggin) {
                            break;
                        }
                    }
                }
                case "Former" -> {
                    System.out.println("Welcome to Formers Home page 🤩🤩🤩🤩");
                    while (true) {
                        boolean isLoggin = Former.formerMenu(loggedInUserRef);
                        if (!isLoggin) {
                            break;
                        }
                    }
                }
                case "Learner" -> {
                    System.out.println("Welcome to Learners Home page 🤩🤩🤩🤩");
                    scanner.nextLine();
                }
                default -> System.exit(0);
            }
        }


    }
}