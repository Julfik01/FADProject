package fadp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // This line is updated to locate the FXML file relative to this Main class.
            // This is a more robust way to load resources in many project setups.
            URL fxmlUrl = Main.class.getResource("Planner.fxml");

            if (fxmlUrl == null) {
                // Provide a more detailed error message if the file is still not found.
                System.err.println("Cannot find FXML file 'Planner.fxml'.");
                System.err.println("Please make sure that 'Planner.fxml', 'styles.css', and 'Main.java' are all in the same source directory.");
                System.err.println("Also, ensure your IDE or build process is copying these files to the output directory.");
                return;
            }

            // Load the FXML file for the main view.
            Parent root = FXMLLoader.load(fxmlUrl);

            // Create the scene with a base size.
            Scene scene = new Scene(root, 1280, 800);

            // Set the stage title and scene, then show it.
            primaryStage.setTitle("Meal Planner");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1000);
            primaryStage.setMinHeight(700);
            primaryStage.show();

        } catch (IOException e) {
            // This catch block will now also catch errors if the FXML file is found but has issues.
            System.err.println("An error occurred while loading the FXML file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
