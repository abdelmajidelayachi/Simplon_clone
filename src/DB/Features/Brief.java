package DB.Features;

import DB.Helpers.Helper;
import DB.Models.BriefCrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Brief {

    static Scanner scanner = new Scanner(System.in);
    public static boolean CreateBrief(String[] promo){

        System.out.println("------------------------------- Create brief for " + promo[1] + "----------------------------------");
        int promoId = Integer.parseInt(promo[0]);
        System.out.print("Give name to this brief : ");
        String name = scanner.nextLine();
        System.out.print("Context of this brief is : ");
        String context = scanner.nextLine();
        System.out.print("Details of this brief is : ");
        String details = scanner.nextLine();
        System.out.println("Start date of this brief is : ");
        LocalDate sDate = Helper.getDateFromUser();
        System.out.println("Deadline of this brief is : ");
        LocalDate eDate = Helper.getDateFromUser();
        System.out.println(sDate);
        if(!name.trim().isEmpty() && !context.trim().isEmpty() && !(sDate ==null) && !(eDate ==null) && !details.trim().isEmpty()){
            if(BriefCrud.createBrief(name,context,details,sDate.toString(),eDate.toString(),promoId))
            {
                System.out.println("Brief created successfully 👏👏🙂🙂");
                return true;
            }
//            Print.printBriefForFormer(promo.promoReference);
//            SendMail.sendEmail(promo.promoReference,name,context);
        }
        return false;

    }


}
