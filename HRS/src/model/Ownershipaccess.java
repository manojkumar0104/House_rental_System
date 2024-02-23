package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ownershipaccess {
    static Connection connection = null;

    public static void addownership(int h_id, String email) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO ownership (house_id, owner_email) VALUES(?,?)";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, h_id);
        statement.setString(2, email);
        statement.executeUpdate();

    }
    public static void removeownershipowner(String email) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM ownership WHERE owner_email=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.executeUpdate();

    }
    public static void removeownershiphouse(int h_id) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM ownership WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, h_id);
        statement.executeUpdate();

    }
}
