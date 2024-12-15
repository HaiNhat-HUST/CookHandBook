package hust.soict.cybersec.cookhandbook.model.dao;

import hust.soict.cybersec.cookhandbook.model.entity.*;
import hust.soict.cybersec.cookhandbook.model.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssessmentDao {
    Connection conn;

    public void save(Assessment assessment) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            if (assessment instanceof RecipeAssessment) {
                stmt = conn.prepareStatement("INSERT INTO recipe_review VALUES (?, ?, ?, ?)");
                stmt.setInt(1, ((RecipeAssessment) assessment).getRecipeId());
                stmt.setInt(2, ((RecipeAssessment) assessment).getAuthorId());
                stmt.setInt(3, ((RecipeAssessment) assessment).getRate());
                stmt.setString(4, ((RecipeAssessment) assessment).getComment());
                stmt.executeUpdate();
            } else if (assessment instanceof RestaurantAssessment) {
                stmt = conn.prepareStatement("INSERT INTO restaurant_review VALUES (?, ?, ?, ?)");
                stmt.setInt(1, ((RestaurantAssessment) assessment).getRestaurantId());
                stmt.setInt(2, ((RestaurantAssessment) assessment).getAuthorId());
                stmt.setInt(3, ((RestaurantAssessment) assessment).getRate());
                stmt.setString(4, ((RestaurantAssessment) assessment).getComment());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public void delete(Assessment assessment) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            if (assessment instanceof RecipeAssessment) {
                stmt = conn.prepareStatement("DELETE FROM recipe_review WHERE user_id = ? AND recipe_id = ?");
                stmt.setInt(1, ((RecipeAssessment) assessment).getAuthorId());
                stmt.setInt(2, ((RecipeAssessment) assessment).getRecipeId());
                stmt.executeUpdate();
            } else if (assessment instanceof RestaurantAssessment) {
                stmt = conn.prepareStatement("DELETE FROM restaurant_review WHERE user_id = ? AND restaurant_id = ?");
                stmt.setInt(1, ((RestaurantAssessment) assessment).getAuthorId());
                stmt.setInt(2, ((RestaurantAssessment) assessment).getRestaurantId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<RecipeAssessment> getRecipeAssessments(int recipeId) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM recipe_review WHERE recipe_id = ?");
            stmt.setInt(1, recipeId);
            ResultSet rs = stmt.executeQuery();

            ArrayList<RecipeAssessment> assessments = new ArrayList<>();
            while (rs.next()) {
                assessments.add(new RecipeAssessment(
                        rs.getInt("user_id"),
                        rs.getInt("rate"),
                        rs.getString("comment"),
                        rs.getInt("recipe_id")
                ));
            }
            return assessments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }

    public ArrayList<RestaurantAssessment> getRestaurantAssessments(int restaurantId) {
        PreparedStatement stmt;

        try {
            conn = AppDb.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM restaurant_review WHERE restaurant_id = ?");
            stmt.setInt(1, restaurantId);
            ResultSet rs = stmt.executeQuery();

            ArrayList<RestaurantAssessment> assessments = new ArrayList<>();
            while (rs.next()) {
                assessments.add(new RestaurantAssessment(
                        rs.getInt("user_id"),
                        rs.getInt("rate"),
                        rs.getString("comment"),
                        rs.getInt("restaurant_id")
                ));
            }
            return assessments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AppDb.closeConnection();
        }
    }
}
