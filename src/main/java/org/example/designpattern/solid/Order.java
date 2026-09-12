package org.example.designpattern.solid;

import java.util.List;

public record Order(String id, String customerEmail, List<OrderItem> items) {
    public Order {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Order id is required");
        }
        if (customerEmail == null || customerEmail.isBlank()) {
            throw new IllegalArgumentException("Customer email is required");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        items = List.copyOf(items);
    }
}
