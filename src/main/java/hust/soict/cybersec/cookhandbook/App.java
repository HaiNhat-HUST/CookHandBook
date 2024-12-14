package hust.soict.cybersec.cookhandbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //load the login - register form
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Cook Hand Book");
        stage.setScene(scene);
        stage.show();
    }


    // start the application
    public static void main(String[] args) {
        launch();
    }

}