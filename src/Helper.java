import java.time.LocalDate;
import java.util.Scanner;

public class Helper {
    static Scanner scanner = new Scanner(System.in);
    public static LocalDate getDateFromUser(){
        boolean isValidDate;
        LocalDate date = null;
        do{
            System.out.print("-\tday : ");
            String day = scanner.nextLine();
            System.out.print("-\tmonth : ");
            String month = scanner.nextLine();
            System.out.print("-\tyear : ");
            String year = scanner.nextLine();
            try{
                date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                isValidDate = true;
            }catch (Exception e){
                System.out.println("Something went wrong "+e.getMessage());
                isValidDate = false;
                if(breakOrContinueProcess()){
                    return null;
                }
            }
        }while (!isValidDate);
        return date;
    }

    public static boolean breakOrContinueProcess(){
        int option = -1;
        do {
            System.out.println("To continue : Press 1");
            System.out.println("To back     : Press 0");
            option = handleException(scanner.nextLine());
        } while (option == -1);
        return option == 0;
    }
    public static int handleException(String inputOption){
        try{
            return Integer.parseInt(inputOption);
        }catch (Exception e){
            System.out.println("Something went wrong!!!!"+ e);
            return -1;
        }
    }
}
