import java.util.ArrayList;
import java.util.List;

public class Learner extends Person {
    static ArrayList<Person> learners = new ArrayList<Person>();

    public Learner(String fName,String lName,String mail){
        super(fName,lName,mail);
    }
    public static ArrayList<Person> getLearners(){
        return learners;
    }
    public static void createLearner(String fName,String lName,String mail){
        learners.add(new Learner(fName,lName,mail));
    }
}
