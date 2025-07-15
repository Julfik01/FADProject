package planner2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file for the new detail view.
            URL fxmlUrl = Main.class.getResource("Planner2.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find FXML file 'Planner.fxml'.");
                System.err.println("Please make sure all .java, .fxml, and .css files are in the same source directory under the 'fadp1' package folder.");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);

            // Create the scene.
            Scene scene = new Scene(root, 1280, 800);

            // Set the stage title and scene, then show it.
            primaryStage.setTitle("Meal Planner");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1200);
            primaryStage.setMinHeight(800);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("An error occurred while loading the application.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
