package DB.Features;

import DB.Models.BriefCrud;
import DB.Models.FormerCrud;
import DB.Models.PromoCrud;

import java.time.LocalDate;
import java.util.ArrayList;

public class Print {

    public static boolean printUsers(ArrayList<String[]> users){
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|     First Name      |      Last Name        |               email           |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (String[] user : users) {
            System.out.println("    " + user[1] + "     |   " + user[2] + "   |   " + user[3] + "      " );
            System.out.println("|-----------------------------------------------------------------------------|");
        }
        return true;
    }
    public static void printPromos(){
        ArrayList<String[]> promos = PromoCrud.getWithNoFormer();
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|     id     |      Promo name     |           Former reference        |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (String[] promo : promos) {
            System.out.println("    " + promo[0] + "     |   " + promo[1] + "   |   " + promo[2] + " ");
            System.out.println("|-----------------------------------------------------------------------------|");
        }

    }
    public static void printAllPromos(){
        ArrayList<String[]> promos = PromoCrud.getAllPromos();
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|     id     |      Promo name     |           Former reference        |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (String[] promo : promos) {
            System.out.println("    " + promo[0] + "     |   " + promo[1] + "   |   " + promo[2] + " ");
            System.out.println("|-----------------------------------------------------------------------------|");
        }

    }
    public static void printFormerRest(){
        ArrayList<String[]> formers = FormerCrud.getNoAssignedFormer();
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|    id     |   First Name   |   Last Name    |           email        |");
        System.out.println("|-----------------------------------------------------------------------------|");
        for (String[] former : formers) {
            System.out.println("    " + former[0] + "     |   " + former[1] + "   |   " + former[2] + "    |   " + former[3] );
            System.out.println("|-----------------------------------------------------------------------------|");
        }
    }
    public static boolean printBriefForLearner(int promoId,String sp){

        ArrayList<String[]> briefs  = sp.equals("All") ? BriefCrud.getAllPromoBriefs(promoId):BriefCrud.getRecentBrief(promoId);
        int i=1;
        System.out.println(promoId);
        for (String[] brief : briefs) {
                System.out.println("|------------------------------------------- Briefs " + i++ + "----------------------------------|");
                System.out.println("\tName : " + brief[1]);
                System.out.println("\tContext : " + brief[2]);
                System.out.println("\tDetails : " + brief[3]);
                System.out.println("\tStart time : " + brief[4]);
                System.out.println("\tDeadline : " + brief[5]);

        }
                System.out.println("|----------------------------------------------------------------------------------------|");
        return true;
    }




}
