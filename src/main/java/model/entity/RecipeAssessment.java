package model.entity;

public class RecipeAssessment extends Assessment {
    private int recipeId;

    public RecipeAssessment() {
        super();
    }

    public RecipeAssessment(int authorId, int rate, String comment, int recipeId) {
        super(authorId, rate, comment);
        this.recipeId = recipeId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
