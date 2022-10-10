import java.util.ArrayList;
import java.util.Scanner;

public class Learner extends Person {
    static ArrayList<Person> learners = new ArrayList<Person>();

    static Scanner scanner = new Scanner(System.in);
    public Learner(String fName,String lName,String mail){
        super(fName,lName,mail,"LEARNER",Learner.getLearners().size()+1);
    }
    public static ArrayList<Person> getLearners(){
        return learners;
    }
    public static void createLearner(String fName,String lName,String mail){
        learners.add(new Learner(fName,lName,mail));
    }

    public static boolean addRefPromoToLearnInfo(int indexOfLearnerObj,String refPromo){
        learners.get(indexOfLearnerObj).promoRef = refPromo;
        return true;
    }

    public static Person searchLearnerByReference(String learnerRef){
        for (Person learner : learners) {
            if(learner.reference.equals(learnerRef)){
                return learner;
            }
        }
        return null;
    }
    public static boolean learnerMenu(String loggedInRef){
        System.out.println("Select the next operation : Press ");
        System.out.println("1 : View all my brief.");
        System.out.println("2 : View my recent brief.");
        System.out.println("3 : Logout.");
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
                    boolean isLearnerViewBrief = false;
                    if (Learner.searchLearnerByReference(loggedInRef)!=null){
                        isLearnerViewBrief = Print.printBriefForLearner(Learner.searchLearnerByReference(loggedInRef));
                    }
                    if (isLearnerViewBrief)
                        break;
                    else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 2 ->{
                while (true){
                    boolean isLearnerViewBrief = false;
                    if (Learner.searchLearnerByReference(loggedInRef)!=null){
                        isLearnerViewBrief = Print.printRecentBrief(Learner.searchLearnerByReference(loggedInRef));
                    }
                    if (isLearnerViewBrief)
                        break;
                    else {
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
