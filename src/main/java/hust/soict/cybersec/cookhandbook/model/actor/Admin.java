package hust.soict.cybersec.cookhandbook.model.actor;

import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import hust.soict.cybersec.cookhandbook.model.entity.Restaurant;
import hust.soict.cybersec.cookhandbook.model.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Recipe> recipesQueue;
    private ArrayList<Restaurant> restaurantQueue;

    public Admin(int id, String email, String name, String password) {
        super(id, email, name, password);
    }

    public ArrayList<Recipe> getRecipesQueue() {
        return recipesQueue;
    }

    public ArrayList<Restaurant> getRestaurantQueue() {
        return restaurantQueue;
    }

    public void setRecipesQueue(ArrayList<Recipe> recipesQueue) {
        this.recipesQueue = recipesQueue;
    }

    public void setRestaurantQueue(ArrayList<Restaurant> restaurantQueue) {
        this.restaurantQueue = restaurantQueue;
    }

    /*
    public void fetchData() throws SQLException {
        Connection conn = DriverManager.getConnection("", "", "");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM waiting_recipes");
        ResultSet rs = stmt.executeQuery();

        recipesQueue = new ArrayList<>();
        while (rs.next()) {
            recipesQueue.add(new Recipe(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
            ));
        }

        stmt = conn.prepareStatement("SELECT * FROM waiting_restaurants");
        rs = stmt.executeQuery();
        restaurantQueue = new ArrayList<>();
        while (rs.next()) {
            restaurantQueue.add(new Restaurant(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5)
            ));
        }

        conn.close();
    }

    public void acceptRecipe(Recipe recipe) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("", "", "");
        String[] columns = {"name", "author_id", "cuisine_type", "time", "ingredients", "tutorial"};
        Object[] values = {recipe.getName(), recipe.getAuthorId(), recipe.getCuisineType(), recipe.getTime(), recipe.getIngredients(), recipe.getTutorial()};
        conn.insert("recipes", columns, values);
        conn.close();
    }

    public void acceptRestaurant(Restaurant restaurant) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("", "", "");
        String[] columns = {"name", "address", "owner_id", "phone_number"};
        Object[] values = {restaurant.getName(), restaurant.getAddress(), restaurant.getOwner_id(), restaurant.getPhoneNumber()};
        conn.insert("restaurants", columns, values);
        conn.close();
    }

    public void rejectRecipe(Recipe recipe) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("", "", "");
        conn.delete("waiting_recipes", recipe.getId());
        conn.close();
    }

    public void rejectRestaurant(Restaurant restaurant) throws SQLException {
        DatabaseUtils conn = new DatabaseUtils("", "", "");
        conn.delete("waiting_restaurants", restaurant.getId());
        conn.close();
    }

     */
}