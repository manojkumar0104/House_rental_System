package src.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Authview {
    static Scanner sc = new Scanner(System.in);

    public static void dec() throws SQLException {

        while (true) {
            System.out.println("Login Or Sign-Up");
            System.out.println("1.Login");
            System.out.println("2.Sign-Up");
            int choice = sc.nextInt();

            if (choice == 1) {
                login();
                break;
            } else if (choice == 2) {
                signup();
                break;
            } else {
                System.out.println("Enter valid input");
                dec();
            }
        }
    }

    public static void login() {

        System.out.println("Welcome to Login Page");
        while (true) {
            System.out.println("User or Owner or Admin ?");
            System.out.println("1.User \n2.Owner \n3.Admin");
            int logchoice = sc.nextInt();

            if (logchoice == 1) {
                System.out.println("Welcome to user Login");
                Login.user();
                break;
            } else if (logchoice == 2) {
                System.out.println("Welcome to Owner Login");
                Login.owner();
                break;
            } else if (logchoice == 3) {
                System.out.println("Welcome to Admin Login");
                Login.admin();
                break;
            } else {
                System.out.println("Enter valid input");
                login();
            }
        }
    }

    public static void signup() throws SQLException {
        System.out.println("Welcome to Signup page");
        while(true){
            System.out.println("User or Owner Login");
            System.out.println("1.User \n2.Owner");
            int choice=sc.nextInt();
            if(choice==1){
                Signup.user();
                break;
            }else if(choice==2){
                Signup.owner();
                break;
            }else{
                System.out.println("Enter valid input");
            }
        }
    }
}
