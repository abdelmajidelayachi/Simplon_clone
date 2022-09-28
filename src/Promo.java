import java.util.ArrayList;
import java.util.Scanner;

public class Promo {

    public String namePromo;
    public String formerPromoRef;

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Promo> promos = new ArrayList<Promo>();
    public Promo(String name,String formerRef){
        this.namePromo = name;
        this.formerPromoRef = formerRef;
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


}
