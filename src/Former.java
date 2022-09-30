import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Former extends Person {
    static ArrayList<Person> formers = new ArrayList<Person>();

    static Scanner scanner = new Scanner(System.in);
    public Former(String fName,String lName,String mail){
        super(fName,lName,mail,"FORMER",Former.getFormers().size()+1);
    }

    public static ArrayList<Person> getFormers(){
        return formers;
    }
    public static void createFormer(String fName,String lName,String mail){
        formers.add(new Former(fName,lName,mail));
    }
    public static boolean formerMenu(String loggedInRef){
        System.out.println("Select the next operation : Press ");
        System.out.println("1 : Add Learner to my promo.");
        System.out.println("2 : Create brief.");
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
                    boolean isPromoLearnerAdded = Promo.addLearner(loggedInRef);
                    if (isPromoLearnerAdded)
                        break;
                    else {
                        if(Helper.breakOrContinueProcess()){
                            break;
                        }
                    }
                }
            }case 2 ->{
                while (true){
                    boolean isBriefCreated = false;
                    if (Promo.searchPromoRef(loggedInRef)!=null){
                        isBriefCreated = Brief.CreateBrief(Objects.requireNonNull(Promo.searchPromoRef(loggedInRef)));
                    }
                    if(isBriefCreated)
                        break;
                    else{
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
