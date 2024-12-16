package hust.soict.cybersec.cookhandbook;

import hust.soict.cybersec.cookhandbook.Init.InitDatabase;
import hust.soict.cybersec.cookhandbook.controller.*;
import hust.soict.cybersec.cookhandbook.model.entity.Recipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {

    private Stage primaryStage;
    private Scene login, register, dashboard, recipe, restaurant;
    private LoginController loginController;
    private RegisterController registerController;
    private DashboardController dashboardController;
    private RecipeController recipeController;
    private RestaurantController restaurantController;

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;

        // load login
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("view/login.fxml"));
        Parent loginParent = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setMainApp(this);
        login = new Scene(loginParent);

        // load signup
        FXMLLoader resgisterLoader = new FXMLLoader(getClass().getResource("view/register.fxml"));
        Parent registerParent = resgisterLoader.load();
        registerController = resgisterLoader.getController();
        registerController.setMainApp(this);
        register = new Scene(registerParent);

        // load dashboard
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("view/dashboard.fxml"));
        Parent dashboardParent = dashboardLoader.load();
        dashboardController = dashboardLoader.getController();
        dashboardController.setMainApp(this);
        dashboard = new Scene(dashboardParent);

        FXMLLoader recipeLoader = new FXMLLoader(getClass().getResource("view/recipe.fxml"));
        Parent recipeParent = recipeLoader.load();
        recipeController = recipeLoader.getController();
        recipeController.setMainApp(this);
        recipe = new Scene(recipeParent);

//        // load restaurant
//        FXMLLoader restaurantLoader = new FXMLLoader(getClass().getResource("view/restaurant.fxml"));
//        Parent restaurantParent = restaurantLoader.load();
//        restaurantController = restaurantLoader.getController();
//        restaurantController.setMainApp(this);
//        restaurant = new Scene(restaurantParent);

        primaryStage.setScene(login);
        primaryStage.show();
    }

    public void switchToLogin() {
        primaryStage.setScene(login);
    }

    public void switchToRegister() {
        primaryStage.setScene(register);
    }

    public void switchToDashboard() {
        dashboardController.start();
        primaryStage.setScene(dashboard);
    }

    public void switchToRecipe(Recipe chosenRecipe) throws SQLException {
        recipeController.updateInfo(chosenRecipe);
        primaryStage.setScene(recipe);
    }

    public void switchToRestaurant() {
        primaryStage.setScene(restaurant);
    }

    public static void main(String[] args) {
        launch();
        //InitDatabase.initAllDatabase();
    }

}