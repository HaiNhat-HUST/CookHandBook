package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button switchToLoginButton;

    // action sử lí việc login ( sử dụng tiện ích từ database để thêm người dùng vào bảng)
    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        // Xử lý logic đăng ký tại đây
        System.out.println("Registering user: " + username);
    }

    //switch to log in
    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
