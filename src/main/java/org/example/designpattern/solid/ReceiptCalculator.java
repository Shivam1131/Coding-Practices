package org.example.designpattern.solid;

import java.math.BigDecimal;

public class ReceiptCalculator {
    public BigDecimal subtotal(Order order) {
        return order.items()
                .stream()
                .map(OrderItem::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
