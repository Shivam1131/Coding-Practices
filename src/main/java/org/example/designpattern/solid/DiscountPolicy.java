package org.example.designpattern.solid;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal apply(BigDecimal subtotal);

    String label();
}
