import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Promo {

    public String namePromo;
    public String formerPromoRef;
    public String promoReference;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Promo> promos = new ArrayList<>();
    public Promo(String name,String formerRef){
        this.namePromo = name;
        this.formerPromoRef = formerRef;
        this.promoReference = "Promo" + Calendar.getInstance().get(Calendar.YEAR)+promos.size()+1;
    }

    // get all promo
    public static ArrayList<Promo> getPromos(){
        return promos;
    }
    public static boolean createPromo (){
        System.out.println("------------------------------ Create Promotion ----------------------------");
        System.out.print("Enter promotion Name : ");
        String nPromo = scanner.nextLine();
        System.out.println("Select reference of Former : ");
        System.out.println("|-----------------------------------------------------------------------------------------|");
        System.out.println("|   Select  |    Reference     |   First Name   |   Last Name    |           email        |");
        System.out.println("|-----------------------------------------------------------------------------------------|");

        ArrayList<Person> formers = Former.getFormers();
        int i=0;
        for (Person former : formers) {

            System.out.println("|   Press " + i + "  |    " + former.reference + "     |   " + former.firstName + "   |   " + former.lastName + "    |" + former.email + "|");
            System.out.println("|-----------------------------------------------------------------------------------------|");
            i++;
        }
        String refScanner = scanner.nextLine();
        int selectedNumRef = 0;
        String referenceFormer = "";
        try{
            selectedNumRef = Integer.parseInt(refScanner);
            referenceFormer = formers.get(selectedNumRef).reference;
        }catch (Exception e){
            System.out.println("Something went wrong " + e.getMessage());
        }
        if(!referenceFormer.isEmpty()){
            promos.add(new Promo(nPromo,referenceFormer));
            System.out.println("Promo created successfully 🙂");
            return true;
        }
        return false;
    }
    public static boolean addLearner(String loggedInRef){
        // here where i'm going to add learner reference
        System.out.println("----------------------------------------- Adding Learner to my Promo ---------------------------------------------");
        System.out.print("Your promo is  : ");
        String promoRef = Objects.requireNonNull(searchPromoRef(loggedInRef)).promoReference;
        System.out.println("Select Your learner promo : ");
        System.out.println("|-----------------------------------------------------------------------------------------|");
        System.out.println("|   Select  |    Reference     |   First Name   |   Last Name    |           email        |");
        System.out.println("|-----------------------------------------------------------------------------------------|");

        ArrayList<Person> learners = Learner.getLearners();
        int i=0;
        for (Person learner : learners) {
            if(learner.promoRef.isEmpty()){
                System.out.println("|   Press " + i + "  |    " + learner.reference + "     |   " + learner.firstName + "   |   " + learner.lastName + "    |" + learner.email + "|");
                System.out.println("|-----------------------------------------------------------------------------------------|");
            }
                i++;
        }
        String refScanner = scanner.nextLine();
        int selectedNumRef = 0;
        String referenceLearner = "";
        try{
            selectedNumRef = Integer.parseInt(refScanner);
            referenceLearner = learners.get(selectedNumRef).reference;
        }catch (Exception e){
            System.out.println("Something went wrong " + e.getMessage());
        }
        if(!referenceLearner.isEmpty()){
            if(Learner.addRefPromoToLearnInfo(selectedNumRef,promoRef))
                System.out.println("Learner added successfully");
        }
        return false;
    }

    // search promo ref
    public static Promo searchPromoRef(String formerRef){
         for (Promo promo : promos) {
            if(promo.formerPromoRef.equals(formerRef)){
                System.out.println(promo.namePromo);
                return promo;
            }
         }
         return null;
    }


}
