package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Houseaccess {
    static Connection connection;

    // public static void addhouse(int h_id, String location, int rooms, int floor, String color, String grade,int advrent, int rent, String avl) throws SQLException {
    public static void addhouse(House hs) throws SQLException {

        PreparedStatement statement = null;

        connection = DBconnectivity.getConnection();
        String sql = "INSERT INTO house_details(location,rooms,floor,color,grade,advance_rent,rent,availability) VALUES(?,?,?,?,?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, hs.getlocation());
        statement.setInt(2, hs.getrooms());
        statement.setInt(3, hs.getfloor());
        statement.setString(4, hs.getcolor());
        statement.setString(5, hs.getgrade());
        statement.setInt(6, hs.getadv_rent());
        statement.setInt(7, hs.getrent());
        statement.setString(8, hs.getavl());
        statement.executeUpdate();
    }
    public static int returnid() throws SQLException{

        PreparedStatement statement = null;

        connection = DBconnectivity.getConnection();
        String sql = "SELECT MAX(house_id) FROM house_details";
        statement = connection.prepareStatement(sql);
        statement = connection.prepareStatement(sql);
        ResultSet res = statement.executeQuery();
        int count=0;
        if (res.next()) {
            count = res.getInt(1);
        }
        return count;
    }

    public static void removehouse(int h_id) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "DELETE FROM house_details WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, h_id);
        statement.executeUpdate();

    }

    public static void updatecolor(int h_id, String color) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET color=? WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, color);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static void updategrade(int h_id, String grade) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET grade=? WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, grade);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static void updaterooms(int h_id, int rooms) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET rooms=? WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, rooms);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static void updateadvrent(int h_id, int advrent) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET advance_rent=? WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, advrent);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static void updaterent(int h_id, int rent) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET rent=? WHERE house_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, rent);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static void updateavl(int h_id, String avl) throws SQLException {

        PreparedStatement statement = null;
        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET availability =? WHERE house_id =?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, avl);
        statement.setInt(2, h_id);
        statement.executeUpdate();

    }

    public static List<House> displayavlhouse() throws SQLException {

        connection = DBconnectivity.getConnection();
        String sql = "SELECT * FROM house_details WHERE availability = 'yes' ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<House> li = new ArrayList<>();
        while (rs.next()) {
            House obj = new House();
            obj.setid(rs.getInt("house_id"));
            obj.setlocation(rs.getString("location"));
            obj.setrooms(rs.getInt("rooms"));
            obj.setfloor(rs.getInt("floor"));
            obj.setcolor(rs.getString("color"));
            obj.setgrade(rs.getString("grade"));
            obj.setadv_rent(rs.getInt("advance_rent"));
            obj.setrent(rs.getInt("rent"));

            li.add(obj);
        }
        return li;
    }

    public static List<House> displayavlownhouse(String email) {
        List<House> li = new ArrayList<>();
try{
        connection = DBconnectivity.getConnection();
        String sql = "SELECT * FROM house_details WHERE house_id = (SELECT house_id FROM ownership WHERE owner_email=?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            House obj = new House();
            obj.setid(rs.getInt("house_id"));
            obj.setlocation(rs.getString("location"));
            obj.setrooms(rs.getInt("rooms"));
            obj.setfloor(rs.getInt("floor"));
            obj.setcolor(rs.getString("color"));
            obj.setgrade(rs.getString("grade"));
            obj.setadv_rent(rs.getInt("advance_rent"));
            obj.setrent(rs.getInt("rent"));
            obj.setrent(rs.getInt("availability"));

            li.add(obj);
        }

        return li;
    }
    catch (SQLException e){
        System.out.println(e);
        return li;
    }
    }

    public static boolean houseavl(int h_id) throws SQLException {

        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET availability='no' WHERE house_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, h_id);
        int rs = stmt.executeUpdate();
        if (rs > 0)
            return true;
        else
            return false;

    }

    public static Boolean housedisavl(int h_id) throws SQLException {

        connection = DBconnectivity.getConnection();
        String sql = "UPDATE house_details SET availability='yes' WHERE house_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, h_id);
        int rs = stmt.executeUpdate();
        if (rs > 0)
            return true;
        else
            return false;
    }
}
