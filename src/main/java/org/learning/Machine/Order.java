package org.learning.Machine;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<Integer, Integer> orderMap;
    private int totalAmount;

    public Order() {
        this.orderMap = new HashMap<>();
        this.totalAmount = 0;
    }

    public Map<Integer, Integer> getOrderMap() {
        return orderMap;
    }

    public void addToOrder(int productId, Product product) {
        orderMap.put(productId,
                orderMap.getOrDefault(orderMap.get(productId), 0) + 1);
        totalAmount += product.getPrice();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

}
