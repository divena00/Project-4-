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
public class ChicagoStyleController {
    @FXML
    private ComboBox<String> pizzaTypeBox;
    @FXML
    private RadioButton smallButton, mediumButton, largeButton;
    @FXML
    private ToggleGroup sizeGroup;
    @FXML
    private TextField crustField, priceField;
    @FXML
    private ListView<Topping> availableToppingsList;
    @FXML
    private ListView<Topping> selectedToppingsList;
    @FXML
    private Button addToppingButton, removeToppingButton, addToOrderButton, mainMenuButton;
    @FXML
    private ImageView pizzaImage;
    private final ObservableList<String> pizzaTypes =
            FXCollections.observableArrayList("Deluxe", "BBQ Chicken", "Meatzza", "Build Your Own");
    private PizzaFactory pizzaFactory;
    private Pizza currentPizza;
    @FXML
    public void initialize() {
        pizzaFactory = new ChicagoPizza();
        pizzaTypeBox.setItems(pizzaTypes);
        pizzaTypeBox.setValue("Deluxe");
        availableToppingsList.setItems(FXCollections.observableArrayList(Topping.values()));
        mediumButton.setSelected(true);
        refreshView();
    }
    @FXML
    private void handlePizzaTypeChange() {
        refreshView();
    }
    @FXML
    private void handleSizeChange() {
        refreshView();
    }
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
    private void refreshView() {
        currentPizza = createPizzaFromSelection();
        currentPizza.setSize(getSelectedSize());

        updateCrust();
        updateImage();
        updateSelectedToppings();
        updatePrice();
        updateCustomizationControls();
    }
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
    private Size getSelectedSize() {
        if (smallButton.isSelected()) {
            return Size.small;
        } else if (mediumButton.isSelected()) {
            return Size.medium;
        } else {
            return Size.large;
        }
    }
    private boolean isBuildYourOwnSelected() {
        return "Build Your Own".equals(pizzaTypeBox.getValue());
    }
    private void updateCrust() {
        crustField.setText(Crust.crustInfo(currentPizza.getCrust()));
    }
    private void updatePrice() {
        priceField.setText(String.format("%.2f", currentPizza.price()));
    }
    private void updateSelectedToppings() {
        selectedToppingsList.getItems().setAll(currentPizza.getToppings());
    }
    private void updateCustomizationControls() {
        boolean byo = isBuildYourOwnSelected();
        availableToppingsList.setDisable(!byo);
        addToppingButton.setDisable(!byo);
        removeToppingButton.setDisable(!byo);
    }
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
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
