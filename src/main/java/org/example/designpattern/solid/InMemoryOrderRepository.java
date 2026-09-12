package org.example.designpattern.solid;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    private final List<String> savedOrders = new ArrayList<>();

    @Override
    public void save(Order order, PaymentReceipt paymentReceipt) {
        savedOrders.add(order.id() + " paid using " + paymentReceipt.paymentMode());
    }

    public List<String> savedOrders() {
        return List.copyOf(savedOrders);
    }
}
