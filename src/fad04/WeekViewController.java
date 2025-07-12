package fad04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class WeekViewController {

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

    // FXML binding for the PieChart
    @FXML private PieChart nutritionPieChart;

    @FXML
    public void initialize() {
        // Load all images programmatically
        loadAllImages();

        // Populate the PieChart with data from the image
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Fat 0%", 0),
                        new PieChart.Data("Carbs 0%", 0),
                        new PieChart.Data("Protein 0%", 0));

        nutritionPieChart.setData(pieChartData);
        nutritionPieChart.setLabelsVisible(false); // Hide default labels
        nutritionPieChart.setStartAngle(90); 
        
        // FIXED: Set legend visibility from the controller for more robustness.
        nutritionPieChart.setLegendVisible(true);
    }

    private void loadAllImages() {
        loadImage(menuIconView, "/icons/menu.png");
        loadImage(plannerIconView, "/icons/planner.png");
        loadImage(groceriesIconView, "/icons/groceries.png");
        loadImage(discoverIconView, "/icons/discover.png");
        loadImage(appIconView, "/icons/carrot.png");
        loadImage(editIconView, "/icons/edit.png");
        loadImage(refreshIconView, "/icons/refresh.png");
        loadImage(historyIconView, "/icons/history.png");
        loadImage(settingsIconView, "/icons/settings.png");
        loadImage(breakfastIconView, "/icons/breakfast.png");
        loadImage(lunchIconView, "/icons/lunch.png");
        loadImage(dinnerIconView, "/icons/dinner.png");
        loadImage(warningIconView, "/icons/warning.png");

        // Placeholder images for meals
        loadImage(meal1ImageView, "/images/meal1.jpeg");
        loadImage(meal2ImageView, "/images/meal2.jpeg");
        loadImage(meal3ImageView, "/images/meal3.jpeg");
        loadImage(meal4ImageView, "/images/meal4.jpeg");
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
