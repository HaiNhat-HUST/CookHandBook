package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemPostController {


    @FXML
    Label author;

    @FXML
    Label name;

    @FXML
    Label shortdes;

    @FXML
    Label tag;



    public void setPostData(Recipe recipe) {
//        author.setText(recipe.author);
//        name.setText(recipe.name);
//        tag.setText(recipe.tag);
//        shortdes.setText(recipe.description);
    }
}
