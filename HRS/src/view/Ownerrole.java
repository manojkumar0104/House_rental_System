package src.view;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import src.Main;
import src.model.House;
import src.model.Houseaccess;
import src.model.Ownershipaccess;
import src.model.Rentedaccess;

public class Ownerrole {
    static Scanner sc = new Scanner(System.in);
    static Houseaccess hs=new Houseaccess();
    static House h=new House();
    
    public static void dec(String email) throws SQLException {
        System.out.println("Enter decision :");
        System.out.println("1.Display My House \n2.Add House \n3.Alter details \n4.Vaccate House \n5.Exit");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Id  Location  Rooms  Floor  Color  Grade  Advance_rent  Rent  Availability");
            List<House> hou = Houseaccess.displayavlownhouse(email);
            Iterator<House> itr = hou.iterator();
            while (itr.hasNext()) {
                House tmp = itr.next();
                System.out.print(tmp.getid() + "  ");
                System.out.print(tmp.getlocation() + "  ");
                System.out.print(tmp.getrooms() + "  ");
                System.out.print(tmp.getfloor() + "  ");
                System.out.print(tmp.getcolor() + "  ");
                System.out.print(tmp.getgrade() + "  ");
                System.out.print(tmp.getadv_rent() + "  ");
                System.out.print(tmp.getrent() + "  ");
                System.out.print(tmp.getavl() + "  ");
                System.out.println();
            }
            dec(email);
        }
        else if(choice==2){

            System.out.println("Enter Details of the house :");
            System.out.println("Enter floor :");
            int floor=sc.nextInt();
            System.out.println("Enter no.of rooms :");
            int rooms=sc.nextInt();
            System.out.println("Enter Advance rent :");
            int advrent=sc.nextInt();
            System.out.println("Enter Rent :");
            int rent=sc.nextInt();
            System.out.println("Enter Location :");
            sc.nextLine();
            String loc=sc.nextLine();
            System.out.println("Enter Color :");
            String col=sc.nextLine();
            System.out.println("Enter Grade :");
            String grade=sc.nextLine();

            h.setadv_rent(advrent);
            h.setavl("yes");
            h.setcolor(col);
            h.setfloor(floor);
            h.setrooms(rooms);
            h.setrent(rent);
            h.setgrade(grade);
            h.setlocation(loc);

            hs.addhouse(h);

            int h_id=hs.returnid();
            Ownershipaccess.addownership(h_id, email);
            System.out.println("Added Successfully--");
            dec(email);
        }
        else if(choice==3){
            System.out.println("1.rooms \n2.color \n3.grade \n4.Advance rent \n5.Rent");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.println("Enter house id :");
                int h_id=sc.nextInt();
                System.out.println("Enter updated rooms :");
                int rooms=sc.nextInt();
                Houseaccess.updaterooms(h_id,rooms);
            }
            else if(ch==2){
                System.out.println("Enter house id :");
                int h_id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter updated color :");
                String color=sc.nextLine();
                Houseaccess.updatecolor(h_id,color);
            }
            else if(ch==3){
                System.out.println("Enter house id :");
                int h_id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter updated grade :");
                String grade=sc.nextLine();
                Houseaccess.updategrade(h_id,grade);
            }
            else if(ch==4){
                System.out.println("Enter house id :");
                int h_id=sc.nextInt();
                System.out.println("Enter updated Advance rent :");
                int adv_rent=sc.nextInt();
                Houseaccess.updateadvrent(h_id,adv_rent);
            }
            else if(ch==5){
                System.out.println("Enter house id :");
                int h_id=sc.nextInt();
                System.out.println("Enter updated rent :");
                int rent=sc.nextInt();
                Houseaccess.updaterent(h_id,rent);
            }
            else{
                System.out.println("Enter valid input--");
            }
            dec(email);
        }else if(choice==4){
            System.out.println("Enter House id to vaccate :");
            int h_id = sc.nextInt();
            if(Houseaccess.housedisavl(h_id)){
                Rentedaccess.removerentedhouse(h_id);
            }else{
                System.out.println("Enter Valid details--");
                dec(email);
            }
            System.out.println("Vaccated Successfully--");
            dec(email);
        }else if(choice==5){
            Main.main(null);
        }else{
            System.out.println("Enter valid input--");
            dec(email);
        }
    }

}