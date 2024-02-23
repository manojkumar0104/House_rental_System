package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Useraccess {

    static Connection connection = null;
    
    public static void Signupuser(User us) throws SQLException {
        
        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO user_details(user_name, email , password, phone_number) VALUES(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, us.getname());
        statement.setString(2, us.getemail());
        statement.setString(3, us.getpass());
        statement.setString(4, us.getph());
        statement.executeUpdate();
        
    }
    public static void removeuser(User us) throws SQLException{
        
        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql="DELETE FROM user_details WHERE email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1,us.getemail());
        statement.executeUpdate();

    }
    public static Boolean validuser(User u) throws SQLException{

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql="SELECT password FROM user_details WHERE email=?";
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
