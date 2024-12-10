package model.dao;

import model.entity.Recipe;

import java.util.ArrayList;

public interface RecipeDAO {
    public void insert(Recipe recipe);
    public void update(Recipe recipe);
    public void delete(int id);
    public ArrayList<Recipe> findRecipe(String name);
}
