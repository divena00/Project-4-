package org.example.project4_software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main view.
 * Handles navigation between the different views in one stage.
 */
public class MainController {

    /**
     * Stage used for scene switching.
     */
    private Stage stage;

    /**
     * Scene used for scene switching.
     */
    private Scene scene;

    /**
     * Root node loaded from FXML.
     */
    private Parent root;

    /**
     * Shared placed-orders object for the whole application.
     */
    public static StoreOrder storeOrders = new StoreOrder();

    /**
     * Shared current order object.
     */
    public static Order currentOrder = new Order();

    /**
     * Opens the main view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    public void openMainView(ActionEvent event) throws IOException {
        switchScene(event, "main-view.fxml");
    }

    /**
     * Opens the New York pizza ordering view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    public void openNYPizzaView(ActionEvent event) throws IOException {
        switchScene(event, "ny-pizza-view.fxml");
    }

    /**
     * Opens the Chicago pizza ordering view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    public void openChicagoPizzaView(ActionEvent event) throws IOException {
        switchScene(event, "chicago-pizza-view.fxml");
    }

    /**
     * Opens the current-order view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    public void openCurrentOrderView(ActionEvent event) throws IOException {
        switchScene(event, "current-order-view.fxml");
    }

    /**
     * Opens the placed/store-orders view.
     *
     * @param event action event
     * @throws IOException if FXML cannot be loaded
     */
    @FXML
    public void openStoreOrdersView(ActionEvent event) throws IOException {
        switchScene(event, "store-orders-view.fxml");
    }

    /**
     * Loads an FXML file and switches the current stage to it.
     *
     * @param event    action event from the clicked button
     * @param fxmlFile FXML file name in resources
     * @throws IOException if FXML cannot be loaded
     */
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("RU Pizza");
        stage.show();
    }
}
