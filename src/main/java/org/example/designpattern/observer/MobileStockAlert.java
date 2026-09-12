package org.example.designpattern.observer;

import java.math.BigDecimal;

public class MobileStockAlert implements StockObserver {
    private final String userName;

    public MobileStockAlert(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String symbol, BigDecimal price) {
        System.out.println("Mobile alert for " + userName + ": " + symbol + " changed to Rs." + price);
    }
}
