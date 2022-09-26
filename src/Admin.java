import java.util.Scanner;

public class Admin {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String login(){
        Scanner scanner = new Scanner(System.in);
        email = scanner.nextLine();
        password = scanner.nextLine();
        return email;
    }


}
