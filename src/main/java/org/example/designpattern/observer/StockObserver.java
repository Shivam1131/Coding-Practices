package org.example.designpattern.observer;

import java.math.BigDecimal;

public interface StockObserver {
    void update(String symbol, BigDecimal price);
}
