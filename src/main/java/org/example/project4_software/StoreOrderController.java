package org.example.project4_software;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StoreOrderController {

    public static StoreOrder storeOrder = new StoreOrder();

    // ===== GUI COMPONENTS =====
    @FXML
    private ComboBox<String> orderNumberBox; // dropdown of order numbers

    @FXML
    private TextArea orderDetailsArea;

    @FXML
    private TextField orderTotalFeild;

    // ==========================

    /**
     * Initializes controller (populate order numbers if needed)
     */
    @FXML
    public void initialize() {
        refreshOrderNumbers();
    }

    /**
     * Refresh ComboBox with order numbers
     */
    private void refreshOrderNumbers() {
        orderNumberBox.getItems().clear();

        for (Order order : storeOrder.getOrders()) {
            orderNumberBox.getItems().add(String.valueOf(order.getOrderNum()));
        }
    }

    /**
     * When an order is selected → display details
     */
    @FXML
    private void handleSelectOrder() {
        String selected = orderNumberBox.getValue();

        if (selected == null) {
            printLine("No order selected.");
            return;
        }

        Order order = storeOrder.search(selected);

        if (order == null) {
            printLine("Order not found.");
            return;
        }

        displayOrder(order);
    }

    /**
     * Display selected order info
     */
    private void displayOrder(Order order) {
        orderDetailsArea.clear();

        orderDetailsArea.appendText(
                "Order #" + order.getOrderNum() + "\n" +
                        order.toString()
        );

        orderTotalFeild.setText(String.format("$%.2f", order.getTotal()));
    }

    /**
     * Cancel/remove selected order
     */
    @FXML
    private void handleCancelOrder() {
        String selected = orderNumberBox.getValue();

        if (selected == null) {
            printLine("No order selected.");
            return;
        }

        Order order = storeOrder.search(selected);

        if (order == null) {
            printLine("Order not found.");
            return;
        }

        storeOrder.removeOrder(order);

        printLine("Order #" + selected + " canceled.");

        refreshOrderNumbers();
        clearView();
    }
    /**
     * Add order (called from OrderController when placing order)
     */
    public void addOrder(Order order) {
        storeOrder.addOrder(order);
        refreshOrderNumbers();
    }
    /**
     * Clear display
     */
    private void clearView() {
        orderDetailsArea.clear();
        orderTotalFeild.setText("");
    }
    /**
     * Print helper (GUI-safe)
     */
    private void printLine(String message) {
        orderDetailsArea.appendText(message + "\n");
    }
}
