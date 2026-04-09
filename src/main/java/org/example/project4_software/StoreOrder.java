package org.example.project4_software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class StoreOrder {
    private ArrayList<Order> orders;
    private ArrayList<Integer> orderNum;

    public StoreOrder(){
        this.orders = new ArrayList<Order>();
        orderNum = new ArrayList<Integer>();
    }
    public ArrayList<Order> getOrders(){
        return orders;
    }
    public ArrayList<Integer> getOrderNum(){
        orderNum.clear();
        for (Order order : orders) {
            orderNum.add(order.getOrderNum());
        }
        return orderNum;
    }
    public Order search(String orderNum){
        for (Order order : orders) {
            if (String.valueOf(order.getOrderNum()).equals(orderNum)) {
                return order;
            }
        }
        return null;
    }
    public boolean addOrder(Order order) {
        if (order == null) {
            return false;
        }
        orders.add(order);
        return true;
    }
    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }


}
