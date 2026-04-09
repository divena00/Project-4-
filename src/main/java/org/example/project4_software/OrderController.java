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
    @FXML
    private void handleMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("RU Pizza");
        stage.show();
    }
}


