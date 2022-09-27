import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {

    static ArrayList<Person> admins = new ArrayList<Person>();
    public Admin(String fName,String lName,String mail){
        super(fName,lName,mail);
    }

    public static ArrayList<Person> getAdmins(){
        return admins;
    }
    public static void createAdmin(String fName,String lName,String mail){
        admins.add(new Admin(fName,lName,mail));
    }

    public static void adminMenu(){
        System.out.println("Select the next operation : Press");
        System.out.println("1 : Create Former.");
        System.out.println("2 : Create Learner.");
        System.out.println("3 : Create promo.");
    }





}
