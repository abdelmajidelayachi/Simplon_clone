public class Person {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public Person(String fName,String lName,String mail){
        this.firstName = fName;
        this.lastName = lName;
        this.email = mail;
        this.password = this.firstName.trim().toLowerCase()+"22";
    }
}
