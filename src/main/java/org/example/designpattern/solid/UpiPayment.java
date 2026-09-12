package org.example.designpattern.solid;

import java.math.BigDecimal;

public class UpiPayment implements PaymentMethod {
    private final String upiId;

    public UpiPayment(String upiId) {
        if (upiId == null || !upiId.contains("@")) {
            throw new IllegalArgumentException("Valid UPI id is required");
        }
        this.upiId = upiId;
    }

    @Override
    public PaymentReceipt pay(BigDecimal amount) {
        return new PaymentReceipt("UPI " + upiId, amount, "UPI-" + System.nanoTime());
    }
}
