package org.example.designpattern.solid;

import java.math.BigDecimal;

public record OrderItem(String name, int quantity, BigDecimal unitPrice) {
    public OrderItem {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (unitPrice == null || unitPrice.signum() < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
    }

    public BigDecimal total() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
