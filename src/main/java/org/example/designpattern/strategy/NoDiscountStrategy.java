package org.example.designpattern.strategy;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal discount(BigDecimal amount) {
        return BigDecimal.ZERO;
    }
}
