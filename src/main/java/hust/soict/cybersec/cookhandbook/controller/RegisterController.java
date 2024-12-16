package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
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
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private App mainApp;

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

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }
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
        this.mainApp.switchToLogin();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
