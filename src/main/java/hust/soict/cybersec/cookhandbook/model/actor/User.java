package hust.soict.cybersec.cookhandbook.model.actor;

import hust.soict.cybersec.cookhandbook.model.entity.*;
import hust.soict.cybersec.cookhandbook.model.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private List<Recipe> favRecipes;
    private List<Restaurant> favRestaurants;
    private List<Recipe> myRecipes;

    public User() {}

    public User(int id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.favRecipes = new ArrayList<Recipe>();
        this.favRestaurants = new ArrayList<Restaurant>();
        this.myRecipes = new ArrayList<Recipe>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavRecipes(List<Recipe> favRecipes) {
        this.favRecipes = favRecipes;
    }

    public void setFavRestaurants(List<Restaurant> favRestaurants) {
        this.favRestaurants = favRestaurants;
    }

    public void setMyRecipes(List<Recipe> myRecipes) {
        this.myRecipes = myRecipes;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Recipe> getFavRecipes() {
        return favRecipes;
    }

    public List<Restaurant> getFavRestaurants() {
        return favRestaurants;
    }

    public List<Recipe> getMyRecipes() throws SQLException {
        return myRecipes;
    }

    /*
    public void fetchData() throws SQLException {
        Connection conn = DriverManager.getConnection("h2", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recipes WHERE author_id = ?");
        stmt.setInt(1, this.id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            myRecipes.add(new Recipe(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)));
        }

        stmt = conn.prepareStatement("SELECT * FROM recipes WHERE recipe_id IN (SELECT recipe_id FROM favorite_recipe WHERE user_id = ?)");
        stmt.setInt(1, this.id);
        rs = stmt.executeQuery();
        while (rs.next()) {
            favRecipes.add(new Recipe(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
            ));
        }

        stmt = conn.prepareStatement("SELECT * FROM restaurants WHERE restaurant_id IN (SELECT restaurant_id FROM favorite_restaurant WHERE user_id = ?)");
        stmt.setInt(1, this.id);
        rs = stmt.executeQuery();
        while (rs.next()) {
            favRestaurants.add(new Restaurant(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5)
            ));
        }

        conn.close();
    }

    public void addFavRestaurant(Restaurant restaurant) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("h2", "sa", "");
        String[] columns = {"user_id", "restaurant_id"};
        Object[] values = {this.id, restaurant.getId()};
        conn.insert("restaurants", columns, values);
        conn.close();
    }

    public void delFavRestaurant(Restaurant restaurant) throws SQLException {
        Connection conn = DriverManager.getConnection("h2", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM favorite_restaurant WHERE user_id = ? and restaurant_id = ?");
        stmt.setInt(1, this.id);
        stmt.setInt(2, restaurant.getId());
        stmt.executeQuery();
        conn.close();
    }

    public void addFavRecipe(Recipe recipe) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("h2", "sa", "");
        String[] columns = {"user_id", "recipe_id"};
        Object[] values = {this.id, recipe.getId()};
        conn.insert("recipes", columns, values);
        conn.close();
    }

    public void delFavRecipe(Recipe recipe) throws SQLException {
        Connection conn = DriverManager.getConnection("h2", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM favorite_restaurant WHERE user_id = ? and recipe_id = ?");
        stmt.setInt(1, this.id);
        stmt.setInt(2, recipe.getId());
        stmt.executeQuery();
        conn.close();
    }

    public void rateRecipe(Recipe recipe, int rating, String comment) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("h2", "sa", "");
        String[] columns = {"recipe_id", "user_id", "rating", "comment"};
        Object[] values = {recipe.getId(), this.id, rating, comment};
        conn.insert("recipe_review", columns, values);
        conn.close();
    }

    public void rateRestaurant(Restaurant restaurant, int rating, String comment) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("h2", "sa", "");
        String[] columns = {"restaurant_id", "user_id", "rating", "comment"};
        Object[] values = {restaurant.getId(), this.id, rating, comment};
        conn.insert("restaurant_review", columns, values);
        conn.close();
    }

    public void updateInfo(String email, String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection("", "", "");
        PreparedStatement stmt = conn.prepareStatement("update users set email = ?, username = ?, password = ? where user_id = ?");
        stmt.setString(1, email);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.setInt(4, this.id);
        stmt.executeQuery();
        conn.close();
    }

    public void uploadRecipe(String name, int authorId, String cuisineType, int time, String ingredients, String tutorial) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("h2", "sa", "");
        String[] columns = {"name", "author_id", "cuisine_type", "time", "ingredients", "tutorial"};
        Object[] values = {name, this.id, cuisineType, time, ingredients, tutorial};
        conn.insert("waiting_recipes", columns, values);
        conn.close();
    }

    public void updateRecipe(int id, String name, int authorId, String cuisineType, int time, String ingredients, String tutorial) throws SQLException {
        Connection conn = DriverManager.getConnection("h2", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("UPDATE recipe SET name = ?, author_id = ?, cuisine_type = ?, time = ?, ingredients = ?, tutorial = ? WHERE id = ?");
        stmt.setString(1, name);
        stmt.setInt(2, authorId);
        stmt.setString(3, cuisineType);
        stmt.setInt(4, time);
        stmt.setString(5, ingredients);
        stmt.setString(6, tutorial);
        stmt.setInt(7, id);
        stmt.executeQuery();
        conn.close();
    }

    public void deleteRecipe(Recipe recipe) throws SQLException {
        Connection conn = DriverManager.getConnection("h2", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM recipe WHERE id = ?");
        stmt.setInt(1, recipe.getId());
        stmt.executeQuery();
        conn.close();
    }

     */
}