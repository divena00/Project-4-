package org.example.project4_software;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * Controller for the Chicago Style pizza ordering view.

 * Handles user interactions for selecting pizza type, size,
 * viewing toppings, customizing Build Your Own pizzas, and
 * adding pizzas to the current order.
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class ChicagoStyleController {
    /** ComboBox for selecting pizza type */
    @FXML
    private ComboBox<String> pizzaTypeBox;
    /** Radio buttons for selecting pizza size */
    @FXML
    private RadioButton smallButton, mediumButton, largeButton;
    /** Toggle group for size selection */
    @FXML
    private ToggleGroup sizeGroup;
    /** TextFields to display crust type and price */
    @FXML
    private TextField crustField, priceField;
    /** ListView of all available toppings (for BYO) */
    @FXML
    private ListView<Topping> availableToppingsList;
    /** ListView of selected toppings for the pizza */
    @FXML
    private ListView<Topping> selectedToppingsList;
    /** Buttons for adding/removing toppings, adding pizza, and navigation */
    @FXML
    private Button addToppingButton, removeToppingButton, addToOrderButton, mainMenuButton;
    /** ImageView to display selected pizza image */
    @FXML
    private ImageView pizzaImage;
    /** List of available pizza types */
    private final ObservableList<String> pizzaTypes =
            FXCollections.observableArrayList("Deluxe", "BBQ Chicken", "Meatzza", "Build Your Own");
    /** Factory used to create Chicago-style pizzas */
    private PizzaFactory pizzaFactory;
    /** Currently selected pizza */
    private Pizza currentPizza;
    /**
     * Initializes the controller.
     * Sets up the pizza factory, default selections,
     * and loads initial view data.
     */
    @FXML
    public void initialize() {
        pizzaFactory = new ChicagoPizza();
        pizzaTypeBox.setItems(pizzaTypes);
        pizzaTypeBox.setValue("Deluxe");
        availableToppingsList.setItems(FXCollections.observableArrayList(Topping.values()));
        mediumButton.setSelected(true);
        refreshView();
    }
    /**
     * Handles change in pizza type selection.
     * Refreshes the view accordingly.
     */
    @FXML
    private void handlePizzaTypeChange() {
        refreshView();
    }
    /**
     * Handles change in pizza size selection.
     * Refreshes the view accordingly.
     */
    @FXML
    private void handleSizeChange() {
        refreshView();
    }
    /**
     * Adds a selected topping to a Build Your Own pizza.
     * Updates the toppings list and price dynamically.
     */
    @FXML
    private void handleAddTopping() {
        if (!isBuildYourOwnSelected()) {
            return;
        }
        Topping topping = availableToppingsList.getSelectionModel().getSelectedItem();
        if (topping == null) {
            return;
        }

        if (currentPizza.addTopping(topping)) {
            updateSelectedToppings();
            updatePrice();
        }
    }
    /**
     * Removes a selected topping from a Build Your Own pizza.
     * Updates the toppings list and price dynamically.
     */
    @FXML
    private void handleRemoveTopping() {
        if (!isBuildYourOwnSelected()) {
            return;
        }
        Topping topping = selectedToppingsList.getSelectionModel().getSelectedItem();
        if (topping == null) {
            return;
        }
        if (currentPizza.removeTopping(topping)) {
            updateSelectedToppings();
            updatePrice();
        }
    }
    /**
     * Adds the currently configured pizza to the current order.
     * Copies toppings if it is a Build Your Own pizza.
     */
    @FXML
    private void handleAddToOrder() {
        Pizza pizzaToAdd = createPizzaFromSelection();
        pizzaToAdd.setSize(getSelectedSize());

        if (isBuildYourOwnSelected()) {
            for (Topping topping : currentPizza.getToppings()) {
                pizzaToAdd.addTopping(topping);
            }
        }

        MainController.currentOrder.addPizza(pizzaToAdd);
    }
    /**
     * Navigates back to the main menu view.
     *
     * @param event the action event triggered by the button
     */
    @FXML
    private void handleMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("RU Pizza");
            stage.show();
        } catch (IOException | NullPointerException e) {
            showAlert("Navigation Error", "Could not load main menu.");
        }
    }
    /**
     * Refreshes the entire view based on current selections.
     */
    private void refreshView() {
        currentPizza = createPizzaFromSelection();
        currentPizza.setSize(getSelectedSize());

        updateCrust();
        updateImage();
        updateSelectedToppings();
        updatePrice();
        updateCustomizationControls();
    }
    /**
     * Creates a pizza object based on selected type.
     *
     * @return the created Pizza object
     */
    private Pizza createPizzaFromSelection() {
        String type = pizzaTypeBox.getValue();
        if ("Deluxe".equals(type)) {
            return pizzaFactory.createDeluxe();
        } else if ("BBQ Chicken".equals(type)) {
            return pizzaFactory.createBBQChicken();
        } else if ("Meatzza".equals(type)) {
            return pizzaFactory.createMeatzza();
        } else {
            return pizzaFactory.createBuildYourOwn();
        }
    }
    /**
     * Gets the selected pizza size.
     *
     * @return selected Size enum
     */
    private Size getSelectedSize() {
        if (smallButton.isSelected()) {
            return Size.small;
        } else if (mediumButton.isSelected()) {
            return Size.medium;
        } else {
            return Size.large;
        }
    }
    /**
     * Checks if Build Your Own pizza is selected.
     *
     * @return true if BYO is selected, false otherwise
     */
    private boolean isBuildYourOwnSelected() {
        return "Build Your Own".equals(pizzaTypeBox.getValue());
    }
    /** Updates crust display field */
    private void updateCrust() {
        crustField.setText(Crust.crustInfo(currentPizza.getCrust()));
    }
    /** Updates price display field */
    private void updatePrice() {
        priceField.setText(String.format("%.2f", currentPizza.price()));
    }
    /** Updates selected toppings list */
    private void updateSelectedToppings() {
        selectedToppingsList.getItems().setAll(currentPizza.getToppings());
    }
    /** Enables/disables customization controls for BYO pizzas */
    private void updateCustomizationControls() {
        boolean byo = isBuildYourOwnSelected();
        availableToppingsList.setDisable(!byo);
        addToppingButton.setDisable(!byo);
        removeToppingButton.setDisable(!byo);
    }
    /** Updates pizza image based on selected type */
    private void updateImage() {
        String type = pizzaTypeBox.getValue();
        String imagePath = null;

        if ("Deluxe".equals(type)) {
            imagePath = "/org/example/project4_software/chicago-deluxe.png";
        } else if ("BBQ Chicken".equals(type)) {
            imagePath = "/org/example/project4_software/chicago-bbq.png";
        } else if ("Meatzza".equals(type)) {
            imagePath = "/org/example/project4_software/chicago-meatzza.png";
        } else if ("Build Your Own".equals(type)) {
            imagePath = "/org/example/project4_software/chicago-byo.png";
        }
        try {
            if (imagePath != null) {
                pizzaImage.setImage(new Image(
                        Objects.requireNonNull(getClass().getResourceAsStream(imagePath))
                ));
            } else {
                pizzaImage.setImage(null);
            }
        } catch (Exception e) {
            pizzaImage.setImage(null);
        }
    }
    /**
     * Displays an error alert.
     *
     * @param title alert title
     * @param message alert message
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
