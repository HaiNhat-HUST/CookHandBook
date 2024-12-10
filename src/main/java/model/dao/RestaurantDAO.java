package model.dao;

import model.entity.Restaurant;

import java.util.ArrayList;

public interface RestaurantDAO {
    public void insert(Restaurant restaurant);
    public void update(Restaurant restaurant);
    public void delete(int id);
    public ArrayList<Restaurant> findRestaurant(String name);
}
