package model.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.actor.Admin;
import model.actor.RestaurantOwner;
import model.actor.User;
import model.dao.UserDAO;
import utils.AppDb;

public class UserDaoImp implements UserDAO {
    private Connection conn;

    @Override
    public void insert(User user) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }

    }

    @Override
    public void update(User user) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getId());
            stmt.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    @Override
    public User findUser(String username, String password) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                return switch (rs.getString("role")) {
                    case "admin" -> new Admin(id, email, username, password);
                    case "restaurant_owner" -> new RestaurantOwner(id, email, username, password);
                    default -> new User(id, email, username, password);
                };
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }
}
