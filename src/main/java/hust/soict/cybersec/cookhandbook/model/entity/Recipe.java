package hust.soict.cybersec.cookhandbook.model.entity;

public class Recipe {
    private int id;
    private String name;
    private int authorId;
    private String cuisineType;
    private int time;
    private String ingredients;
    private String tutorial;

    public Recipe(int id, String name, int authorId, String cuisineType, int time, String ingredients, String tutorial) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.cuisineType = cuisineType;
        this.time = time;
        this.ingredients = ingredients;
        this.tutorial = tutorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
