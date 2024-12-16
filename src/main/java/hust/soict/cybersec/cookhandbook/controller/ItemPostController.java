package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import hust.soict.cybersec.cookhandbook.model.dao.UserDao;
import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemPostController implements Initializable {

    private App mainApp;
    private Recipe currentRecipe;

    @FXML
    Label author;

    @FXML
    Label name;

    @FXML
    Label shortdes;

    @FXML
    Label tag;

    @FXML
    ImageView recipeImage;

    @FXML
    Button detailsButton;

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void setRecipe(Recipe recipe) {
        this.currentRecipe = recipe;
        this.author.setText(recipe.getAuthorName());
        this.name.setText(recipe.getName());
        this.shortdes.setText(recipe.getDescription());
        this.tag.setText(recipe.getCuisineType());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void viewDetail(javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        this.mainApp.switchToRecipe(this.currentRecipe);
    }

}
