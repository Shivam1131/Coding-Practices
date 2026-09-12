package org.example.designpattern.solid;

import java.math.BigDecimal;

public class NoDiscount implements DiscountPolicy {
    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        return BigDecimal.ZERO;
    }

    @Override
    public String label() {
        return "No discount";
    }
}
