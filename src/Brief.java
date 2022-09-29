import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Brief {

    public String briefName;
    public String briefContext;
    public LocalDate deadline;
    public LocalDate startDate;

    static ArrayList<Brief> briefs = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public Brief (String bName,String bContext, LocalDate eDate, LocalDate sDate){
        briefName = bName;
        deadline = eDate;
        startDate = sDate;
        briefContext = bContext;
    }

    public static boolean CreateBrief(Promo promo){

        System.out.println("------------------------------- Create brief for " + promo.namePromo + "----------------------------------");
        System.out.print("Give name to this brief : ");
        String name = scanner.nextLine();
        System.out.print("Context of this brief is : ");
        String context = scanner.nextLine();
        System.out.println("Start date of this brief is : ");
        LocalDate sDate = Helper.getDateFromUser();
        System.out.println("Deadline of this brief is : ");
        LocalDate eDate = Helper.getDateFromUser();
        System.out.println(sDate);
        if(!name.trim().isEmpty() && !context.trim().isEmpty() && !(sDate ==null)){
            briefs.add(new Brief(name,context,eDate,sDate));
            return true;
        }
        return false;

    }


}
