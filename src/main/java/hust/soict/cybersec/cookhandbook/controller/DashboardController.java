package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import hust.soict.cybersec.cookhandbook.model.dao.RecipeDao;
import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController{

    private App mainApp;

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private VBox newsfeedContainer;

    public void start() {

        List<Recipe> recipes = List.of(
                new Recipe("Spaghetti Carbonara", "John Doe",
                        "A classic Italian pasta dish with eggs, cheese, pancetta, and pepper.", "Italian"),
                new Recipe("Chicken Curry", "Jane Smith",
                        "A flavorful and spicy chicken curry dish.", "Indian"),
                new Recipe("Beef Stroganoff", "Michael Brown",
                        "A rich and creamy Russian beef dish served over noodles.", "Russian"),
                new Recipe("Sushi Rolls", "Hiro Tanaka",
                        "Delicious sushi rolls filled with fresh seafood and vegetables.", "Japanese"),
                new Recipe("Vegetable Stir Fry", "Emily White",
                        "A healthy stir fry with assorted vegetables.", "Chinese"),
                new Recipe("French Onion Soup", "Jean Dupont",
                        "A savory soup with caramelized onions and melted cheese on top.", "French"),
                new Recipe("Tacos al Pastor", "Carlos Lopez",
                        "Traditional Mexican tacos with marinated pork and pineapple.", "Mexican"),
                new Recipe("Butter Chicken", "Aarti Patel",
                        "A creamy and rich chicken dish from India.", "Indian"),
                new Recipe("Clam Chowder", "William Harris",
                        "A hearty soup with clams, potatoes, and cream.", "American"),
                new Recipe("Ratatouille", "Marie Curie",
                        "A French vegetable dish made with eggplant, zucchini, and tomatoes.", "French")
        );

        for (Recipe recipe : recipes) {
            try {
                // Load the post layout
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/postitem.fxml"));
                AnchorPane postPane = loader.load();

                // Set data into the post
                ItemPostController controller = loader.getController();
                controller.setRecipe(recipe);
                controller.setMainApp(this.mainApp);

                // Add to VBox
                newsfeedContainer.getChildren().add(postPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout(javafx.event.ActionEvent actionEvent) {
        this.mainApp.switchToLogin();
        if (this.mainApp == null){
            System.out.println("NGU");
        }
    }
}
