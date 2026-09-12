package org.example.designpattern.solid;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    private final String lastFourDigits;

    public CardPayment(String lastFourDigits) {
        if (lastFourDigits == null || lastFourDigits.length() != 4) {
            throw new IllegalArgumentException("Card last four digits are required");
        }
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public PaymentReceipt pay(BigDecimal amount) {
        return new PaymentReceipt("Card ending " + lastFourDigits, amount, "CARD-" + System.nanoTime());
    }
}
