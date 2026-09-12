package org.example.designpattern.strategy;

import java.math.BigDecimal;

public class FlatDiscountStrategy implements DiscountStrategy {
    private final BigDecimal discountAmount;

    public FlatDiscountStrategy(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public BigDecimal discount(BigDecimal amount) {
        return discountAmount.min(amount);
    }
}
