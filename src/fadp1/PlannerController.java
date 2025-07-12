package fadp1; // <-- This line is added to match your project structure.

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class PlannerController {

    // These fields will be automatically linked to the ImageViews in the FXML file.
    @FXML private ImageView menuIconView;
    @FXML private ImageView plannerIconView;
    @FXML private ImageView groceriesIconView;
    @FXML private ImageView discoverIconView;
    @FXML private ImageView editIconView;
    @FXML private ImageView mainImageView;
    @FXML private ImageView generateIconView;

    /**
     * This method is automatically called by the FXMLLoader after the FXML file has been loaded.
     * We use it to programmatically set the images, which solves the path issues.
     */
    @FXML
    public void initialize() {
        // Load all images using a helper method.
        // This approach is robust and works both in IDEs and when packaged into a JAR.
        loadImage(menuIconView, "/icons/menu.png");
        loadImage(plannerIconView, "/icons/planner.png");
        loadImage(groceriesIconView, "/icons/groceries.png");
        loadImage(discoverIconView, "/icons/discover.png");
        loadImage(editIconView, "/icons/edit.png");
        loadImage(mainImageView, "/images/placeholder-art.png");
        loadImage(generateIconView, "/icons/generate.png");
    }

    /**
     * A helper method to load an image and set it to an ImageView.
     * It includes error handling in case an image is not found.
     * @param imageView The ImageView to set the image on.
     * @param path The path to the image within the resources folder.
     */
    private void loadImage(ImageView imageView, String path) {
        try {
            // Use getResourceAsStream which is the standard way to access packaged resources.
            InputStream stream = getClass().getResourceAsStream(path);
            if (stream == null) {
                System.err.println("Cannot load image resource: " + path);
            } else {
                imageView.setImage(new Image(stream));
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            e.printStackTrace();
        }
    }
}
