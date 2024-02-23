package src.view;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import src.Main;
import src.model.House;
import src.model.Houseaccess;
import src.model.Rentedaccess;

public class Userrole {
    static Scanner sc = new Scanner(System.in);

    public static void dec(String email) throws SQLException{
        System.out.println("Enter decision :");
        System.out.println("1.Display House \n2.Rent House \n3.Vaccate House \n4.Exit");
        int choice = sc.nextInt();
        if(choice == 1){
            List<House> hou = Houseaccess.displayavlhouse();
            Iterator<House> itr = hou.iterator();
            System.out.println("Id  Location  Rooms  Floor  Color  Grade  Advance_rent  Rent");
            while(itr.hasNext()){
                House tmp = itr.next();
                System.out.print(tmp.getid()+"  ");
                System.out.print(tmp.getlocation()+"  ");
                System.out.print(tmp.getrooms()+"  ");
                System.out.print(tmp.getfloor()+"  ");
                System.out.print(tmp.getcolor()+"  ");
                System.out.print(tmp.getgrade()+"  ");
                System.out.print(tmp.getadv_rent()+"  ");
                System.out.print(tmp.getrent()+"  ");
                System.out.println();
            }
            dec(email);
        }
        
        else if(choice == 2){
            System.out.println("Enter House id to rent :");
            int h_id=sc.nextInt();
            if(!Rentedaccess.checkrented(email)){
                System.out.println("A user can rent only one house at a time");
            }else{
            if(Houseaccess.houseavl(h_id)){
            Rentedaccess.renthouse(h_id, email);
            }else{
                System.out.println("Enter valid Details--");
                dec(email);
            }
            System.out.println("Rented Successfully--");
            }
            dec(email);
        }
        
        else if(choice == 3){
            System.out.println("Enter House id to vaccate :");
            int h_id = sc.nextInt();
            if(Rentedaccess.vachouse(h_id,email)){
            if(Houseaccess.housedisavl(h_id)){
                System.out.println("Vaccated Successfully--");
            }
            }else{
                System.out.println("Enter Valid details--");
                dec(email);
            }
            dec(email);
        }
        
        else if(choice == 4){
            Main.main(null);
        }
        
        else{
            System.out.println("Enter valid choice ");
            dec(email);
        }
    }
}
