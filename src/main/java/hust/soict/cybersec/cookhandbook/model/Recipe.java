package hust.soict.cybersec.cookhandbook.model;

public class Recipe {
    public String name;
    public String author;
    public String description;
    public String tag;

    public Recipe(String name, String author, String description, String tag) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.tag = tag;
    }
}
