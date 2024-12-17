package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class RecipeController {

    public TextArea commentTextArea;
    private App mainApp;

    @FXML
    private Button backButton;

    @FXML
    private Button favButton;

    @FXML
    private TextField dishNameTf;

    @FXML
    private TextArea recipeTextArea;

    @FXML
    private ImageView recipeImage;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    public void backToDashboard(ActionEvent event) throws IOException {
        this.mainApp.switchToDashboard();
    }

    @FXML
    public void addToFavourite(ActionEvent event) {
        System.out.println("Recipe of " + dishNameTf.getText() + "is added to favourite list !!!");
    }

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void updateInfo(Recipe recipe) {
        dishNameTf.setText(recipe.getName());
        descriptionTextArea.setText(recipe.getDescription());
        recipeTextArea.setText(recipe.getIngredients());
        commentTextArea.setText("• TapTap: Dumangonvccccc\n• Jason: Toichuabhanmonnaongonhonthenay\n• Lam: Toidatang10canvimonnay\n• WalterWhite: saymynameee");
    }
}
