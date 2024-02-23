package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rentedaccess {

    static Connection connection = null;

    public static void addrented(int h_id, String email) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO rented (house_id, user_email) VALUES(?,?)";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, h_id);
        statement.setString(2, email);
        statement.executeUpdate();

    }

    public static void removerenteduser(String email) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM rented WHERE user_email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.executeUpdate();

    }

    public static void removerentedhouse(int h_id) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM rented WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, h_id);
        statement.executeUpdate();

    }

    public static Boolean renthouse(int h_id, String email) throws SQLException {

        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO rented (house_id,user_email) VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, h_id);
        stmt.setString(2, email);
        int rs = stmt.executeUpdate();
        if (rs > 0)
            return true;
        else
            return false;

    }

    public static Boolean vachouse(int h_id, String email) throws SQLException {

        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM rented WHERE (house_id = ? AND user_email = ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, h_id);
        stmt.setString(2, email);
        int rs = stmt.executeUpdate();
        if (rs > 0)
            return true;
        else
            return false;

    }

    public static boolean checkrented(String email) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "SELECT COUNT(user_email) FROM rented WHERE user_email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            int count = res.getInt(1);
            if (count>0)
                return false;
        }
        return true;
    }
}
