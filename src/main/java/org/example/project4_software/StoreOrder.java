package org.example.project4_software;

import java.util.ArrayList;

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
