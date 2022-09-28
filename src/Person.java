import java.util.Calendar;

public class Person {
    public String reference;
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public Person(String fName,String lName,String mail,String role,int lastUser){
        this.reference = role + Calendar.getInstance().get(Calendar.YEAR)+lastUser;
        this.firstName = fName;
        this.lastName = lName;
        this.email = mail;
        this.password = this.firstName.trim().toLowerCase()+"22";
    }
}
