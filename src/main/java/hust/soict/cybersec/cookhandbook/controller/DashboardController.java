package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class DashboardController {


    @FXML
    private VBox newsfeedContainer;

    public void initialize() {

        // load recipe by util that fetch data from database
        // implementing increasing loading
//        List<Recipe> recipes = List.of(
//                new Recipe("Spaghetti Carbonara", "John Doe",
//                        "A classic Italian pasta dish with eggs, cheese, pancetta, and pepper.", "Italian"),
//                new Recipe("Chicken Curry", "Jane Smith",
//                        "A flavorful and spicy chicken curry dish.", "Indian"),
//                new Recipe("Beef Stroganoff", "Michael Brown",
//                        "A rich and creamy Russian beef dish served over noodles.", "Russian"),
//                new Recipe("Sushi Rolls", "Hiro Tanaka",
//                        "Delicious sushi rolls filled with fresh seafood and vegetables.", "Japanese"),
//                new Recipe("Vegetable Stir Fry", "Emily White",
//                        "A healthy stir fry with assorted vegetables.", "Chinese"),
//                new Recipe("French Onion Soup", "Jean Dupont",
//                        "A savory soup with caramelized onions and melted cheese on top.", "French"),
//                new Recipe("Tacos al Pastor", "Carlos Lopez",
//                        "Traditional Mexican tacos with marinated pork and pineapple.", "Mexican"),
//                new Recipe("Butter Chicken", "Aarti Patel",
//                        "A creamy and rich chicken dish from India.", "Indian"),
//                new Recipe("Clam Chowder", "William Harris",
//                        "A hearty soup with clams, potatoes, and cream.", "American"),
//                new Recipe("Ratatouille", "Marie Curie",
//                        "A French vegetable dish made with eggplant, zucchini, and tomatoes.", "French")
//        );
//        System.out.println(getClass());
//
//        for (Recipe recipe : recipes) {
//            try {
//                // Load the post layout
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/postitem.fxml"));
//                AnchorPane postPane = loader.load();
//
//                // Set data into the post
//                ItemPostController controller = loader.getController();
//                controller.setPostData(recipe);
//
//                // Add to VBox
//                newsfeedContainer.getChildren().add(postPane);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
