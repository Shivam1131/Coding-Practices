package org.example.designpattern.observer;

import java.math.BigDecimal;

public class EmailStockAlert implements StockObserver {
    private final String email;

    public EmailStockAlert(String email) {
        this.email = email;
    }

    @Override
    public void update(String symbol, BigDecimal price) {
        System.out.println("Email to " + email + ": " + symbol + " is now Rs." + price);
    }
}
