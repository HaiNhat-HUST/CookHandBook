package model.actor;

import model.entity.Restaurant;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantOwner extends User {
    private ArrayList<Restaurant> myRestaurants;

    public RestaurantOwner(int id, String email, String username, String password) {
        super(id, email, username, password);
        this.myRestaurants = new ArrayList<Restaurant>();
    }

    public ArrayList<Restaurant> getMyRestaurants() {
        return myRestaurants;
    }

    public void setMyRestaurants(ArrayList<Restaurant> myRestaurants) {
        this.myRestaurants = myRestaurants;
    }

    /*
    public void uploadRestaurant(String name, String address, int ownerId, String phoneNumber) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("", "", "");
        String[] columns = {"name", "address", "owner_id", "phone_number"};
        Object[] values = {name, address, ownerId, phoneNumber};
        conn.insert("waiting_restaurant", columns, values);
        conn.close();
    }

    public void updateRestaurant(int id, String name, String address, int ownerId, String phoneNumber) throws SQLException {
        Connection conn = DriverManager.getConnection("", "", "");
        PreparedStatement stmt = conn.prepareStatement("UPDATE restaurant SET name = ?, address = ?, owner_id = ?, phone_number = ? WHERE id = ?");
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setInt(3, ownerId);
        stmt.setString(4, phoneNumber);
        stmt.setInt(5, id);
        stmt.executeQuery();
        conn.close();
    }

    public void deleteRestaurant(int id) throws SQLException {
        Connection conn = DriverManager.getConnection("", "", "");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM restaurant WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeQuery();
        conn.close();
    }

    */
}
