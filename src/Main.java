import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int checkEmailIsExists(String property,ArrayList<Learner> learners){
        for (int i = 0; i < learners.size() ; i++) {
            if(property.equals(learners.get(i).email)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Learner.CreateLearner("Abdelmajid","El Ayachi","elayachiabdel@gmail.com");
        Learner.CreateLearner("Mohammed","El Ayachi","elayachiabdel@gmail.com");
        ArrayList<Learner> learners = Learner.getLearners();
        /**
        for (int i = 0; i < Learner.getLearners().size(); i++) {
            System.out.println("user "+i);
            System.out.println("firstName : "+Learner.getLearners().get(i).firstName);
            System.out.println("lastName : "+Learner.getLearners().get(i).lastName);
            System.out.println("email : "+Learner.getLearners().get(i).email);
            System.out.println("password : "+Learner.getLearners().get(i).password);
        }
        */
        String email;
        String password;
       while(true){
            System.out.print("Please Enter your email : ");
             email = scanner.nextLine();
            System.out.print("Please Enter your password : ");
            password = scanner.nextLine();
           if(checkEmailIsExists(email,learners) != -1){
               if(learners.get(checkEmailIsExists(email,learners)).password.equals(password)){
                break;
               }
           }
       }
        System.out.println(email +" password : "+ password);

    }
}