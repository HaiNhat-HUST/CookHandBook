package hust.soict.cybersec.cookhandbook.controller;

import com.sun.tools.jconsole.JConsoleContext;
import hust.soict.cybersec.cookhandbook.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private Button backButton;

    @FXML
    private Button favButton;

    @FXML
    private TextField dishNameTf;

    @FXML
    private TextArea commenTextArea;

    @FXML
    private TextArea recipeTextArea;

    @FXML
    private ImageView recipeImage;

    @FXML
    public void backToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/detailRecipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML 
    public void addToFavourite(ActionEvent event) {
        System.out.println("Recipe of " + dishNameTf.getText() + "is added to favourite list !!!");
    }

    @FXML
    private void loadAll() {
        System.out.println("Load dish name, description, recipe, comments");
        Image image = new Image(String.valueOf(App.class.getResource("image/macaron.jpg")));
        System.out.println(String.valueOf(App.class.getResource("image/macaron.jpg")));
        recipeImage.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadAll();
    }
}
