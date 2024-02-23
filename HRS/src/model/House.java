package src.model;

public class House {
    
    private int id;
    private String location;
    private int rooms;
    private int floor;
    private String color;
    private String grade;
    private int adv_rent;
    private int rent;
    private String avl;
    
    public void setlocation(String location){
        this.location=location;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public void setgrade(String grade){
        this.grade=grade;
    }
    public void setavl(String avl){
        this.avl=avl;
    }
    public void setid(int id){
        this.id=id;
    }
    public void setfloor(int floor){
        this.floor=floor;
    }
    public void setrooms(int rooms){
        this.rooms=rooms;
    }
    public void setadv_rent(int adv_rent){
        this.adv_rent=adv_rent;
    }
    public void setrent(int rent){
        this.rent=rent;
    }


    public String getlocation(){
        return location;
    }
    public String getcolor(){
        return color;
    }
    public String getgrade(){
        return grade;
    }
    public String getavl(){
        return avl;
    }
    public int getid(){
        return id;
    }
    public int getfloor(){
        return floor;
    }
    public int getrooms(){
        return rooms;
    }
    public int getadv_rent(){
        return adv_rent;
    }
    public int getrent(){
        return rent;
    }

}
