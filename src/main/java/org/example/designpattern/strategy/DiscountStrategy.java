package org.example.designpattern.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal discount(BigDecimal amount);
}
