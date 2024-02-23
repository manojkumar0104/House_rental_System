package src.view;

import java.sql.SQLException;
import java.util.Scanner;

import src.model.Owneraccess;
import src.model.User;
import src.model.Useraccess;

public class Signup {
    static Scanner sc = new Scanner(System.in);

    public static void user() throws SQLException {
        
        System.out.println("Enter username :");
        String name = sc.nextLine();
        System.out.println("Enter email :");
        String email = sc.nextLine();
        System.out.println("Enter Phone number :");
        String ph = sc.nextLine();
        String pass="";
        while (true) {
            System.out.println("Enter Password :");
            pass = sc.nextLine();
            System.out.println("Confirm Password :");
            String cpass = sc.nextLine();

            if (!pass.equals(cpass)) {
                System.out.println("! Enter correct password ");
            } else {

                break;
            }
        }
        Useraccess use = new Useraccess();
        User u = new User();
        u.setname(name);
        u.setemail(email);
        u.setpass(pass);
        u.setph(ph);
        use.Signupuser(u);
        System.out.println("Login user :");
        Login.user();

    }

    public static void owner() throws SQLException {

        System.out.println("Enter username :");
        String name = sc.nextLine();
        System.out.println("Enter email :");
        String email = sc.nextLine();
        System.out.println("Enter Phone number :");
        String ph = sc.nextLine();
        String pass="";
        while (true) {
            System.out.println("Enter Password :");
            pass = sc.nextLine();
            System.out.println("Confirm Password :");
            String cpass = sc.nextLine();

            if (!pass.equals(cpass)) {
                System.out.println("! Enter correct password ");
            } else {

                break;
            }
        }
        Owneraccess use = new Owneraccess();
        User u = new User();
        u.setname(name);
        u.setemail(email);
        u.setpass(pass);
        u.setph(ph);
        use.Signupowner(u);
        System.out.println("Login owner :");
        Login.owner();
    }

}
