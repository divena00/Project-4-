package org.example.project4_software;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderController {

    private Order currentOrder;

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

    @FXML
    public void initialize() {
        currentOrder = MainController.currentOrder;
        updateView();
    }

    public void addPizza(Pizza pizza) {
        if (pizza == null) {
            printLine("Invalid pizza.");
            return;
        }

        MainController.currentOrder.addPizza(pizza);
        currentOrder = MainController.currentOrder;
        updateView();
    }

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

    @FXML
    private void handleClearOrder() {
        MainController.currentOrder = new Order();
        currentOrder = MainController.currentOrder;
        updateView();
    }

    @FXML
    private void handlePlaceOrder() {
        if (currentOrder.getPizzaOrder().isEmpty()) {
            printLine("Cannot place empty order.");
            return;
        }

        MainController.storeOrders.addOrder(currentOrder);

        printLine("Order #" + currentOrder.getOrderNum() + " placed.");

        MainController.currentOrder = new Order();
        currentOrder = MainController.currentOrder;
        updateView();
    }

    private void updateView() {
        pizzaListView.getItems().clear();

        for (Pizza p : MainController.currentOrder.getPizzaOrder()) {
            pizzaListView.getItems().add(p.toString());
        }

        subtotalFeild.setText(String.format("$%.2f", MainController.currentOrder.getSubtotal()));
        taxFeild.setText(String.format("$%.2f", MainController.currentOrder.getTaxRate()));
        totalFeild.setText(String.format("$%.2f", MainController.currentOrder.getTotal()));
        orderDetailsArea.setText(MainController.currentOrder.toString());
    }

    private void printLine(String message) {
        orderDetailsArea.appendText(message + "\n");
    }

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
}


