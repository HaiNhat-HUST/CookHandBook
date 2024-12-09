package hust.soict.cybersec.cookhandbook.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button switchToRegisterButton;

    // action xử lí việc đăng nhập (sử dụng tiện ích từ db để thực hiện truy vấn từ cơ sở dữ liệu để xác thực người dùng
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Xử lý logic đăng nhập tại đây
        System.out.println("Username: " + username + ", Password: " + password);
    }
}

