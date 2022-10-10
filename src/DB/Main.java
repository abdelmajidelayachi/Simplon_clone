package DB;

import DB.Auth.Auth;
import DB.Features.Admin;
import DB.Features.Former;
import DB.Features.Learner;
import DB.Helpers.Helper;
import DB.Models.AdminCrud;
import DB.Models.FormerCrud;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Handler;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int idUser;

    private static boolean checkEmailWithPassword(String userRole){
        String email;
        String password;
        while(true){
            System.out.print("Please Enter your email : ");
            email = scanner.nextLine();
            System.out.print("Please Enter your password : ");
            password = scanner.nextLine();
            int userId = Auth.checkAuthAdmin(email,password,userRole);
            if( userId!=0 ){
                idUser = userId;
                return true;
            }
            if(Helper.breakOrContinueProcess()){
                return false;
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
            int roleNumber = Helper.handleException(inRole);
            switch (roleNumber) {
                case 1 -> {
                    role = "Admin";
                }
                case 2 -> {
                    role = "Former";
                }
                case 3 -> {
                    role = "Learner";
                }
                default -> {
                    role = "INVALID";
                    System.out.println("Invalid Role!!");
                }
            }
            if(!role.equals("INVALID")){
                isLogin = checkEmailWithPassword(role);
                if (isLogin){
                    return role;
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {

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
                        boolean isLoggin = Former.formerMenu(idUser);
                        if (!isLoggin) {
                            break;
                        }
                    }
                }
                case "Learner" -> {
                    System.out.println("Welcome to Learners Home page 🤩🤩🤩🤩");
                    while (true) {
                        boolean isLoggin = Learner.learnerMenu(idUser);
                        if (!isLoggin) {
                            break;
                        }
                    }
                }
                default -> System.exit(0);
            }
        }
    }
}