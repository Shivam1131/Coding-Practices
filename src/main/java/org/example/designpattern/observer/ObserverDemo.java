package org.example.designpattern.observer;

import java.math.BigDecimal;

public class ObserverDemo {
    public static void main(String[] args) {
        StockPriceTracker tracker = new StockPriceTracker("TCS", new BigDecimal("3500.00"));

        StockObserver emailAlert = new EmailStockAlert("student@example.com");
        StockObserver mobileAlert = new MobileStockAlert("Sada");

        tracker.addObserver(emailAlert);
        tracker.addObserver(mobileAlert);

        tracker.setPrice(new BigDecimal("3565.50"));

        tracker.removeObserver(emailAlert);
        tracker.setPrice(new BigDecimal("3601.25"));
    }
}
