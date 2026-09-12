package org.example.designpattern.strategy;

import java.math.BigDecimal;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal finalAmount(BigDecimal amount) {
        return amount.subtract(discountStrategy.discount(amount));
    }
}
