package src.model;

public class Owner{
    
    private String name;
    private String email;
    private String pass;
    private String ph;

    public void setname(String name){
        this.name=name;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setpass(String pass){
        this.pass=pass;
    }
    public void setph(String ph){
        this.ph=ph;
    }

    public String getname(){
        return name;
    }
    public String getemail(){
        return email;
    }
    public String getpass(){
        return pass;
    }
    public String getph(){
        return ph;
    }

}