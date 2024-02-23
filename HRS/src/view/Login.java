package src.view;

import java.util.Scanner;

import src.controller.LoginAuth;
import src.model.Adminaccess;
import src.model.Owner;
import src.model.Owneraccess;
import src.model.User;
import src.model.Useraccess;

public class Login {
    static Scanner sc = new Scanner(System.in);

    static void user() {

        System.out.println("Enter email : ");
        String email = sc.nextLine();
        System.out.println("Enter password : ");
        String pass = sc.nextLine();
        try {
            Useraccess use = new Useraccess();
            User u = new User();
            u.setemail(email);
            u.setpass(pass);

            if(Useraccess.validuser(u)){
                System.out.println("User Login successfull");
                Userrole.dec(email);
            }else{
                System.out.println("Enter valid Details");
                Login.user();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void owner() {

        System.out.println("Enter email : ");
        String email = sc.nextLine();
        System.out.println("Enter password : ");
        String pass = sc.nextLine();
        try {
            // Owneraccess use = new Owneraccess();
            Owner u = new Owner();
            u.setemail(email);
            u.setpass(pass);

            if(Owneraccess.validowner(u)){
                System.out.println("Owner Login successfull");
                Ownerrole.dec(email);
            }else{
                System.out.println("Enter valid Details");
                Login.owner();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void admin() {

        System.out.println("Enter email : ");
        String email = sc.nextLine();
        System.out.println("Enter password : ");
        String pass = sc.nextLine();
        try {
            Adminaccess use = new Adminaccess();
            User u = new User();
            u.setemail(email);
            u.setpass(pass);

            if(use.authadmin(u)){
                System.out.println("Admin Login successfull");
            }else{
                System.out.println("Enter valid Details");
                Login.admin();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
