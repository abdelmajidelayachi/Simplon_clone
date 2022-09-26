import java.util.ArrayList;
import java.util.List;

public class Learner {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    static ArrayList<Learner> learners = new ArrayList<Learner>();
    public Learner(String fName,String lName,String mail){
            this.firstName = fName;
            this.lastName = lName;
            this.email = mail;
            this.password = this.firstName.trim().toLowerCase()+"22";
    }
    public static ArrayList<Learner> getLearners(){
        return learners;
    }
    public static ArrayList<Learner> CreateLearner(String fName,String lName,String mail){
        learners.add(new Learner(fName,lName,mail));
        return learners;
    }
}
