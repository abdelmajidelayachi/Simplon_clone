import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

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

    public static void printBriefForFormer(String formerRef){
        ArrayList<Brief> briefs = Brief.briefs;
        for (Brief brief : briefs) {
        System.out.println("|------------------------------------------- Briefs "+brief.promoReference+"----------------------------------|");
            System.out.println("Name : " + brief.briefName );
            System.out.println("Context : " + brief.briefContext);
            System.out.println("Start time : "+ brief.startDate);
            System.out.println("Deadline : "+ brief.deadline);
            System.out.println("|--------------------------------------------------------------------------------------------------|");
        }
    }
    public static boolean printBriefForLearner(Person learner){
        ArrayList<Brief> briefs = Brief.briefs;
        for (Brief brief : briefs) {
            if (learner.promoRef.equals(brief.promoReference)) {
                System.out.println("|------------------------------------------- Briefs " + brief.promoReference + "----------------------------------|");
                System.out.println("Name : " + brief.briefName);
                System.out.println("Context : " + brief.briefContext);
                System.out.println("Start time : " + brief.startDate);
                System.out.println("Deadline : " + brief.deadline);
                System.out.println("|--------------------------------------------------------------------------------------------------|");
            }
        }
        return true;
    }
    public static boolean printRecentBrief(Person learner){
        ArrayList<Brief> briefs = Brief.briefs;
        LocalDate recentDate = briefs.get(0).startDate;
        int indexOfRecentBrief = 0;
        for (Brief brief : briefs) {
            if(recentDate.isBefore(brief.startDate) && learner.promoRef.equals(brief.promoReference)){
                recentDate = brief.startDate;
                indexOfRecentBrief = briefs.indexOf(brief);
            }
        }
        System.out.println("|------------------------------------------- Briefs " + briefs.get(indexOfRecentBrief).promoReference + "----------------------------------|");
        System.out.println("Name : " + briefs.get(indexOfRecentBrief).briefName);
        System.out.println("Context : " + briefs.get(indexOfRecentBrief).briefContext);
        System.out.println("Start time : " + briefs.get(indexOfRecentBrief).startDate);
        System.out.println("Deadline : " + briefs.get(indexOfRecentBrief).deadline);
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        return true;
    }



}
