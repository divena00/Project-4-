package org.example.project4_software;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NYStyleController {

    @FXML
    private ComboBox<String> pizzaTypeBox;

    @FXML
    private RadioButton smallButton, mediumButton, largeButton;

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
        pizzaFactory = new NYPizza();

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

        if (pizzaToAdd instanceof BuildYourOwn) {
            for (Topping topping : currentPizza.getToppings()) {
                pizzaToAdd.addTopping(topping);
            }
        }

        MainController.currentOrder.addPizza(pizzaToAdd);
    }
    @FXML
    private void handleMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("RU Pizza");
        stage.show();
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
    private void updateCrust() {
        crustField.setText(currentPizza.getCrust().toString());
    }

    private void updatePrice() {
        priceField.setText(String.format("%.2f", currentPizza.price()));
    }

    private void updateSelectedToppings() {
        selectedToppingsList.setItems(
                FXCollections.observableArrayList(currentPizza.getToppings())
        );
    }
    private void updateCustomizationControls() {
        boolean byo = currentPizza instanceof BuildYourOwn;
        availableToppingsList.setDisable(!byo);
        selectedToppingsList.setDisable(!byo);
        addToppingButton.setDisable(!byo);
        removeToppingButton.setDisable(!byo);
    }
    private void updateImage() {
        String type = pizzaTypeBox.getValue();
        String imagePath = null;

        if ("Deluxe".equals(type)) {
            imagePath = "/org/example/project_4software/ny-deluxe.png";
        } else if ("BBQ Chicken".equals(type)) {
            imagePath = "/org/example/project_4software/ny-bbq.png";
        } else if ("Meatzza".equals(type)) {
            imagePath = "/org/example/project_4software/ny-meatzza.png";
        } else if ("Build Your Own".equals(type)) {
            imagePath = "/org/example/project_4software/ny-byo.png";
        }

        if (imagePath != null) {
            pizzaImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))));
        }
    }
}
