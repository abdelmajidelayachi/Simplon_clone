import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Person> admins = new ArrayList<Person>();
    public Admin(String fName,String lName,String mail){
        super(fName,lName,mail,"ADMIN",Admin.getAdmins().size()+1);
    }

    public static ArrayList<Person> getAdmins(){
        return admins;
    }
    public static void createAdmin(String fName,String lName,String mail) {
        admins.add(new Admin(fName,lName,mail));
    }

    // Here we can create a Learner or Former 👇👇👇
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
                Learner.createLearner(fName,lName,mail);
            }
            if(user.equals("Former")){
                Former.createFormer(fName,lName,mail);
            }
            System.out.println( user + " Created successfully 👏👏👏👏");
            return true;
        }else{
            System.out.println("Please enter the information of user correctly");
            return false;
        }
    }
    public static boolean adminMenu(){
        System.out.println("Select the next operation : Press");
        System.out.println("1 : Create Former.");
        System.out.println("2 : Create Learner.");
        System.out.println("3 : Create promo.");
        System.out.println("4 : Logout.");
        String selectedOption = scanner.nextLine();
        int selectedNumOfOption=0;
        try{
            selectedNumOfOption = Integer.parseInt(selectedOption);
        }catch (Exception e){
            System.out.println("Something went wrong!!!!"+ e);
        }
        switch (selectedNumOfOption){
            case 1 ->{
                while (true) {
                    boolean isFormerCreated = Admin.createUser("Former");
                    if (isFormerCreated) {
                        Print.printUsers(Former.formers);
                        break;
                    }else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 2 ->{
                while (true){
                    boolean isLearnerCreated = Admin.createUser("Learner");
                    if(isLearnerCreated){
                         Print.printUsers(Learner.learners);
                         break;
                    }else{
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 3-> {
                while (true){
                    boolean isPromoCreated = Promo.createPromo();
                    if(isPromoCreated) {
                        Print.printPromos();
                        break;
                    }
                    else{
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }

            }case 4->{
                System.out.println("Bye ✌️");
                return false;
            }
        }
        return true;
    }





}
