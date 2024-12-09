package hust.soict.cybersec.cookhandbook.controller;

import hust.soict.cybersec.cookhandbook.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;

public class RegisterController {

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

//    @FXML
//    private void switchToLogin() {
//        App.switchScene("login.fxml");
//    }
}
