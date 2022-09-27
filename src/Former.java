import java.util.ArrayList;

public class Former extends Person {
    static ArrayList<Person> formers = new ArrayList<Person>();
    public Former(String fName,String lName,String mail){
        super(fName,lName,mail);
    }

    public static ArrayList<Person> getFormers(){
        return formers;
    }
    public static void createFormer(String fName,String lName,String mail){
        formers.add(new Former(fName,lName,mail));
    }
}
