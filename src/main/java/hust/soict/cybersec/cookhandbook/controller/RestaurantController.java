package hust.soict.cybersec.cookhandbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private Button addToFavourite;

    @FXML
    private Label restaurantName;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private MenuButton optionButton;

    @FXML
    private TextArea textArea;

    @FXML
    private ImageView imageView;

    @FXML
    public void backToDashboard(ActionEvent event) {
        System.out.println("mmb");
    }

    @FXML
    public void changeOption(ActionEvent event) {
        System.out.println("cmmm");
    }

    private void loadAll(){
        System.out.println("hihihi");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadAll();
    }
}
