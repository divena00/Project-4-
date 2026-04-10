package org.example.project4_software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
/**
 * Controller for the Current Order view.
 * Handles adding, removing, clearing, and placing orders,
 * as well as displaying order details and totals.
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class OrderController {
    /** Current active order */
    private Order currentOrder;
    /** List of pizzas in the order */
    @FXML
    private ListView<String> pizzaListView;
    /** Displays order details */
    @FXML
    private TextArea orderDetailsArea;
    /** Displays subtotal, tax, and total */
    @FXML
    private TextField subtotalFeild, taxFeild, totalFeild;

    /**
     * Initializes the controller and loads the current order.
     */
    @FXML
    public void initialize() {
        currentOrder = MainController.currentOrder;
        updateView();
    }
    /**
     * Adds a pizza to the current order.
     *
     * @param pizza the pizza to add
     */
    public void addPizza(Pizza pizza) {
        if (pizza == null) {
            printLine("Invalid pizza.");
            return;
        }
        MainController.currentOrder.addPizza(pizza);
        currentOrder = MainController.currentOrder;
        updateView();
    }
    /**
     * Removes the selected pizza from the order.
     */
    @FXML
    private void handleRemovePizza() {
        int index = pizzaListView.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            printLine("No pizza selected.");
            return;
        }
        Pizza pizza = currentOrder.getPizzaOrder().get(index);
        currentOrder.removePizza(pizza);
        updateView();
    }
    /**
     * Clears the current order.
     */
    @FXML
    private void handleClearOrder() {
        MainController.currentOrder = new Order();
        currentOrder = MainController.currentOrder;
        updateView();
    }
    /**
     * Places the current order and stores it.
     */
    @FXML
    private void handlePlaceOrder() {
        if (currentOrder == null || currentOrder.getPizzaOrder().isEmpty()) {
            printLine("Cannot place empty order.");
            return;
        }

        MainController.storeOrders.addOrder(currentOrder);

        int placedNumber = currentOrder.getOrderNum();

        MainController.currentOrder = new Order();
        currentOrder = MainController.currentOrder;

        printLine("Order #" + placedNumber + " placed.");
        updateView();
    }
    /**
     * Updates the GUI with current order details and totals.
     */
    private void updateView() {
        pizzaListView.getItems().clear();
        orderDetailsArea.clear();

        for (Pizza p : currentOrder.getPizzaOrder()) {
            pizzaListView.getItems().add(p.toString());
            orderDetailsArea.appendText(p.toString() + "\n");
        }

        subtotalFeild.setText(String.format("$%.2f", currentOrder.getSubtotal()));
        taxFeild.setText(String.format("$%.2f", currentOrder.getTax())); // or getSalesTax()
        totalFeild.setText(String.format("$%.2f", currentOrder.getTotal()));
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
     * Displays all placed orders.
     */

    @FXML
    private void handleViewOrders() {
        orderDetailsArea.clear();
        if (MainController.storeOrders.getOrders().isEmpty()) {
            printLine("No orders placed.");
            return;
        }
        for (Order order : MainController.storeOrders.getOrders()) {
            orderDetailsArea.appendText(
                    "Order #" + order.getOrderNum() + "\n" +
                            order.toString() +
                            String.format("Total: $%.2f\n\n", order.getTotal())
            );
        }
    }
    /**
     * Navigates back to the main menu.
     *
     * @param event button click event
     * @throws IOException if FXML fails to load
     */
    @FXML
    private void handleMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("RU Pizza");
        stage.show();
    }
}


