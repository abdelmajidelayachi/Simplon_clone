import java.util.ArrayList;

public class Print {

    public static void printUsers(ArrayList<Person> users){
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|    Reference     |   First Name   |   Last Name    |           email        |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (Person user : users) {
            System.out.println("    " + user.reference + "     |   " + user.firstName + "   |   " + user.lastName + "    |   " + user.email );
            System.out.println("|-----------------------------------------------------------------------------|");
        }
    }
    public static void printPromos(){
        ArrayList<Promo> promos = Promo.promos;
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|     Reference     |      Promo name     |           Former reference        |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (Promo promo : promos) {
            System.out.println("    " + promo.promoReference + "     |   " + promo.namePromo + "   |   " + promo.formerPromoRef + " ");
            System.out.println("|-----------------------------------------------------------------------------|");
        }

    }


}
