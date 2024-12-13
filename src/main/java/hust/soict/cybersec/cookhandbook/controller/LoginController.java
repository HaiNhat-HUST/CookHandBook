package hust.soict.cybersec.cookhandbook.controller;


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

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Xử lý logic đăng nhập tại đây
        System.out.println("Username: " + username + ", Password: " + password);

        if(username.equals("admin") && password.equals("admin")){
            //load the dashboard
            System.out.println("right");
            try {
                // Load the FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/dashboard.fxml"));
                Parent root = loader.load();

                // Get the current stage
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace(); // Log the error for debugging
                System.out.println("Error loading the FXML file. Check the file path or syntax.");
            }
        }
    }

    //switch to register
    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/cybersec/cookhandbook/view/register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
