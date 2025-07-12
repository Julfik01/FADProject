package fadp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Main application class to launch the JavaFX dashboard.
 */
public class MainApp extends Application {

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file for the main view.
            FXMLLoader loader = new FXMLLoader();
            URL fxmlUrl = getClass().getResource("Dashboard.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find FXML file. Make sure Dashboard.fxml is in the correct path.");
                return;
            }
            loader.setLocation(fxmlUrl);
            Parent root = loader.load();

            // Create the scene with the loaded FXML content.
            Scene scene = new Scene(root, 1280, 800);

            // Load the CSS file and apply it to the scene.
            URL cssUrl = getClass().getResource("styles.css");
            if (cssUrl == null) {
                System.err.println("Cannot find CSS file. Make sure styles.css is in the correct path.");
            } else {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }


            // Configure the primary stage.
            primaryStage.setTitle("Business Dashboard");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1024);
            primaryStage.setMinHeight(768);

            // Show the stage.
            primaryStage.show();

        } catch (IOException e) {
            // Handle exceptions that may occur during FXML loading.
            e.printStackTrace();
        }
    }

    /**
     * The main method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
