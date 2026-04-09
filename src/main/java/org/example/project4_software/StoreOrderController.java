package org.example.project4_software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * Controller for the store orders view.
 * Displays all placed orders, allows selection, refresh, and cancellation.
 */
public class StoreOrderController {

    @FXML
    private ComboBox<String> orderNumberBox;

    @FXML
    private TextArea orderDetailsArea;

    @FXML
    private TextField orderTotalFeild;

    /**
     * Initializes the view by loading placed order numbers.
     */
    @FXML
    public void initialize() {
        refreshOrderNumbers();
        clearView();
    }

    /**
     * Reloads the order numbers from the shared store orders object.
     */
    private void refreshOrderNumbers() {
        orderNumberBox.getItems().clear();

        for (Order order : MainController.storeOrders.getOrders()) {
            orderNumberBox.getItems().add(String.valueOf(order.getOrderNum()));
        }
    }

    /**
     * Handles selection of an order number from the combo box.
     */
    @FXML
    private void handleSelectOrder() {
        String selected = orderNumberBox.getValue();

        if (selected == null) {
            clearView();
            return;
        }

        Order order = MainController.storeOrders.search(selected);

        if (order == null) {
            clearView();
            printLine("Order not found.");
            return;
        }

        displayOrder(order);
    }

    /**
     * Displays the selected order's details and total.
     *
     * @param order selected order
     */
    private void displayOrder(Order order) {
        orderDetailsArea.clear();

        orderDetailsArea.appendText("Order #" + order.getOrderNum() + "\n");

        for (Pizza pizza : order.getPizzaOrder()) {
            orderDetailsArea.appendText(pizza.toString() + "\n");
        }

        orderDetailsArea.appendText(String.format("\nOrder Total: $%.2f", order.getTotal()));
        orderTotalFeild.setText(String.format("$%.2f", order.getTotal()));
    }

    /**
     * Cancels the selected order and removes it from store orders.
     */
    @FXML
    private void handleCancelOrder() {
        String selected = orderNumberBox.getValue();

        if (selected == null) {
            printLine("No order selected.");
            return;
        }

        Order order = MainController.storeOrders.search(selected);

        if (order == null) {
            printLine("Order not found.");
            return;
        }

        MainController.storeOrders.removeOrder(order);

        refreshOrderNumbers();
        clearView();
        printLine("Order #" + selected + " canceled.");
    }

    /**
     * Refresh button handler.
     */
    @FXML
    private void handleRefresh() {
        refreshOrderNumbers();
        clearView();
    }

    /**
     * Clears displayed order details.
     */
    private void clearView() {
        orderDetailsArea.clear();
        orderTotalFeild.clear();
        orderNumberBox.setValue(null);
    }

    /**
     * Appends a message to the order details area.
     *
     * @param message message to display
     */
    private void printLine(String message) {
        orderDetailsArea.appendText(message + "\n");
    }

    /**
     * Returns to the main menu view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    private void handleMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("RU Pizza");
        stage.show();
    }
    /**
     * Exports all placed orders to a text file.
     *
     * @param event action event
     */
    @FXML
    private void handleExportOrders(ActionEvent event) {
        if (MainController.storeOrders.getOrders().isEmpty()) {
            printLine("No orders to export.");
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Orders");
        fileChooser.setInitialFileName("orders.txt");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            printLine("Export canceled.");
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Order order : MainController.storeOrders.getOrders()) {
                writer.write("Order #" + order.getOrderNum() + "\n");

                for (Pizza pizza : order.getPizzaOrder()) {
                    writer.write(pizza.toString() + "\n");
                }

                writer.write(String.format("Order Total: $%.2f%n", order.getTotal()));
                writer.write("\n");
            }

            printLine("Orders exported to " + file.getName());
        } catch (IOException e) {
            printLine("Error exporting orders.");
        }
    }
}
