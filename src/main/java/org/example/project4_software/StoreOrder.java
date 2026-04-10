package org.example.project4_software;
import java.util.ArrayList;
/**
 * This class represents the store's collection of all placed orders.
 * It maintains a list of orders and provides methods to manage them.
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class StoreOrder {
    private ArrayList<Order> orders;
    private ArrayList<Integer> orderNum;
    /**
     * Constructor initializes empty order list and order number list.
     */
    public StoreOrder(){
        this.orders = new ArrayList<Order>();
        orderNum = new ArrayList<Integer>();
    }
    /**
     * Returns a list of all order numbers.
     * Clears and rebuilds the list each time to avoid duplicates.
     *
     * @return ArrayList of order numbers (Integer)
     */
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
    /**
     * Searches for an order by its order number.
     *
     * @param orderNum the order number as a String
     * @return the matching Order object if found, otherwise null
     */
    public Order search(String orderNum){
        for (Order order : orders) {
            if (String.valueOf(order.getOrderNum()).equals(orderNum)) {
                return order;
            }
        }
        return null;
    }
    /**
     * Adds a new order to the store.
     *
     * @param order the Order object to add
     * @return true if successfully added, false if order is null
     */
    public boolean addOrder(Order order) {
        if (order == null) {
            return false;
        }
        orders.add(order);
        return true;
    }
    /**
     * Removes an order from the store.
     *
     * @param order the Order object to remove
     * @return true if the order was successfully removed, false otherwise
     */
    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }


}
