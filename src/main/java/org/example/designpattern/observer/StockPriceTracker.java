package org.example.designpattern.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StockPriceTracker {
    private final String symbol;
    private final List<StockObserver> observers = new ArrayList<>();
    private BigDecimal price;

    public StockPriceTracker(String symbol, BigDecimal initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(symbol, price);
        }
    }
}
