package hust.soict.cybersec.cookhandbook.model.dao;

import hust.soict.cybersec.cookhandbook.model.entity.*;
import hust.soict.cybersec.cookhandbook.model.utils.*;

import javax.crypto.spec.RC2ParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDao {

    private Connection conn;

    public void insert(Recipe recipe) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("INSERT INTO recipes(name, author_id, cuisine_type, time, ingredients, tutorial) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, recipe.getName());
            stmt.setInt(2, recipe.getAuthorId());
            stmt.setString(3, recipe.getCuisineType());
            stmt.setInt(4, recipe.getTime());
            stmt.setString(5, recipe.getIngredients());
            stmt.setString(6, recipe.getTutorial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public void update(Recipe recipe) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("UPDATE recipes SET name = ?, author_id = ?, cuisine_type = ?, time = ?, ingredients = ?, tutorial = ? WHERE id = ?");
            stmt.setString(1, recipe.getName());
            stmt.setInt(2, recipe.getAuthorId());
            stmt.setString(3, recipe.getCuisineType());
            stmt.setInt(4, recipe.getTime());
            stmt.setString(5, recipe.getIngredients());
            stmt.setString(6, recipe.getTutorial());
            stmt.setInt(7, recipe.getId());
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
            stmt = conn.prepareStatement("DELETE FROM recipes WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Recipe> findRecipe(String name) {
        PreparedStatement stmt;
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM recipes WHERE name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                recipes.add(new Recipe(
                        rs.getString("name"),
                        rs.getString("authorName"),
                        rs.getString("description"),
                        rs.getString("cuisine_type"),
                        rs.getString("ingredients")
                ));
            }
            return recipes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Recipe> getAllAccepted() {
        PreparedStatement stmt;
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM recipes WHERE status='APPROVED'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                recipes.add(new Recipe(
                        rs.getString("name"),
                        rs.getString("authorName"),
                        rs.getString("description"),
                        rs.getString("cuisine_type"),
                        rs.getString("ingredients")
                ));
            }
            return recipes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<Recipe> getAllPending() {
        PreparedStatement stmt;
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM recipes WHERE status='PENDING'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                recipes.add(new Recipe(
                        rs.getString("name"),
                        rs.getString("authorName"),
                        rs.getString("description"),
                        rs.getString("cuisine_type"),
                        rs.getString("ingredients")
                ));
            }
            return recipes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }
}
