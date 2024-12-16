package hust.soict.cybersec.cookhandbook.controller;


import hust.soict.cybersec.cookhandbook.App;
import hust.soict.cybersec.cookhandbook.model.actor.User;
import hust.soict.cybersec.cookhandbook.model.dao.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private App mainApp;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button switchToRegisterButton;

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    // action xử lí việc đăng nhập (sử dụng tiện ích từ db để thực hiện truy vấn từ cơ sở dữ liệu để xác thực người dùng
    @FXML
    private void handleLogin(ActionEvent event) {
        this.mainApp.switchToDashboard();
        System.out.println("I called this function");
//        UserDao userDao = new UserDao();
//        String username = usernameField.getText();
//        String password = passwordField.getText();
//        User resultUser = userDao.findUser(username, password);
//
//        if(resultUser != null){
//            try {
//                // Load the FXML file
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/dashboard.fxml"));
//                Parent root = loader.load();
//
//                // Get the current stage
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//                // Set the new scene
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//            } catch (IOException e) {
//                e.printStackTrace(); // Log the error for debugging
//                System.out.println("Error loading the FXML file. Check the file path or syntax.");
//            }
//        }
    }

    //switch to register
    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        this.mainApp.switchToRegister();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

