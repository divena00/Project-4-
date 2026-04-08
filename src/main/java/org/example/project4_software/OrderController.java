package org.example.project4_software;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * Controller for managing orders (current + placed orders)
 */
public class OrderController {

    private Order currentOrder = new Order(); // current working order
    private ArrayList<Order> storeOrders = new ArrayList<>(); // all placed orders
    @FXML
    private ListView<String> pizzaListView;

    @FXML
    private TextArea orderDetailsArea;

    @FXML
    private TextField subtotalFeild;

    @FXML
    private TextField taxFeild;

    @FXML
    private TextField totalFeild;
    /**
     * Adds a pizza to current order
     */
    public void addPizza(Pizza pizza) {
        if (pizza == null) {
            printLine("Invalid pizza.");
            return;
        }

        currentOrder.addPizza(pizza);
        updateView();
    }
    /**
     * Removes selected pizza from current order
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
     * Clears all pizzas in current order
     */
    @FXML
    private void handleClearOrder() {
        currentOrder = new Order();
        updateView();
    }

    /**
     * Places the current order
     */
    @FXML
    private void handlePlaceOrder() {
        if (currentOrder.getPizzaOrder().isEmpty()) {
            printLine("Cannot place empty order.");
            return;
        }

        storeOrders.add(currentOrder);

        printLine("Order #" + currentOrder.getOrderNum() + " placed.");

        currentOrder = new Order(); // reset new order
        updateView();
    }
    /**
     * Cancels an order from store orders
     */
    @FXML
    private void handleCancelOrder() {
        if (storeOrders.isEmpty()) {
            printLine("No orders to cancel.");
            return;
        }
        Order removed = storeOrders.remove(storeOrders.size() - 1);
        printLine("Order #" + removed.getOrderNum() + " canceled.");
    }
    /**
     * Updates GUI view dynamically
     */
    private void updateView() {
        pizzaListView.getItems().clear();
        for (Pizza p : currentOrder.getPizzaOrder()) {
            pizzaListView.getItems().add(p.toString());
        }
        subtotalFeild.setText(String.format("$%.2f", currentOrder.getSubtotal()));
        taxFeild.setText(String.format("$%.2f", currentOrder.getTaxRate()));
        totalFeild.setText(String.format("$%.2f", currentOrder.getTotal()));
        orderDetailsArea.setText(currentOrder.toString());
    }

    /**
     * Helper method to print to GUI instead of System.out
     */
    private void printLine(String message) {
        orderDetailsArea.appendText(message + "\n");
    }
    /**
     * Shows all placed orders (for "View Orders" tab)
     */
    @FXML
    private void handleViewOrders() {
        orderDetailsArea.clear();
        if (storeOrders.isEmpty()) {
            printLine("No orders placed.");
            return;
        }
        for (Order order : storeOrders) {
            orderDetailsArea.appendText(
                    "Order #" + order.getOrderNum() + "\n" +
                            order.toString() +
                            String.format("Total: $%.2f\n\n", order.getTotal())
            );
        }
    }
}



