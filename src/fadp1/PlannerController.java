package fadp1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class PlannerController {

    // FXML bindings for ImageViews
    @FXML private ImageView menuIconView;
    @FXML private ImageView plannerIconView;
    @FXML private ImageView groceriesIconView;
    @FXML private ImageView discoverIconView;
    @FXML private ImageView appIconView; // Carrot icon
    @FXML private ImageView editIconView;
    @FXML private ImageView refreshIconView;
    @FXML private ImageView historyIconView;
    @FXML private ImageView settingsIconView;
    @FXML private ImageView breakfastIconView;
    @FXML private ImageView lunchIconView;
    @FXML private ImageView dinnerIconView;
    @FXML private ImageView meal1ImageView;
    @FXML private ImageView meal2ImageView;
    @FXML private ImageView meal3ImageView;
    @FXML private ImageView meal4ImageView;
    @FXML private ImageView warningIconView;

    @FXML
    public void initialize() {
        // Load all images programmatically
        loadAllImages();
    }

    private void loadAllImages() {
        // All icon and image paths are relative to the 'fadp1' package folder.
        // This ensures that the component is self-contained and that resources
        // are loaded correctly from within the package structure.
        loadImage(menuIconView, "icons/menu.png");
        loadImage(plannerIconView, "icons/planner.png");
        loadImage(groceriesIconView, "icons/groceries.png");
        loadImage(discoverIconView, "icons/discover.png");
        loadImage(appIconView, "icons/carrot.png");
        loadImage(editIconView, "icons/edit.png");
        loadImage(refreshIconView, "icons/refresh.png");
        loadImage(historyIconView, "icons/history.png");
        loadImage(settingsIconView, "icons/settings.png");
        loadImage(breakfastIconView, "icons/breakfast.png");
        loadImage(lunchIconView, "icons/lunch.png");
        loadImage(dinnerIconView, "icons/dinner.png");
        loadImage(warningIconView, "icons/warning.png");

        // Placeholder images for meals
        loadImage(meal1ImageView, "images/meal1.jpeg");
        loadImage(meal2ImageView, "images/meal2.jpeg");
        loadImage(meal3ImageView, "images/meal3.jpeg");
        loadImage(meal4ImageView, "images/meal4.jpeg");
    }

    private void loadImage(ImageView imageView, String path) {
        if (imageView == null) return;
        try {
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
