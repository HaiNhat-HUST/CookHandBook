package hust.soict.cybersec.cookhandbook.model.dao;

import hust.soict.cybersec.cookhandbook.model.entity.*;
import hust.soict.cybersec.cookhandbook.model.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantDao {
    private Connection conn;

    public void insert(Restaurant restaurant) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("INSERT INTO restaurants (name, address, owner_id, phone_number) VALUES (?,?,?,?)");
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setInt(3, restaurant.getOwnerId());
            stmt.setString(4, restaurant.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public void update(Restaurant restaurant) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("UPDATE restaurants SET name = ?, address = ?, owner_id = ?, phone_number = ? WHERE id = ?");
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setInt(3, restaurant.getOwnerId());
            stmt.setString(4, restaurant.getPhoneNumber());
            stmt.setInt(5, restaurant.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public void delete(int id) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("DELETE FROM restaurants WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Restaurant> findRestaurant(String name) {
        PreparedStatement stmt;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM restaurants WHERE name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                restaurants.add(new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("owner_id"),
                        rs.getString("phone_number")
                ));
            }
            return restaurants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Restaurant> getAllAccepted() {
        PreparedStatement stmt;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM restaurants WHERE status='ACCEPTED'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                restaurants.add(new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("owner_id"),
                        rs.getString("phone_number")
                ));
            }
            return restaurants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Restaurant> getAllPending() {
        PreparedStatement stmt;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM restaurants WHERE status='PENDING'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                restaurants.add(new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("owner_id"),
                        rs.getString("phone_number")
                ));
            }
            return restaurants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }
}