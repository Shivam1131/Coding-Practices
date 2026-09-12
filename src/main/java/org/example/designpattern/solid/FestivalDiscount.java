package org.example.designpattern.solid;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FestivalDiscount implements DiscountPolicy {
    private final BigDecimal percentage;

    public FestivalDiscount(BigDecimal percentage) {
        if (percentage == null || percentage.signum() < 0 || percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.percentage = percentage;
    }

    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        return subtotal
                .multiply(percentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    @Override
    public String label() {
        return percentage.stripTrailingZeros().toPlainString() + "% festival discount";
    }
}
