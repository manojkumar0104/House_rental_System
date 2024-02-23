package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Owneraccess {

    static Connection connection = null;
    public static void Signupowner(User us) throws SQLException {

        PreparedStatement statement = null;

        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO owner_details(owner_name, email , password, phone_number) VALUES(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, us.getname());
        statement.setString(2, us.getemail());
        statement.setString(3, us.getpass());
        statement.setString(4, us.getph());
        statement.executeUpdate();

    }
    public static void removeowner(User us) throws SQLException{
        
        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql="DELETE FROM owner_details WHERE email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1,us.getemail());
        statement.executeUpdate();

    }
    public static Boolean authowner(Owner u) throws SQLException{

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql="SELECT password FROM user_details WHERE email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1,u.getemail());
        ResultSet res = statement.executeQuery();
        if(res.getString(1).equals(u.getpass())){
            return true;
        }else{
            return false;
        }
    }
    public static Boolean validowner(Owner u) throws SQLException{

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql="SELECT password FROM owner_details WHERE email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, u.getemail());
        ResultSet res = statement.executeQuery();
        if(res.next()){
            String pass=res.getString(1);
            if(u.getpass().equals(pass))
            return true;
        }
        return false;
    }
}
